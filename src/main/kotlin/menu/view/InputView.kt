package menu.view

import camp.nextstep.edu.missionutils.Console
import menu.view.validator.InputValidator

object InputView {

    fun readCoaches(): List<String> {
        while (true) {
            val coaches = Console.readLine()

            kotlin.runCatching { InputValidator.validateCoaches(coaches) }
                .onSuccess { return coaches.split(",").map { it.trim() } }
                .onFailure { println(it.message) }
        }
    }

    fun readMenus(): List<String> {
        while (true) {
            val menus = Console.readLine()

            kotlin.runCatching { InputValidator.validateMenus(menus) }
                .onSuccess { return menus.split(",").map { it.trim() } }
                .onFailure { println(it.message) }
        }
    }
}