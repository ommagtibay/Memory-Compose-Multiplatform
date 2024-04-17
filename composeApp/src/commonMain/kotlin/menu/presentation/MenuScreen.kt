package menu.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import com.moriatsushi.insetsx.statusBarsPadding
import memory.composeapp.generated.resources.Res
import memory.composeapp.generated.resources.img_footer
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import menu.presentation.components.MenuView
import theme.AppColor

class MenuScreen : Screen {
    @OptIn(ExperimentalResourceApi::class)
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(AppColor.InternationalOrange)
                .statusBarsPadding()
                .padding(top = 10.dp),
        ) {
            Image(
                modifier = Modifier.fillMaxWidth()
                    .align(Alignment.BottomCenter),
                painter = painterResource(Res.drawable.img_footer),
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )

            MenuView(
                navigator = navigator
            )
        }
    }
}

