package menu.exception

import menu.data.Menus
import menu.message.ExceptionMessage

class NotEatMenuException(menus: String) {
    private var menu = splitMenus(menus)

    init {
        removeEmptyValue()
        notEatMenuIsMoreThanThree()
        notAvailableMenu()
    }

    private fun splitMenus(menus: String): List<String> = menus.split(',')

    private fun removeEmptyValue() {
        val tmpMenu = menu.toMutableList()
        tmpMenu.removeIf { it.isEmpty() }
        menu = tmpMenu
    }

    private fun notEatMenuIsMoreThanThree() {
        if(menu.size > 2)
            throw IllegalArgumentException(ExceptionMessage.notEatMenuIsMoreThanThree)
    }

    private fun notAvailableMenu() {
        menu.forEach {
            if(it.isEmpty())
                return@forEach
            if(!Menus.allMenu.contains(it))
                throw IllegalArgumentException(ExceptionMessage.notAvailableMenu)
        }
    }
}