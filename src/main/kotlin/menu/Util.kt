package menu

class Util {
    fun getAllFood():List<String>{
        val allFood = mutableListOf<String>()
        allFood.addAll(Category.양식.food)
        allFood.addAll(Category.한식.food)
        allFood.addAll(Category.중식.food)
        allFood.addAll(Category.아시안.food)
        allFood.addAll(Category.일식.food)
        return allFood
    }
}