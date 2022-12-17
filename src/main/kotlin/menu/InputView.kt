package menu

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun readCoachesName(): List<String> {
        val coachesName = Console.readLine().split(DELIMITERS)
        return coachesName
    }

    fun readCoachCantEatMenu(): List<String> {
        val coachCantEat = Console.readLine().split(DELIMITERS)
        return coachCantEat
    }

    companion object {
        private const val DELIMITERS = ","
    }
}
