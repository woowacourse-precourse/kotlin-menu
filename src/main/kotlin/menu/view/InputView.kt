package menu.view

import camp.nextstep.edu.missionutils.Console
import menu.dto.NamesDTO

class InputView {
    fun readNames(): NamesDTO {
        println(NAMES_GUIDE)
        val input = readLine()

        val names = convertToList(input)

        return NamesDTO(names)
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
        const val NAMES_GUIDE = "코치의 이름을 입력해 주세요. (, 로 구분)"
    }
}