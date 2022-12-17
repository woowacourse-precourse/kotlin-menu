package menu.view

import camp.nextstep.edu.missionutils.Console
import menu.domain.error.ErrorCheck
import menu.domain.resource.SEPARATOR

class InputView {

    fun readCoachName(): List<String> {
        println(INPUT_COACH_NAME)

        val names = Console.readLine().trim()
        ErrorCheck.checkValidCoachName(names)

        return names.split(SEPARATOR)
    }

    fun readMenuCantEat(name: String): List<String> {
        println(INPUT_FOOD_CANT_EAT.format(name))

        val menus = Console.readLine().trim()
        if(menus == "") return listOf()
        ErrorCheck.checkValidMenu(menus)
        // TODO: 입력된 메뉴가 카테고리 내에 없는 메뉴라면?

        return menus.split(SEPARATOR)
    }

    companion object {
        const val INPUT_COACH_NAME = "\n코치의 이름을 입력해 주세요. ($SEPARATOR 로 구분)"
        const val INPUT_FOOD_CANT_EAT = "\n%s(이)가 못 먹는 메뉴를 입력해 주세요."
    }
}