package menu.lunch.view

import menu.lunch.domain.Coach
import menu.lunch.resources.OUTPUT_CATEGORY_LIST
import menu.lunch.resources.OUTPUT_COACH_LIST
import menu.lunch.resources.OUTPUT_DAY_OF_THE_WEEK
import menu.lunch.resources.OUTPUT_END_MESSAGE
import menu.lunch.resources.OUTPUT_RECOMMEND_RESULT_PRE_MESSAGE
import menu.lunch.resources.OUTPUT_START_MESSAGE

class OutputView {
    fun printStartMessage() {
        println(OUTPUT_START_MESSAGE)
    }

    fun printMenuRecommendResult(categoryRecord: List<String>, coaches: List<Coach>) {
        println(OUTPUT_RECOMMEND_RESULT_PRE_MESSAGE)
        println(OUTPUT_DAY_OF_THE_WEEK)
        println(OUTPUT_CATEGORY_LIST.format(categoryRecord.joinToString(" | ")))
        coaches.forEach { coach ->
            println(OUTPUT_COACH_LIST.format(coach.name, coach.alreadyEatFood.joinToString(" | ")))
        }
        println(OUTPUT_END_MESSAGE)
    }
}
