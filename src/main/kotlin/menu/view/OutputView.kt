package menu.view

import menu.model.Recommender

class OutputView {
    fun printStart() {
        println("점심 메뉴 추천을 시작합니다.")
    }

    fun printInputCoachName() {
        println("코치의 이름을 입력해 주세요. (, 로 구분)")
    }

    fun printInputFoodBan(coach: String) {
        println("${coach}(이)가 못 먹는 메뉴를 입력해 주세요.")
    }

    fun printResult(recommender: Recommender, result: MutableList<List<String>>) {
        println("메뉴 추천 결과입니다.")
        println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]")
        printCategory(recommender)
        printMenu(recommender, result)
        println()
        println("추천을 완료했습니다.")
    }

    private fun printCategory(recommender: Recommender) {
        var resultString = "[ 카테고리 | "
        for (index in 0 until 5) {
            resultString += recommender.getEatingCategory(index) + addDivider(index, 5)
        }
        resultString += " ]"
        println(resultString)
    }

    private fun printMenu(recommender: Recommender, result: MutableList<List<String>>) {
        for (index in result[0].indices) {
            var startString = "[ "
            startString += recommender.getCoach(index) + " | "
            var resultString = addMenuString(startString, index, result)
            resultString += " ]"
            println(resultString)
        }
    }

    private fun addMenuString(startString: String, index: Int, result: MutableList<List<String>>): String {
        var resultString = startString
        for (day in result.indices) {
            resultString += result[day][index] + addDivider(day, result.size)
        }
        return resultString
    }

    private fun addDivider(day: Int, size: Int): String {
        if (day < size - 1) {
            return " | "
        }
        return ""
    }

    fun printException(message: String) {
        println(message)
    }
}