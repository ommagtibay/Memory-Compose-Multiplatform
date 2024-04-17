package game.presentation.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GameButton(
    modifier: Modifier = Modifier,
    text: String,
    fontFamily: FontFamily,
    colors: ButtonColors,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier
            .height(50.dp),
        shape = RoundedCornerShape(10.dp),
        colors = colors,
        onClick = onClick
    ) {
        Text(
            text = text,
            style = TextStyle(
                textAlign = TextAlign.Center,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = fontFamily
            )
        )
    }
}