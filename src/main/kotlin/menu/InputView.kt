package menu

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun input(): String = Console.readLine().trim()

    fun coachNameInput(): List<Coach> {
        while (true) {
            println(COACH_NAME_INPUT_PLEASE)
            val input = input()
            kotlin.runCatching { InputValidator.coachNames(input) }
                .onSuccess { return convertCoachNames(input) }
                .onFailure { println(it.message) }
        }
    }

    private fun convertCoachNames(input: String): List<Coach> {
        val names = input.split(",").map { it.trim() }
        return names.map { Coach(it, mutableListOf(), mutableListOf()) }
    }

    fun coachHateMenuInput(coaches: List<Coach>) {
        coaches.forEach {
            val hateMenus = personHateMenus(it)
            it.canNotEats = hateMenus.toMutableList()
        }
    }

    private fun personHateMenus(coach: Coach): List<String> {
        while (true) {
            println(HATE_MENU_INPUT_PLEASE.format(coach.name))
            val input = input()
            kotlin.runCatching { InputValidator.hateMenu(input) }
                .onSuccess { return input.split(",") }
                .onFailure { println(it.message) }
        }
    }



    companion object {
        private const val COACH_NAME_INPUT_PLEASE = "코치의 이름을 입력해 주세요. (, 로 구분)"
        private const val HATE_MENU_INPUT_PLEASE = "\n%s(이)가 못 먹는 메뉴를 입력해주세요."
    }
}