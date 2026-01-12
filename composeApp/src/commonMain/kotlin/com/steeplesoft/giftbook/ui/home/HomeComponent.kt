package com.steeplesoft.giftbook.ui.home

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.update
import com.arkivanov.essenty.lifecycle.doOnResume
import com.steeplesoft.giftbook.database.db
import com.steeplesoft.giftbook.model.Occasion
import com.steeplesoft.giftbook.model.OccasionProgress
import com.steeplesoft.giftbook.ui.general.Status
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch

class HomeComponent(
    componentContext: ComponentContext,
    var occasionId: Long? = null
) : ComponentContext by componentContext {
    private val giftIdeaDao = db.giftIdeaDao()
    private val occasionDao = db.occasionDao()
    private val recipientDao = db.recipientDao()

    var occasions = MutableValue(listOf<Occasion>())
    var requestStatus = MutableValue(Status.LOADING)
    var occasionProgress: MutableValue<List<OccasionProgress>> = MutableValue(mutableListOf())
    var occasion: Occasion? = null

    init {
        componentContext.doOnResume {
            CoroutineScope(Dispatchers.IO).launch {
                requestStatus.update { Status.LOADING }

                val list = occasionDao.getFutureOccasions()
                occasion =
                    if (occasionId != null)
                        occasionDao.getOccasion(occasionId!!)
                    else
                        list.firstOrNull()

                occasions.update { list }

                occasion?.let {
                    onOccasionChange(it)
                }

                requestStatus.update { Status.SUCCESS }
            }
        }
    }

    fun onOccasionChange(newValue: Occasion) {
        CoroutineScope(Dispatchers.IO).launch {
            occasion = newValue
            val list = recipientDao.getRecipientsForOccasion(newValue.id).map {
                val ideas = giftIdeaDao.lookupIdeasByRecipAndOccasion(it.recipientId, newValue.id)
                OccasionProgress(
                    recipientDao.getRecipient(it.recipientId),
                    newValue.id,
                    targetCount = it.targetCount,
                    actualCount = ideas.filter { idea -> idea.occasionId != null }.size,
                    actualCost = ideas.sumOf { idea -> idea.actualCost ?: 0 },
                    targetCost = it.targetCost
                )
            }

            occasionProgress.update { list }
        }
    }
}
