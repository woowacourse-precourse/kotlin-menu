package menu

class InputValidator {
    fun validateCoachNames(coachName: String): List<String> {
        val names = coachName.split(DELIMETER)
        if (names.size !in MIN_NUMBER_OF_COACH..MAX_NUMBER_OF_COACH) {
            throw IllegalArgumentException(NUMBER_OF_COACH_ERROR)
        }
        names.forEach {
            if (it.length !in NAME_MIN_LENGTH..NAME_MAX_LENGTH) {
                throw IllegalArgumentException(NAME_LENGTH_ERROR.format(it))
            }
        }
        return names
    }

    fun validateDislikeMenus(dislikeMenus: String, totalMenu: Menu): List<String> {
        val dislikeMenuList = dislikeMenus.split(DELIMETER)
        dislikeMenuList.forEach {
            if (!totalMenu.contains(it)) {
                throw IllegalArgumentException(MENU_NOT_EXIST_ERROR)
            }
            if (dislikeMenuList.size > MAX_NUMBER_OF_DISLIKE_MENU) {
                throw IllegalArgumentException(NUMBER_OF_MENU_ERROR)
            }
        }
        return dislikeMenuList
    }

    companion object {
        const val NUMBER_OF_COACH_ERROR = "[ERROR] 코치는 최소 2명, 최대 5명입니다."
        const val NAME_LENGTH_ERROR = "[ERROR] 이름의 길이는 최소 2글자 최대 4글지입니다. (잘못된 입력: %s)"
        const val MENU_NOT_EXIST_ERROR = "[ERROR] 존재하지 않는 메뉴입니다."
        const val NUMBER_OF_MENU_ERROR = "[ERROR] 못 먹는 메뉴는 최소 0개 최대 2개입니다."
        private const val MAX_NUMBER_OF_DISLIKE_MENU = 2
        private const val DELIMETER = ","
        private const val NAME_MIN_LENGTH = 2
        private const val NAME_MAX_LENGTH = 4
        private const val MIN_NUMBER_OF_COACH = 2
        private const val MAX_NUMBER_OF_COACH = 5

    }
}