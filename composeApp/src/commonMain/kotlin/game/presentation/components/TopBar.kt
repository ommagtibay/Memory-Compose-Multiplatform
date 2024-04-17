package game.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.FontResource
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import theme.AppColor

@OptIn(ExperimentalResourceApi::class)
@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    title: StringResource,
    subTitle: StringResource,
    iconResource: DrawableResource,
    fontResource: FontResource,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
    ) {
        IconButton(onClick = onClick) {
            Image(
                painter = painterResource(resource = iconResource),
                contentDescription = null
            )
        }

        Row(
            modifier = Modifier
                .align(Alignment.Center),
        ) {
            Text(
                text = SpanTextWithStyle(
                    title = title,
                    subTitle = subTitle,
                    fontResource = fontResource
                )
            )
        }
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun SpanTextWithStyle(
    title: StringResource,
    subTitle: StringResource,
    fontResource: FontResource
): AnnotatedString {
    return buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = AppColor.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(Font(resource = fontResource))
            )
        ) {
            append(stringResource(resource = title).uppercase())
            append(" - ")
        }
        withStyle(
            style = SpanStyle(
                color = AppColor.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = FontFamily(Font(resource = fontResource))
            )
        ) {
            append(stringResource(resource = subTitle))
        }
    }
}