package menu

import camp.nextstep.edu.missionutils.Console as cs

class InputView {

    fun getCoachNames(): List<String> {
        while (true) {
            println("코치의 이름을 입력해 주세요. (, 로 구분)")
            val coaches = readCoachNames()
            if (coaches.isNotEmpty()) {
                return coaches
            }
        }
    }

    private fun readCoachNames(): List<String> {
        val names = cs.readLine()

        val coaches = names.split(",")

        if (coaches.size < 2) {
            throw IllegalArgumentException("[ERROR] 코치는 최소 2명 이상 입력해야 합니다.")
        }
        if (coaches.size > 5) {
            throw IllegalArgumentException("[ERROR] 코치는 최대 5명 입력해야 합니다.")
        }
        return coaches
    }

    fun getDislikeMenu(coachName : String) : List<String>{
        println("\n$coachName(이)가 못 먹는 메뉴를 입력해 주세요.")
        val inputMenus = cs.readLine()
        val dislikeMenus = inputMenus.split(",")
        if (dislikeMenus.size > 3) {
            throw IllegalArgumentException("[ERROR] 싫어하는 메뉴는 최대 2개 입력 가능합니다.")
        }
        if(dislikeMenus.isEmpty()){
            return listOf("")
        }
        return dislikeMenus
    }
}