package menu.view

import camp.nextstep.edu.missionutils.Console
import menu.view.validator.InputValidator

object InputView {

    fun readCoaches(): List<String> {
        while (true) {
            val coaches = Console.readLine()

            kotlin.runCatching { InputValidator.validateCoaches(coaches) }
                .onSuccess { return coaches.split(",") }
                .onFailure { println(it.message) }
        }
    }
}