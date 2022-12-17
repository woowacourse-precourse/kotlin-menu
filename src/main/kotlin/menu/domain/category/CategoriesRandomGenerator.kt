package menu.domain.category

import camp.nextstep.edu.missionutils.Randoms
import menu.domain.Category

class CategoriesRandomGenerator : CategoriesGenerator {
    override fun generate(): Category {
        val categories = listOf<Category>(Category.일식, Category.한식, Category.중식, Category.아시안, Category.양식)
        return categories[Randoms.pickNumberInRange(1, 5) - 1]
    }
}