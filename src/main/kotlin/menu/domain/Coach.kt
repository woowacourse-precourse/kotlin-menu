package menu.domain

import camp.nextstep.edu.missionutils.Randoms

class Coach(
    private val name: String,
    private val menusCantEat: List<String>
) {
    val menusGonnaEat = mutableListOf<String>()

    fun getMenu(category: Category) {
        while (true) {
            val menu = Randoms.shuffle(Category.getMenus(category))[0]

            if (canEatMenu(menu) && !isAlreadyHad(menu)) {
                addMenu(menu)
                break
            }
        }
    }

    fun addMenu(menu: String) {
        menusGonnaEat.add(menu)
    }

    fun canEatMenu(menu: String): Boolean {
        if (menusCantEat.contains(menu)) {
            return false
        }
        return true
    }

    fun isAlreadyHad(menu: String): Boolean {
        if (menusGonnaEat.contains(menu)) {
            return true
        }

        return false
    }

    fun getName(): String {  // TODO: 좋지 못한 방식 -> 의미 있는 함수가 되도록 고칠 것
        return name
    }
}