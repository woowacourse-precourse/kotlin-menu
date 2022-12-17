package menu.domain.menu

interface MenuGenerator {
    fun generate(menus: List<String>): String
}