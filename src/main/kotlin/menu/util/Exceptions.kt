package menu.util

object Exceptions {

    // 코치들 입력값에 대한 (,) 구분 예외 확인
    fun checkCoachesInput(coaches: List<String>) {
        checkCoachSize(coaches)
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

    // 코치들은 최소 2명에서 5명까지 같이 식사를 한다.
    private fun checkCoachSize(coaches: List<String>) {
        if (coaches.size !in MIN_COACH_SIZE..MAX_COACH_SIZE) {
            throw IllegalArgumentException(ERROR_HEADER + ERROR_COACH_SIZE)
        }
    }
}