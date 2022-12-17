package menu.domain

import menu.domain.model.Food
import menu.domain.model.FoodCategory

class DietGenerateService {

    fun recommandFood(category: FoodCategory): Food {
        return category.recommand()
    }
}