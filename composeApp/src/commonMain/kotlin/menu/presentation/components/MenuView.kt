package menu.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.Navigator
import util.CardSize
import memory.composeapp.generated.resources.Res
import memory.composeapp.generated.resources.desc_easy
import memory.composeapp.generated.resources.desc_hard
import memory.composeapp.generated.resources.desc_normal
import memory.composeapp.generated.resources.gotham_rounded_medium
import memory.composeapp.generated.resources.ic_level_easy
import memory.composeapp.generated.resources.ic_level_hard
import memory.composeapp.generated.resources.ic_level_normal
import memory.composeapp.generated.resources.img_logo
import memory.composeapp.generated.resources.level_easy
import memory.composeapp.generated.resources.level_hard
import memory.composeapp.generated.resources.level_normal
import memory.composeapp.generated.resources.levels
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import game.presentation.GameScreen
import theme.AppColor

@OptIn(ExperimentalResourceApi::class)
@Composable
fun MenuView(
    navigator: Navigator?
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.fillMaxWidth()
                .weight(0.3f),
            painter = painterResource(Res.drawable.img_logo),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Text(
            modifier = Modifier.fillMaxWidth()
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 16.dp,
                    top = 24.dp
                ),
            text = stringResource(Res.string.levels),
            style = TextStyle(
                color = AppColor.White,
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(Res.font.gotham_rounded_medium))
            )
        )

        Column(
            modifier = Modifier
                .weight(0.7f)
                .padding(top = 10.dp, bottom = 10.dp)
                .padding(horizontal = 16.dp)
        ) {
            MenuButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.3f),
                title = Res.string.level_easy,
                subTitle = Res.string.desc_easy,
                fontResource = Res.font.gotham_rounded_medium,
                iconResource = Res.drawable.ic_level_easy,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = AppColor.OrangeYellow,
                    contentColor = AppColor.White
                ),
                onClick = {
                    navigator?.push(
                        GameScreen(
                            subTitle = Res.string.level_easy,
                            background = AppColor.OrangeYellow,
                            size = CardSize.EASY.value,
                            onClick = {
                                navigator.pop()
                            })
                    )
                }
            )

            MenuButton(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .fillMaxWidth()
                    .weight(0.3f),
                title = Res.string.level_normal,
                subTitle = Res.string.desc_normal,
                fontResource = Res.font.gotham_rounded_medium,
                iconResource = Res.drawable.ic_level_normal,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = AppColor.CaribbeanGreen,
                    contentColor = AppColor.White
                ),
                onClick = {
                    navigator?.push(
                        GameScreen(
                            subTitle = Res.string.level_normal,
                            background = AppColor.CaribbeanGreen,
                            size = CardSize.NORMAL.value,
                            onClick = {
                                navigator.pop()
                            })
                    )
                }
            )

            MenuButton(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .fillMaxWidth()
                    .weight(0.3f),
                title = Res.string.level_hard,
                subTitle = Res.string.desc_hard,
                fontResource = Res.font.gotham_rounded_medium,
                iconResource = Res.drawable.ic_level_hard,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = AppColor.BlueGreen,
                    contentColor = AppColor.White
                ),
                onClick = {
                    navigator?.push(
                        GameScreen(
                            subTitle = Res.string.level_hard,
                            background = AppColor.BlueGreen,
                            size = CardSize.HARD.value,
                            onClick = {
                                navigator.pop()
                            })
                    )
                }
            )

            Spacer(modifier = Modifier.weight(0.15f))
        }
    }
}