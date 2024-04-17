package game.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import memory.composeapp.generated.resources.Res
import memory.composeapp.generated.resources.ic_logo
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import theme.AppColor

@OptIn(ExperimentalResourceApi::class)
@Composable
fun FrontCard() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColor.Snow)
            .padding(16.dp),
        contentAlignment = Alignment.Center,
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(resource = Res.drawable.ic_logo),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }
}