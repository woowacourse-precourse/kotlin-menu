package menu.lunch.view

import camp.nextstep.edu.missionutils.Console
import menu.lunch.domain.infinityRead
import menu.lunch.resources.ERROR_INPUT_AT_LEAST_TWO
import menu.lunch.resources.ERROR_INPUT_AT_MOST_FIVE
import menu.lunch.resources.ERROR_INPUT_AT_MOST_TWO
import menu.lunch.resources.INPUT_DISLIKE_MENU
import menu.lunch.resources.INPUT_NAME_OF_COACHES

class InputView {
    fun readNameOfCoaches(): List<String> {
        return infinityRead {
            println(INPUT_NAME_OF_COACHES)
            val nameOfCoaches = Console.readLine().split(',')
            checkRange(nameOfCoaches)
            nameOfCoaches
        }
    }

    private fun checkRange(nameOfCoaches: List<String>) {
        require(nameOfCoaches.size >= 2) { ERROR_INPUT_AT_LEAST_TWO }
        require(nameOfCoaches.size <= 5) { ERROR_INPUT_AT_MOST_FIVE }
    }

    fun readDislikeMenu(name: String): List<String> {
        return infinityRead {
            println(INPUT_DISLIKE_MENU.format(name))
            val dislikeMenu = Console.readLine().split(',')
            require(dislikeMenu.size <= 2) { ERROR_INPUT_AT_MOST_TWO }
            dislikeMenu
        }
    }
}
