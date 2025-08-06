package com.steeplesoft.giftbook

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation

@Composable
fun RootContent(
    component: RootComponent,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Children(
            stack = component.stack,
            modifier = modifier.padding(5.dp),
            animation = stackAnimation(slide()),
        ) {
            val childModifier = modifier.fillMaxWidth().padding(10.dp)
            when (val component = it.instance) {
                is GreeterComponent -> greeter(component, childModifier)
            }
        }
    }
}
