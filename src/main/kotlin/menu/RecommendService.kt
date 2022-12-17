package menu

import camp.nextstep.edu.missionutils.Randoms
import menu.domain.Category
import menu.utils.Constant.DAYS
import menu.view.InputView
import menu.view.OutputView

class RecommendService {
    fun run() {
        OutputView().printStartMessage()
        val coaches = InputView().getCoaches()
        val categories = generateCategories()
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