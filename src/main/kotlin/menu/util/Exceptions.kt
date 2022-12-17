package menu.util

object Exceptions {

    // 코치들 입력값에 대한 (,) 구분 예외 확인
    fun checkCoachesInput(coaches: List<String>) {
        coaches.forEach { coach ->
            checkCoachNameSize(coach)
        }
    }

    // 코치들의 이름은 2~4길이어야 한다
    private fun checkCoachNameSize(coach: String) {
        if (coach.length !in MIN_NAME_SIZE..MAX_NAME_SIZE) {
            throw IllegalArgumentException(ERROR_HEADER + ERROR_COACH_NAME_LENGTH)
        }
    }
}