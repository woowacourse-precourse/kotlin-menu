package menu.domain

import camp.nextstep.edu.missionutils.Randoms
import menu.data.MenuCategory

class MenuCategoryGenerator(coachName: List<String>, coachesCantEat: MutableList<List<String>>) {
    private val _menuCategory = getRandomMenuCategory()
    val menuCategory = _menuCategory
    private val coachesCannotEat = coachesCantEat

    private val coachNames = coachName

    private val _menuGetCategory = getMenuFromCategory()
    val menuGetCategory = _menuGetCategory
    private fun getRandomMenuCategory(): List<MenuCategory> {
        val randoMenuCategory = mutableListOf<MenuCategory>()
        while (randoMenuCategory.size != RANDOM_MENU_CATEGORY_SIZE) {
            val category: MenuCategory = MenuCategory.judgeMenuCategory(
                Randoms.pickNumberInRange(RANDOM_PICK_RANGE_START, RANDOM_PICK_RANGE_END)
            )
            if (randoMenuCategory.count { it == category } != MAX_WEEK_CATEGORY_COUNT) {
                randoMenuCategory.add(category)
            }
        }
        return randoMenuCategory
    }

    fun getMenuFromCategory(): List<List<String>> {
        val randomMenu = mutableListOf<MutableList<String>>()
        val randomEachMenu = mutableListOf<String>()
        repeat(coachNames.size) {
            var k = 0
            var j = 0
            while (randomEachMenu.size != coachNames.size * 5) {
                val menu = Randoms.shuffle(menuCategory[0].menus)[0]
                println(menu)
                if (coachesCannotEat[0].all { it != menu }) {
                    randomEachMenu.add(menu)
                    k++
                }
                if (k % 5 == 0) {
                    j++
                }
            }
            randomMenu.add(randomEachMenu)
        }
        return randomMenu
    }

    companion object {
        private const val RANDOM_PICK_RANGE_START = 1
        private const val RANDOM_PICK_RANGE_END = 5
        private const val RANDOM_MENU_CATEGORY_SIZE = 5
        private const val RANDOM_MENU_SIZE = 5
        private const val MAX_WEEK_CATEGORY_COUNT = 2
    }
}
