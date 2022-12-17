package menu

import menu.FoodData.isInMenus

class InputValidator {

    fun validateCoaches(coachesName: String) {
        coachesName.validateHasEmptyChar()
        coachesName.validateCoachesName()
        coachesName.validateNumberOfCoach()
    }

    fun validateHatingMenu(hatingMenus: String) {
        hatingMenus.validateNumberOfHatingMenu()
        hatingMenus.validateIsInMenu()
        hatingMenus.validateIsAlreadyExistHatingMenu()
    }

    private fun String.validateIsAlreadyExistHatingMenu() {
        val hatingMenuRecords = mutableSetOf<String>()

        this.split(",").forEach { eachMenu ->
            require(!hatingMenuRecords.contains(eachMenu)) {
                ERROR_ALREADY_CONTAINED_HATING_MENU
            }
            hatingMenuRecords.add(eachMenu)
        }
    }

    private fun String.validateIsInMenu() {
        this.split(",").forEach { eachMenu ->
            require(isInMenus(eachMenu)) {
                ERROR_NOT_EXIST_MENU
            }
        }
    }

    private fun String.validateHasEmptyChar() {
        require(!this.contains(" ")) {
            ERROR_EXIST_EMPTY_CHAR
        }
    }

    private fun String.validateNumberOfHatingMenu() {
        require(this == "" || this.split(",").size in 0..2) {
            ERROR_NUMBER_OF_HATING_MENU
        }
    }

    private fun String.validateCoachesName() {
        this.split(",").forEach { eachCoachName ->
            require(eachCoachName.length in 2..4) {
                ERROR_COACH_NAME_LENGTH
            }
        }
    }

    private fun String.validateNumberOfCoach() {
        require(this.split(",").size in 2..5) {
            ERROR_NUMBER_OF_COACH
        }
    }

    companion object {
        const val ERROR_ALREADY_CONTAINED_HATING_MENU = "[ERROR] 같은 메뉴를 싫어하는 메뉴에 넣을 수 없습니다."
        const val ERROR_NOT_EXIST_MENU = "[ERROR] 존재하지 않는 메뉴입니다."
        const val ERROR_EXIST_EMPTY_CHAR = "[ERROR] 공백의 문자는 허용하지 않습니다."
        const val ERROR_NUMBER_OF_HATING_MENU = "[ERROR] 싫어하는 메뉴의 개수는 0에서 2개만 유효합니다."
        const val ERROR_COACH_NAME_LENGTH = "[ERROR] 코치 이름의 길이는 2이상 4이하만 유효합니다."
        const val ERROR_NUMBER_OF_COACH = "[ERROR] 식사를 하는 코치는 2명에서 5명 사이만 유효합니다."
    }
}