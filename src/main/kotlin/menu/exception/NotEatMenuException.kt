package menu.exception

import menu.data.Menus
import menu.message.ExceptionMessage

class NotEatMenuException(menus: String) {
    init {
        notEatMenuIsMoreThanThree(menus)
        notAvailableMenu(menus)
    }

    private fun notEatMenuIsMoreThanThree(menus: String) {
        val menu = menus.split(',')

        if(menu.size > 2)
            throw IllegalArgumentException(ExceptionMessage.notEatMenuIsMoreThanThree)
    }

    private fun notAvailableMenu(menus: String) {
        val menu = menus.split(',')

        menu.forEach {
            if(!Menus.allMenu.contains(it))
                throw IllegalArgumentException(ExceptionMessage.notAvailableMenu)
        }
    }
}