package util

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.snapshots.SnapshotStateMap
import game.presentation.components.CardFace
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import kotlin.random.Random

@OptIn(ExperimentalResourceApi::class)
suspend fun initializeGame(
    size: Int,
    card: Card,
    cardFaces: SnapshotStateMap<Int, CardFace>,
    imagePairs: SnapshotStateList<DrawableResource?>,
    onClear: () -> Unit
) {
    // Arrange cards face down
    for (i in 0..<size) {
        cardFaces[i] = CardFace.Front
    }

    // Randomly arrange card images to be used
    card.shuffleResources(Card.RESOURCES[0])
    onClear()

    val numbers = ArrayList<Int>()
    var number = Random.nextInt(0, size)

    numbers.add(number)

    for (i in 0 until size - 1) {
        do {
            number = Random.nextInt(0, size)
        } while (numbers.contains(number))

        numbers.add(number)
    }

    delay(1000)
    /** set image to two boxes */
    var imageIndex = 0
    var row = 0
    var cols = 0

    for (i in numbers) {
        imagePairs[i] = Card.RESOURCES[0][imageIndex]

        if (cols == 1) {
            imageIndex++
            row++
            cols = 0
        } else {
            cols++
        }
    }
}

@OptIn(ExperimentalResourceApi::class)
suspend fun checkPair(
    card: Card,
    pair: List<Int>,
    cardFaces: SnapshotStateMap<Int, CardFace>,
    imagePairs: SnapshotStateList<DrawableResource?>,
    onClear: () -> Unit,
    onStartGame: () -> Unit
) {
    // Check if pair of cards are facing up
    if (pair.size == 2) {
        if (imagePairs[pair[0]] == imagePairs[pair[1]]) {
            // Check if there are still cards facing down
            val availableCards = cardFaces.filter {
                it.value == CardFace.Front
            }

            if (availableCards.isEmpty()) {
                delay(1000)
                card.shuffleResources(Card.RESOURCES[0])
                onStartGame()
            } else {
                // There are still cards to solve
            }
        } else {
            // Pair of cards does not match
            pair.forEachIndexed { index, i ->
                delay(500)
                cardFaces[pair[index]] = CardFace.Front
            }
        }

        onClear()
    }
}