package menu.domain

import menu.domain.model.FoodCategory

class MenuRecommandService {

    fun recommand(foodCategory: FoodCategory): String {
        return foodCategory.recommand()
    }
}