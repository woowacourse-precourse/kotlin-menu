package menu.view

import menu.domain.model.Coach
import menu.domain.model.Coaches
import menu.domain.model.WeeklyCategory
import menu.util.Message.OUTPUT_END_RECOMMAND
import menu.util.Message.OUTPUT_RECOMMAND_RESULT
import menu.util.Message.OUTPUT_WEEK_INFO

class OutputView {

    fun menuRecommandResults(weeklyCategory: WeeklyCategory, coaches: Coaches) {
        println(OUTPUT_RECOMMAND_RESULT)
        println(OUTPUT_WEEK_INFO)
        println(weeklyCategory.toString())
        coaches.forEach { coach ->
            println(coach)
        }
        println(OUTPUT_END_RECOMMAND)
    }

}