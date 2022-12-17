package menu.exception

import menu.message.Message

class NotEatMenuException(menus: String) {
    init {
        notEatMenuIsMoreThanThree(menus)
    }

    private fun notEatMenuIsMoreThanThree(menus: String) {
        val menu = menus.split(',')

        if(menu.size > 2)
            throw IllegalArgumentException(Message.notEatMenuIsMoreThanThree)
    }
}