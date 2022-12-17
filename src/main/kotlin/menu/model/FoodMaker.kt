package menu.model

import menu.util.Constants

class FoodMaker(private val foodRandomGenerator: FoodRandomGenerator) {

    fun makeFoods(categories: List<Category>, hateFoods : List<String>) : List<String> {
        val foods = mutableListOf<String>()
        var idx = 0
        while(foods.size != Constants.LIMIT_DAYS) {
            val food = getFood(Category.getFoods(categories.get(idx)))
            if(!foods.contains(food) && !hateFoods.contains(food)) {
                foods.add(food)
                idx++
            }
        }
        return foods
    }
    fun getFood(menus: List<String>) = foodRandomGenerator.generate(menus)

}