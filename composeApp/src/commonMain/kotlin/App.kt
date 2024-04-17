import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import com.moriatsushi.insetsx.SystemBarsBehavior
import com.moriatsushi.insetsx.rememberWindowInsetsController
import menu.presentation.MenuScreen
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import memory.composeapp.generated.resources.Res
import memory.composeapp.generated.resources.button_no
import memory.composeapp.generated.resources.button_yes
import memory.composeapp.generated.resources.gotham_rounded_bold
import memory.composeapp.generated.resources.img_logo
import memory.composeapp.generated.resources.msg_quit
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.ui.tooling.preview.Preview
import game.components.PopupDialog
import theme.AppColor

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun App() {
    MaterialTheme {
        Napier.base(DebugAntilog())

        var navigator = LocalNavigator.current
        val windowInsetsController = rememberWindowInsetsController()

        var showDialog by remember {
            mutableStateOf(false)
        }

        LaunchedEffect(Unit) {
            windowInsetsController?.apply {
                setStatusBarContentColor(dark = false)
                setIsNavigationBarsVisible(false)
                setSystemBarsBehavior(SystemBarsBehavior.Immersive)
            }
        }

        MaterialTheme {
            Navigator(
                screen = MenuScreen(),
                onBackPressed = { currentScreen ->
                    if (currentScreen == MenuScreen()) {
                        true
                    } else {
                        showDialog = true

                        false
                    }
                }
            ) { nav ->
                CurrentScreen()
                navigator = nav
            }
        }

        if (showDialog) {
            PopupDialog(
                message = Res.string.msg_quit,
                confirmText = Res.string.button_yes,
                dismissText = Res.string.button_no,
                backgroundColor = AppColor.PuceRed,
                fontResource = Res.font.gotham_rounded_bold,
                logoResource = Res.drawable.img_logo,
                onConfirm = {
                    navigator?.pop()
                    showDialog = false
                },
                onDismiss = {
                    showDialog = false
                }
            )
        }
    }
}