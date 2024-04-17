package game.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.FontResource
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import game.presentation.components.GameButton
import theme.AppColor

@OptIn(ExperimentalResourceApi::class)
@Composable
fun PopupDialog(
    message: StringResource,
    confirmText: StringResource,
    dismissText: StringResource,
    backgroundColor: Color,
    fontSize: TextUnit = 20.sp,
    fontResource: FontResource,
    logoResource: DrawableResource,
    allCaps: Boolean = false,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit
) {
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        ),
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 32.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(24.dp))
                .background(backgroundColor)
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(resource = logoResource),
                contentDescription = null
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = if (allCaps)
                    stringResource(resource = message).uppercase()
                else
                    stringResource(resource = message),
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    color = AppColor.White,
                    fontSize = fontSize,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(Font(resource = fontResource)),
                    lineHeight = 30.sp
                )
            )

            Spacer(modifier = Modifier.height(24.dp))

            GameButton(
                modifier = Modifier
                    .fillMaxWidth(),
                text = stringResource(resource = confirmText),
                fontFamily = FontFamily(Font(resource = fontResource)),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = AppColor.PaleYellow,
                    contentColor = AppColor.ChocolateCosmos
                ),
                onClick = onConfirm
            )

            Spacer(modifier = Modifier.height(8.dp))

            GameButton(
                modifier = Modifier
                    .fillMaxWidth(),
                text = stringResource(resource = dismissText),
                fontFamily = FontFamily(Font(resource = fontResource)),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = AppColor.GhostWhite,
                    contentColor = AppColor.ChocolateCosmos
                ),
                onClick = onDismiss
            )
        }
    }
}