package menu.view.validator

import menu.common.*

object InputValidator {

    fun validateCoaches(coaches: String) {
        val separatedCoaches = coaches.split(",")
        require(separatedCoaches.size in MIN_NUMBER_OF_COACH..MAX_NUMBER_OF_COACH) {
            ERROR_MESSAGE_FORMAT.format("코치는 2명 이상 5명 이하로 입력해야 합니다.")
        }
        require(separatedCoaches.all { it.length in MIN_COACH_NAME_SIZE..MAX_COACH_NAME_SIZE }) {
            ERROR_MESSAGE_FORMAT.format("코치의 이름의 길이는 2 이상 4 이하로 입력해야 합니다.")
        }
    }
}