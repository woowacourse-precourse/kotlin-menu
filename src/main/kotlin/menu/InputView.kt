package menu

import camp.nextstep.edu.missionutils.Console

class InputView {

    private fun checkCoachNamesRequirements(names: List<String>): Boolean {
        try {
            if (names.size < 2 || names.size > 5) throw IllegalArgumentException("coach-numbers")
            for (name in names) {
                if (name.length < 2 || name.length > 4) throw IllegalArgumentException("coach-name-length")
            }
        } catch (e: IllegalArgumentException) {
            when (e.message) {
                "coach-numbers" -> println("[ERROR] 코치는 최소 2명, 최대 5명까지 식사를 함께합니다.")
                "coach-name-length" -> println("[ERROR] 코치 이름은 최소 2글자, 최대 4글자입니다.")
            }
            return false
        }
        return true
    }

    fun readCoaches(): List<Coach> {
        println("코치의 이름을 입력해주세요. (, 로 구분)")
        val input = Console.readLine().split(",")
        val coaches = mutableListOf<Coach>()
        if (!checkCoachNamesRequirements(input)) return readCoaches()
        for (name in input) {
            coaches.add(Coach(name))
        }
        return coaches
    }

    private fun checkMenuNameInCategory(menu: String): Boolean {
        try {
            if (!Category.전부.menus.contains(menu)) throw IllegalArgumentException()
        } catch (e: IllegalArgumentException) {
            println("[ERROR] 카테고리의 메뉴 리스트에 없는 메뉴입니다.")
            return false
        }
        return true
    }

    private fun readMenu(): List<String> {
        val input = Console.readLine().split(",")
        for (menu in input) {
            if (!checkMenuNameInCategory(menu)) return readMenu()
        }
        return input
    }

    fun readMenus(coaches: List<Coach>) {
        for (coach in coaches) {
            println("${coach.name}(이)가 못 먹는 메뉴를 입력해주세요.")
            coach.addUneatableMenus(readMenu())
            println()
        }
    }

}