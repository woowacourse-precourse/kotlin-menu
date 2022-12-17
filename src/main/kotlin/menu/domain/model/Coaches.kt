package menu.domain.model

import menu.util.ERROR.COACH_COUNT_LENGHT
import menu.util.ERROR.DUPLICATED_COACH_NAME
import menu.util.ONE

class Coaches(private val coaches: List<Coach>) : List<Coach> by coaches {

    init {
        require(coaches.all { coach ->
            coaches.count { it.equalName(coach.getName()) } == ONE
        }) {
            DUPLICATED_COACH_NAME
        }
        require(coaches.size in MIN_COACH_COUNT_LENGTH..MAX_COACH_COUNT_LENGTH) {
            COACH_COUNT_LENGHT
        }
    }

    companion object {
        const val MIN_COACH_COUNT_LENGTH = 2
        const val MAX_COACH_COUNT_LENGTH = 5
    }
}