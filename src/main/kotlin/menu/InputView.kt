package menu

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun readCoachesName(): List<String> {
        val coachesName = Console.readLine().split(",")
        return coachesName
    }
}
