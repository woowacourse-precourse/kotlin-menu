package menu.domain

interface MenuGenerator {
    fun generate(menus: List<String>): String
}