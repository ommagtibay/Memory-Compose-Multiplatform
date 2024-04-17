package game.presentation.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import game.components.FixedGrid
import util.Card
import util.checkPair
import util.initializeGame
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalResourceApi::class)
@Composable
fun GameBoard(
    card: Card,
    start: Boolean,
    onDone: () -> Unit
) {
    val size = card.column * card.row

    val cardFaces = remember {
        mutableStateMapOf<Int, CardFace>()
    }

    val pair = remember {
        mutableStateListOf<Int>()
    }

    val numberOfImages = arrayOfNulls<DrawableResource>(size)
    val imagePairs = remember {
        mutableStateListOf(*numberOfImages)
    }

    LaunchedEffect(start) {
        initializeGame(
            size = size,
            card = card,
            cardFaces = cardFaces,
            imagePairs = imagePairs,
            onClear = { pair.clear() }
        )
    }

    LaunchedEffect(pair.size) {
        checkPair(
            card = card,
            cardFaces = cardFaces,
            imagePairs = imagePairs,
            pair = pair,
            onStartGame = {
                onDone()
            },
            onClear = { pair.clear() }
        )
    }

    FixedGrid(
        columns = card.column,
        items = size,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) { index ->
        cardFaces[index]?.let {
            CardFlipAnimation(
                cardFace = it,
                onClick = { cardFace ->
                    if (cardFace != CardFace.Back) {
                        cardFaces[index] = cardFace.next
                        pair.add(index)
                    }
                },
                enabled = pair.size != 2,
                modifier = Modifier
                    .padding(6.dp),
                front = {
                    FrontCard()
                },
                back = {
                    imagePairs[index]?.let { drawableResource ->
                        BackCard(drawableResource = drawableResource)
                    }
                },
            )
        }
    }
}