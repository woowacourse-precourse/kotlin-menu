package menu.model

class FoodMaker(private val foodRandomGenerator: FoodRandomGenerator) {

    fun makeFoods(categories: List<Category>, hateFoods : List<String>) {
        val foods = mutableListOf<String>()
        categories.forEach {
            val food = getFood(it.getFoods())
            if(foods.contains(food).not() && hateFoods.contains(food).not()) foods.add(food)
        }

    }
    fun getFood(menus: List<String>) = foodRandomGenerator.generate(menus)
}