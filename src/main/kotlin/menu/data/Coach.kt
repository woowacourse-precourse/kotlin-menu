package menu.data

class Coach(private val name: String,
            private val declineMenu: List<Menu>) {

    fun validateMenu(menu: Menu): Boolean {
        if (declineMenu.contains(menu))
            return true
        return false
    }

    fun getName() = name
}