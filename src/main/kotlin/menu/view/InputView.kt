package menu.view

import camp.nextstep.edu.missionutils.Console
import menu.dto.MenusDTO
import menu.dto.NamesDTO

class InputView {
    fun readNames(): NamesDTO {
        println(NAMES_GUIDE)
        val input = readLine()

        val names = convertToList(input)

        return NamesDTO(names)
    }

    fun readMenus(namesDTO: NamesDTO): MenusDTO {
        val menus = mutableMapOf<String, List<String>>()
        val names = namesDTO.getNames()

        names.map {name ->
            println("$name$MENUS_GUIDE")
            val input = readLine()
            val menu = convertToList(input)
            menus.put(name, menu)
        }

        return MenusDTO(menus)
    }

    private fun readLine(): String {
        val input = Console.readLine()
        println(input)
        return input
    }

    private fun convertToList(input: String): List<String> {
        val splitResult = input.split(',')
        return splitResult.map { it.trim() }
    }

    companion object {
        const val MENUS_GUIDE = "(이)가 못 먹는 메뉴를 입력해 주세요."
        const val NAMES_GUIDE = "코치의 이름을 입력해 주세요. (, 로 구분)"
    }
}