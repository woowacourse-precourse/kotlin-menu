package menu.view

import menu.domain.Coach
import menu.strings.Message

class OutputView {
    fun printStart() {
        print(Message.PrintMessage.PRINT_RECOMMEND.msg)
    }

    fun printGetCoach() {
        print(Message.PrintMessage.GET_COACH_NAME.msg)
    }

    fun printGetUnavailableFood() {
        print(Message.PrintMessage.GET_UNAVAILABLE_FOOD.msg)
    }

    fun printResult() {
        println(Message.PrintMessage.PRINT_RESULT.msg)
        print(Message.PrintMessage.DAYS.msg)
    }

    fun printCategory(category: List<String>) {
        println(Message.PrintMessage.CATEGORY.msg.format(
            category[0],
            category[1],
            category[2],
            category[3],
            category[4]))
    }

    fun printCoach(coach: Coach) {
        println(Message.PrintMessage.RECOMMEND_FOOD.msg.format(

        ))
    }
}