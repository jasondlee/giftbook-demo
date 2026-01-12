package com.steeplesoft.giftbook.ui.root

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.steeplesoft.giftbook.ui.home.Home
import com.steeplesoft.giftbook.ui.home.HomeComponent
import giftbook_demo.composeapp.generated.resources.Res
import giftbook_demo.composeapp.generated.resources.app_name
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RootContent(
    component: RootComponent,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(
                        text = stringResource(Res.string.app_name),
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }
            )
        }
    ) { innerPadding ->
        Children(
            stack = component.stack,
            modifier = modifier.padding(innerPadding).padding(5.dp),
            animation = stackAnimation(slide()),
        ) {
            val childModifier = modifier.fillMaxWidth().padding(10.dp)
            when (val component = it.instance) {
                is HomeComponent -> Home(component, childModifier)
            }
        }
    }
}
