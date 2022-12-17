package menu

import camp.nextstep.edu.missionutils.Randoms
import menu.domain.Category
import menu.domain.Coach
import menu.utils.Constant.DAYS
import menu.view.InputView
import menu.view.OutputView

class RecommendService {
    fun run() {
        OutputView().printStartMessage()
        val coaches = InputView().getCoaches()
        val categories = generateCategories()
        recommendMenus(coaches, categories)
    }

    private fun recommendMenus(coaches: List<Coach>, categories: List<String>) {
        generateMenus(coaches, categories)
    }

    private fun generateMenus(coaches: List<Coach>, categories: List<String>) {
        coaches.forEach { coach ->
            val menus = mutableListOf<String>()
            categories.forEach { category ->
                var menu = selectMenu(coach, category)
                while (menus.contains(menu)) {
                    menu = selectMenu(coach, category)
                }
                menus.add(menu)
            }
        }
    }

    private fun selectMenu(coach: Coach, category: String): String {
        val menus = Category.getMenuList(category)
        var menu = generateRandomMenu(menus)
        while (coach.containHateMenus(menu)) {
            menu = generateRandomMenu(menus)
        }
        return menu
    }

    private fun generateRandomMenu(menus: List<String>): String {
        return Randoms.shuffle(menus)[0]
    }

    private fun generateCategories(): List<String> {
        val categories = mutableListOf<String>()
        repeat(DAYS) { categories.add(selectCategory(categories)) }
        return categories
    }

    private fun selectCategory(categories: List<String>): String {
        while (true) {
            val categoryName = generateRandomCategory()
            var count = 0
            categories.forEach {
                if (it == categoryName) count++
            }
            if (count < 2) {
                return categoryName
            }
        }
    }

    private fun generateRandomCategory(): String {
        val categoryNumber = Randoms.pickNumberInRange(1, 5)
        return Category.getCategoryName(categoryNumber)
    }
}