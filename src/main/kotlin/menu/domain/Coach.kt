package menu.domain

import camp.nextstep.edu.missionutils.Randoms
import menu.common.Category

private const val NAME_ERROR = "코치의 이름은 2~4글자여야합니다."
private const val MENU_ERROR = "없는 메뉴 입니다."
private const val NAME_LENGTH_START = 2
private const val NAME_LENGTH_END = 4
private const val FIRST = 0

class Coach(private val name: String) {
    private val inedibleMenus = mutableSetOf<String>()

    private val _menus = mutableSetOf<String>()
    val menus: Set<String> get() = _menus

    val coachName: String get() = name

    init {
        validateName(name)
    }

    private fun validateName(name: String) {
        if (name.length !in NAME_LENGTH_START..NAME_LENGTH_END) {
            throw IllegalArgumentException(NAME_ERROR)
        }
    }

    fun decideInedibleMenus(inputMenus: List<String>) {
        if (inputMenus[0].isBlank()) return
        inputMenus.forEach {
            if (!Category.isMenuExist(it)) {
                throw IllegalArgumentException(MENU_ERROR)
            }
            inedibleMenus.add(it)
        }
    }

    fun suggestMenu(category: Category) {
        var state = false
        while (!state) {
            val menu = Randoms.shuffle(category.menus)[FIRST]
            if (validateMenu(menu)) {
                state = true
                _menus.add(menu)
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
        return menu in _menus
    }
}
