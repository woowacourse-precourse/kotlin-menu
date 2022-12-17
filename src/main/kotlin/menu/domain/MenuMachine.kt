package menu.domain

class MenuMachine(
    private val menus: String
) {
    fun convertToList(): List<String> {
        return menus.split(',')
    }
}