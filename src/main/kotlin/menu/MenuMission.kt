package menu

import menu.view.InputView

class MenuMission(private val inputView: InputView) {
    fun missionStart() {
        val coaches = coachCheck(inputView.getCoach())
        coachHateFood(coaches)



    }

    fun coachHateFood(coaches: List<String>) {
        val coachHate = mutableMapOf<String,List<String>>()
        coaches.forEach{
            val hates = inputView.getHateFood(it).split(",")
            coachHate[it] = hates
        }
    }


    // 입력 체크...
    fun coachCheck(coach: String): List<String> {//coach 따로 클래스 만들어서 구현
        val coaches = coach.split(",")
        coaches.forEach {
            if (it.length !in 2..4)
                throw IllegalArgumentException(ERROR_COACH_NAME_SIZE_MESSAGE)
        }
        if (coaches.size < 2)
            throw IllegalArgumentException(ERROR_COACHES_MIN_MESSAGE)
        if (coaches.size > 5)
            throw IllegalArgumentException(ERROR_COACHES_MAX_MESSAGE)
        return coaches
    }

}