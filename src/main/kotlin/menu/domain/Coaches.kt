package menu.domain

class Coaches(val coaches: List<Coach>) {

    init {
        require(coaches.size in MIN_COACH..MAX_COACH) { ERROR_COACH_SIZE }
        require(coaches.distinct() == coaches) { ERROR_COACH_DUPLICATED }
    }

    companion object {
        private const val MIN_COACH = 2
        private const val MAX_COACH = 5

        private const val ERROR_COACH_SIZE = "코치는 ${MIN_COACH}이상 ${MAX_COACH}이하가 함께해야합니다."
        private const val ERROR_COACH_DUPLICATED = "코치 이름에 중복이 존재합니다."
    }
}
