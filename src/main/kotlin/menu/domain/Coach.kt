package menu.domain

import camp.nextstep.edu.missionutils.Randoms
import menu.common.Category

private const val NAME_ERROR = "코치의 이름은 2~4글자여야합니다."

class Coach(val name: String) {
    val inedibleMenus = mutableSetOf<String>()
    val menus = mutableSetOf<String>()

    init {
        validateName(name)
    }

    private fun validateName(name: String) {
        if (name.length !in 2..4) {
            throw IllegalArgumentException(NAME_ERROR)
        }
    }

    fun decideInedibleMenus(inputMenus: List<String>) {
        inputMenus.forEach {
            if (Category.isMenuExist(it)) {
                inedibleMenus.add(it)
            }
        }
    }

    fun suggestMenus(categories: List<Category>) {
        categories.forEach { suggestMenu(it) }
    }

    private fun suggestMenu(category: Category) {
        var state = false
        while (!state) {
            val menu = Randoms.shuffle(category.menus)[0]
            if (validateMenu(menu)) {
                state = true
                menus.add(menu)
            }
        }
    }

    private fun validateMenu(menu: String): Boolean {
        if (isInEdible(menu)) return false
        if (isDuplicated(menu)) return false
        return true
    }

    private fun isInEdible(menu: String): Boolean {
        return menu in inedibleMenus
    }

    private fun isDuplicated(menu: String): Boolean {
        return menu in menus
    }
}
