package menu.view.validator

import menu.common.*
import menu.model.Category
import menu.model.Menu

object InputValidator {

    fun validateCoaches(coaches: String) {
        val separatedCoaches = coaches.split(",").map { it.trim() }

        require(separatedCoaches.size in MIN_NUMBER_OF_COACH..MAX_NUMBER_OF_COACH) {
            ERROR_MESSAGE_FORMAT.format("코치는 2명 이상 5명 이하로 입력해야 합니다.")
        }
        require(separatedCoaches.all { it.length in MIN_COACH_NAME_SIZE..MAX_COACH_NAME_SIZE }) {
            ERROR_MESSAGE_FORMAT.format("코치의 이름의 길이는 2 이상 4 이하로 입력해야 합니다.")
        }
        require(separatedCoaches.isNotDuplicated()) {
            ERROR_MESSAGE_FORMAT.format("코치의 이름은 모두 달라야 합니다.")
        }
    }

    fun validateMenus(menus: String) {
        val separatedMenus = menus.split(",").map { it.trim() }

        require(separatedMenus.size <= MAX_CANT_EAT_MENU_SIZE) {
            ERROR_MESSAGE_FORMAT.format("각 코치의 못 먹는 메뉴의 개수는 0개 이상 2개 이하여야 합니다.")
        }
        require(separatedMenus.all { menu -> menu == "" || Category.values().any { it.containMenu(Menu(menu)) } }) {
            ERROR_MESSAGE_FORMAT.format("못 먹는 메뉴는 존재하는 메뉴여야 합니다.")
        }
    }

    private fun <E> List<E>.isNotDuplicated(): Boolean = this.size == this.toSet().size

}