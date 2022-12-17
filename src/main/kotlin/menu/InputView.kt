package menu

import camp.nextstep.edu.missionutils.Console as cs

class InputView {

    fun getCoachNames() {
        var validNamesFlag = true
        while (validNamesFlag) {
            println("코치의 이름을 입력해 주세요. (, 로 구분)")
            val coaches = readCoachNames()
            if (coaches.isNotEmpty()) {
                validNamesFlag = false
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
}