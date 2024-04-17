package util

import memory.composeapp.generated.resources.Res
import memory.composeapp.generated.resources.animal_01
import memory.composeapp.generated.resources.animal_02
import memory.composeapp.generated.resources.animal_03
import memory.composeapp.generated.resources.animal_04
import memory.composeapp.generated.resources.animal_05
import memory.composeapp.generated.resources.animal_06
import memory.composeapp.generated.resources.animal_07
import memory.composeapp.generated.resources.animal_08
import memory.composeapp.generated.resources.animal_09
import memory.composeapp.generated.resources.animal_10
import memory.composeapp.generated.resources.animal_11
import memory.composeapp.generated.resources.animal_12
import memory.composeapp.generated.resources.animal_13
import memory.composeapp.generated.resources.animal_14
import memory.composeapp.generated.resources.animal_15
import memory.composeapp.generated.resources.animal_16
import memory.composeapp.generated.resources.animal_17
import memory.composeapp.generated.resources.animal_18
import memory.composeapp.generated.resources.animal_19
import memory.composeapp.generated.resources.animal_20
import memory.composeapp.generated.resources.animal_21
import memory.composeapp.generated.resources.animal_22
import memory.composeapp.generated.resources.animal_23
import memory.composeapp.generated.resources.animal_24
import memory.composeapp.generated.resources.animal_25
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import kotlin.random.Random

enum class CardSize(val value: Int) {
    TEST(0),
    EASY(1),
    NORMAL(2),
    HARD(3)
}

class Card(size: Int) {
    /**
     * Set of images
     */
    companion object {
        val COLUMN = intArrayOf(2, 2, 3, 4)
        val ROW = intArrayOf(2, 4, 6, 8)

        @OptIn(ExperimentalResourceApi::class)
        val RESOURCES = arrayOf(
            arrayOf(
                Res.drawable.animal_01,
                Res.drawable.animal_02,
                Res.drawable.animal_03,
                Res.drawable.animal_04,
                Res.drawable.animal_05,
                Res.drawable.animal_06,
                Res.drawable.animal_07,
                Res.drawable.animal_08,
                Res.drawable.animal_09,
                Res.drawable.animal_10,
                Res.drawable.animal_11,
                Res.drawable.animal_12,
                Res.drawable.animal_13,
                Res.drawable.animal_14,
                Res.drawable.animal_15,
                Res.drawable.animal_16,
                Res.drawable.animal_17,
                Res.drawable.animal_18,
                Res.drawable.animal_19,
                Res.drawable.animal_20,
                Res.drawable.animal_21,
                Res.drawable.animal_22,
                Res.drawable.animal_23,
                Res.drawable.animal_24,
                Res.drawable.animal_25,
            ),
            // Add additional set of images
        )
    }

    var row = 0
        private set

    var column = 0
        private set

    init {
        row = ROW[size]
        column = COLUMN[size]
    }

    @OptIn(ExperimentalResourceApi::class)
    fun getResources(image: Int): Array<DrawableResource> {
        return if (image == 0) {
            RESOURCES[Random.nextInt(
                0,
                RESOURCES.size
            )] //  Make a random set of image resources to be used
        } else RESOURCES[image - 1]
    }

    /**
     * Shuffles array of image resources
     */
    @OptIn(ExperimentalResourceApi::class)
    fun shuffleResources(array: Array<DrawableResource>) {
        var index: Int
        var temp: DrawableResource

        for (i in array.size - 1 downTo 1) {
            index = Random.nextInt(i + 1)
            temp = array[index]
            array[index] = array[i]
            array[i] = temp
        }
    }
}