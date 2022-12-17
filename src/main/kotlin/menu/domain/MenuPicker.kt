package menu.domain

import menu.domain.menugenerator.MenuGenerator

class MenuPicker(private val menuGenerator: MenuGenerator) {

    fun generateMenus(coachWithMenuBan: List<String>, categorys: List<AvaliableMenu>): List<String> {
        val menus = mutableListOf<String>()
        val banMenus = coachWithMenuBan.subList(1, coachWithMenuBan.size)
        while (menus.size < 5) {
            val randomMenu = menuGenerator.generate(categorys[menus.size])
            if (randomMenu !in menus && randomMenu !in banMenus) menus.add(randomMenu)
        }
        return menus
    }
}
