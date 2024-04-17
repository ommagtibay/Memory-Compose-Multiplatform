package game.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import com.moriatsushi.insetsx.statusBarsPadding
import util.Card
import util.CardSize
import game.presentation.components.GameBoard
import memory.composeapp.generated.resources.Res
import memory.composeapp.generated.resources.app_name
import memory.composeapp.generated.resources.ic_back
import memory.composeapp.generated.resources.button_no
import memory.composeapp.generated.resources.button_yes
import memory.composeapp.generated.resources.gotham_rounded_bold
import memory.composeapp.generated.resources.img_footer
import memory.composeapp.generated.resources.img_logo
import memory.composeapp.generated.resources.msg_again
import memory.composeapp.generated.resources.msg_quit
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import game.components.PopupDialog
import org.jetbrains.compose.resources.StringResource
import game.presentation.components.TopBar
import theme.AppColor

@OptIn(ExperimentalResourceApi::class)
data class GameScreen(
    val subTitle: StringResource,
    val background: Color = AppColor.VegasGold,
    val size: Int = CardSize.TEST.value,
    val onClick: () -> Unit
) : Screen {
    @OptIn(ExperimentalResourceApi::class)
    @Composable
    override fun Content() {
        var showQuitDialog by remember { mutableStateOf(false) }
        var showStartDialog by remember { mutableStateOf(false) }
        var start by remember { mutableStateOf(false) }

        Scaffold(
            topBar = {
                TopBar(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(background)
                        .padding(horizontal = 16.dp)
                        .statusBarsPadding()
                        .padding(top = 10.dp),
                    title = Res.string.app_name,
                    subTitle = subTitle,
                    iconResource = Res.drawable.ic_back,
                    fontResource = Res.font.gotham_rounded_bold,
                    onClick = { showQuitDialog = true }
                )
            }
        ) {
            Box(
                modifier = Modifier.fillMaxSize()
                    .background(background)
            ) {
                Image(
                    modifier = Modifier.fillMaxWidth()
                        .align(Alignment.BottomCenter),
                    painter = painterResource(Res.drawable.img_footer),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth
                )

                GameBoard(
                    card = Card(size = size),
                    start = start,
                    onDone = {
                        showStartDialog = true
                    }
                )
            }
        }

        if (showQuitDialog) {
            PopupDialog(
                message = Res.string.msg_quit,
                confirmText = Res.string.button_yes,
                dismissText = Res.string.button_no,
                backgroundColor = AppColor.PuceRed,
                fontResource = Res.font.gotham_rounded_bold,
                logoResource = Res.drawable.img_logo,
                onConfirm = {
                    onClick()
                    showQuitDialog = false
                },
                onDismiss = {
                    showQuitDialog = false
                }
            )
        }

        if (showStartDialog) {
            PopupDialog(
                message = Res.string.msg_again,
                confirmText = Res.string.button_yes,
                dismissText = Res.string.button_no,
                backgroundColor = AppColor.FernGreen,
                fontResource = Res.font.gotham_rounded_bold,
                fontSize = 28.sp,
                logoResource = Res.drawable.img_logo,
                onConfirm = {
                    start = !start
                    showStartDialog = false
                },
                onDismiss = {
                    onClick()
                    showStartDialog = false
                }
            )
        }
    }
}