package menu.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun inputName(): List<String> {
        var name = Console.readLine()
        return name.split(",")
    }

    fun inputMenu(): List<String> {
        var menu = Console.readLine()
        return menu.split(",")
    }

}