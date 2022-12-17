package menu.exceptions

object ValidateBusinessLogic {
    private const val PREFIX = "[ERROR] "
    private const val MIN_COACH_HEAD_COUNT = 2
    private const val MAX_COACH_HEAD_COUNT = 5
    private const val MIN_COACH_NAME_SIZE = 2
    private const val MAX_COACH_NAME_SIZE = 4
    private const val MIN_CANT_EAT_SIZE = 0
    private const val MAX_CANT_EAT_SIZE = 2

    fun validateCoachHeadCount(coachGroupSize: Int) {
        require(coachGroupSize in MIN_COACH_HEAD_COUNT..MAX_COACH_HEAD_COUNT) { PREFIX + "코치는 최소 2명이상 최대 5명 이하로 입력해주세요." }
    }

    fun validateCoachName(coachName: String) {
        require(coachName.length in MIN_COACH_NAME_SIZE..MAX_COACH_NAME_SIZE) { PREFIX + "코치의 이름은 최소 2글자, 최대 4글자로 입력해주세요." }
    }

    fun validateCantEatCount(cantEatSize: Int) {
        require(cantEatSize in MIN_CANT_EAT_SIZE..MAX_CANT_EAT_SIZE) { PREFIX + "못먹는 메뉴는 0개~2개 사이로 입력해주세요." }
    }
}