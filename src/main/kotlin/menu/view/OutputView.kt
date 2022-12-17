package menu.view

import menu.strings.Message

class OutputView {
    fun printStart() {
        println(Message.PrintMessage.PRINT_RECOMMEND.msg)
    }

    fun printGetCoach() {
        println(Message.PrintMessage.GET_COACH_NAME.msg)
    }

    fun printGetUnavailableFood(coachName: String) {
        println(Message.PrintMessage.GET_UNAVAILABLE_FOOD.msg.format(coachName))
    }

    fun printResult(categoryString: String, coachesString: String) {
        println(Message.PrintMessage.PRINT_RESULT.msg)
        println(Message.PrintMessage.DAYS.msg)
        println(categoryString)
        println(coachesString)
        println(Message.PrintMessage.PRINT_END.msg)
    }
}