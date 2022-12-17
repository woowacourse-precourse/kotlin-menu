package menu.view

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun readCoaches(): List<String> {
        println("코치의 이름을 입력해 주세요. (, 로 구분)")
        return readWithSeparator()
    }

    fun readHateMenus(name: String): List<String> {
        println("${name}(이)가 못 먹는 메뉴를 입력해 주세요.")
        return readWithSeparator()
    }

    private fun readWithSeparator(): List<String> {
        val line = Console.readLine()

        if (!line.contains(SEPARATOR)) return listOf(line)

        return line.trim()
            .split(SEPARATOR)
    }

    companion object {
        private const val SEPARATOR = ","
    }
}