package menu

class Coach(val name: String) {
    private val uneatableMenus = mutableListOf<String>()
    fun addUneatableMenus(menu: List<String>) {
        uneatableMenus.addAll(menu)
    }

    fun isUneatable(menu: String): Boolean {
        return uneatableMenus.contains(menu)
    }
}