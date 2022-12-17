package menu.view

private const val NAME_ERROR = "코치들은 2~5명이어야합니다."
private const val MENU_COUNT_ERROR = "못 먹는 메뉴는 0~2개여야합니다."
private const val DUPLICATED_ERROR = "중복된 값이 있습니다."

class InputValidator {

    fun validateNames(names: List<String>) {
        isDuplicated(names)
        checkNumberOfNames(names)
    }

    private fun isDuplicated(input: List<String>) {
        if (input.size != input.toSet().size) {
            throw IllegalArgumentException(DUPLICATED_ERROR)
        }
    }

    private fun checkNumberOfNames(names: List<String>) {
        if (names.size !in 2..5) {
            throw IllegalArgumentException(NAME_ERROR)
        }
    }

    fun validateMenus(menus: List<String>) {
        isDuplicated(menus)
        checkNumberOfMenus(menus)
    }

    private fun checkNumberOfMenus(menus: List<String>) {
        if (menus.size !in 0..2) {
            throw IllegalArgumentException(MENU_COUNT_ERROR)
        }
    }
}
