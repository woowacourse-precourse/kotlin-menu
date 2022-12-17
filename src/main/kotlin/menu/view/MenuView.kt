package menu.view

import camp.nextstep.edu.missionutils.Console
import menu.exceptions.InvalidCoachCount
import menu.exceptions.InvalidNameLengthException
import menu.strings.GenericString
import menu.strings.MenuErrorMessage
import menu.strings.MenuNames
import menu.view.actor.Calendar
import menu.view.actor.Coach
import menu.view.actor.Recommender
import java.util.StringTokenizer

class MenuView {
    private val coaches = mutableListOf<Coach>()
    private val recommender = Recommender()
    private val calender = Calendar()

    fun start() {
        println(GenericString.GUID_MENU_START.str + "\n")
        while (true) {
            try {
                initSettings()
                break;
            } catch (e: InvalidCoachCount) {
                coaches.clear()
                println(e.message)
            } catch (e: InvalidNameLengthException) {
                coaches.clear()
                println(e.message)
            }
        }
        processRecommend()
        printResult()
    }

    private fun initSettings() {
        println(GenericString.GUID_INPUT_COACH_NAME.str)
        val tokenizer = StringTokenizer(Console.readLine(), ",")
        val coachNames = tokenizer.toList()
        validateCoachCount(coachNames.size)
        println()
        for (name in coachNames) {
            validateCoachNameLength(name.toString())
            coaches.add(Coach(name.toString()))
            println("${name}${GenericString.GUID_INPUT_HATED_MENU.str}")

            val tokenizer2 = StringTokenizer(Console.readLine(), ",").toList()
            for (item in tokenizer2)
                coaches.last().addDenialMenu(item.toString())
            println()
        }
    }

    private fun processRecommend() {
        for (i in 0 until calender.weeks.size) {
            recommender.recommendCategory()
            for (j in 0 until coaches.size) {
                recommender.recommendMenu(coaches[j], recommender.categoryRecord[i])
            }
        }
    }

    private fun printResult() {
        println(GenericString.GUID_MENU_RESULT.str)
        println(calender.toString())
        println(recommender.toStringCategoryRecord())
        for (coach in coaches) {
            println(coach.toStringSummary())
        }
        println()
        println(GenericString.GUID_COMPLETE.str)
    }

    private fun validateCoachCount(count: Int) {
        if (count < 2 || count > 5) throw InvalidCoachCount(MenuErrorMessage.INVALID_COACH_COUNT.message)
    }

    private fun validateCoachNameLength(name: String) {
        if (name.length < 2 || name.length > 4) throw InvalidNameLengthException(MenuErrorMessage.INVALID_NAME_LENGTH.message)
    }
}