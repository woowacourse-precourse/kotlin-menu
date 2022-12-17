package menu.domain

import menu.domain.model.FoodCategory

class CategoryRecommandService(
    private val numberGenerator: GenerateNumber
) {

    fun recommandCategory(): FoodCategory = FoodCategory.categoryOf(numberGenerator.generate())


}