package menu

class Coach(val name: String) {
    private val uneatableMenus = mutableListOf<String>()
    fun addUneatableMenus(menu: String) {
        uneatableMenus.add(menu)
    }
}