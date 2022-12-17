package menu.view

import camp.nextstep.edu.missionutils.Console
import menu.exceptions.InvalidCoachCount
import menu.exceptions.InvalidNameLengthException
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
        println("점심 메뉴 추천을 시작합니다.") // 이거 string에
        println()

        while (true) {
            try {
                initSettings()
                break;
            } catch (_: InvalidCoachCount) {
                coaches.clear()
            } catch (_: InvalidNameLengthException) {
                coaches.clear()
            }
        }
        processRecommend()
        printResult()
    }

    private fun initSettings() {
        println("코치의 이름을 입력해 주세요. (, 로 구분)")
        // 이 부분 예외 사항 체크
        val tokenizer = StringTokenizer(Console.readLine(), ",")
        val coachNames = tokenizer.toList()

        println()
        for (name in coachNames) {
            coaches.add(Coach(name.toString()))

            println("${name}(이)가 못 먹는 메뉴를 입력해 주세요.")
            val tokenizer2 = StringTokenizer(Console.readLine(), ",").toList()
            for (item in tokenizer2) {
                coaches.last().addDenialMenu(item.toString())
            }
            println()
        }
    }

    private fun processRecommend() {
        for (i in 0 until calender.weeks.size) {
            recommender.recommendCategory()
        }
        for (i in 0 until coaches.size) {
            println("${coaches[i].name}에게 추천하겠습니다.")
            for (j in 0 until calender.weeks.size) {
                recommender.recommendMenu(coaches[i], recommender.categoryRecord[j])
            }
        }
    }

    private fun printResult() {
        println("메뉴 추천 결과입니다.")
        println(calender.toString())
        println(recommender.toStringCategoryRecord())
        for (coach in coaches) {
            println(coach.toStringSummary())
        }
        println()
        println("추천을 완료했습니다.")
    }

    private fun validateCoachCount(count: Int) {
        if (count < 2 || count > 5) throw InvalidCoachCount(MenuErrorMessage.INVALID_COACH_COUNT.message)
    }

    private fun validateCoachNameLength(name: String) {
        if (name.length < 2 || name.length > 4) throw InvalidNameLengthException(MenuErrorMessage.INVALID_NAME_LENGTH.message)
    }
}