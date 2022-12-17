package menu.view

import camp.nextstep.edu.missionutils.Console

private const val SEPARATOR = ","

class InputView(private val inputValidator: InputValidator) {

    fun readCoachesName(): List<String> {
        val names = Console.readLine().split(SEPARATOR)
        inputValidator.validateNames(names)
        return names
    }

    fun readInedibleMenus(): List<String> {
        val menus = Console.readLine().split(SEPARATOR)
        inputValidator.validateMenus(menus)
        return menus
    }
}
