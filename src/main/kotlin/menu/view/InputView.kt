package menu.view

import camp.nextstep.edu.missionutils.Console
import java.lang.Exception

class InputView {
    fun inputName(): List<String> {
        var name = Console.readLine()
        val checkException = name.split(",")
        inputNumberNameException(checkException)
        checkException.forEach {
            inputNameException(it)
        }
        return name.split(",")
    }

    fun inputMenu(): List<String> {
        var menu = Console.readLine()
        val checkException = menu.split(",")
        inputMenuException(checkException)
        return menu.split(",")
    }

    private fun inputNameException(name: String) {
        when {
            name.length < 2 -> return throw IllegalArgumentException("[ERROR] 코치의 이름이 2글자 보다 작습니다.")
            name.length > 4 -> return throw IllegalArgumentException("[ERROR] 코치의 이름이 4글자 보다 많습니다.")
        }
    }
    private fun inputNumberNameException(name: List<String>) {
        when {
            name.size < 2 -> return throw IllegalArgumentException("[ERROR] 코치는 2명보다 많아야 합니다.")
            name.size > 5 -> return throw IllegalArgumentException("[ERROR] 코치는 5명보다 작아야 합니다.")
        }
    }
    private fun inputMenuException(menu: List<String>) {
        when {
            menu.size > 2 -> return throw IllegalArgumentException("[ERROR] 못 먹는 메뉴는 최대 2개 입니다.")
        }
    }
}