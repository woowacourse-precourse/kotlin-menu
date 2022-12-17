package menu.domain

class Coach(val name: String) {
    val inedibleMenu = mutableSetOf<String>()
    val menus = mutableSetOf<String>()
}