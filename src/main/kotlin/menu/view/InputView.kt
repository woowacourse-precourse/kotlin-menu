package menu.view

import camp.nextstep.edu.missionutils.Console
import menu.domain.model.Coach
import menu.util.Message.INPUT_COACH_NAMES
import menu.util.Message.INPUT_INEDIBLE_FOOD
import menu.util.Message.INPUT_START_LUNCH_RECOMMAND

class InputView {

    fun startMenuRecommand() {
        println(INPUT_START_LUNCH_RECOMMAND)
    }

    fun coachName(): String {
        println(INPUT_COACH_NAMES)
        return Console.readLine()
    }

    fun inedibleFood(coach: Coach): String {
        println(INPUT_INEDIBLE_FOOD.format(coach.getName()))
        return Console.readLine()
    }
}