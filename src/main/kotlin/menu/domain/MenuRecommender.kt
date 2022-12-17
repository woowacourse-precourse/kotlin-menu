package menu.domain

import menu.util.Util

class MenuRecommender {
    val coachNameList = mutableListOf<String>()
    val hateFoodList = mutableListOf<List<String>>()
    val category = Category()
    val food = Food()
    val weekMenu = mutableListOf<MutableList<String>>()

    fun setCoachNameList(input: String) {
        val inputSplit = Util().convertCommaStringToList(input)
        coachNameList.addAll(inputSplit)
    }

    fun setHateFoodList(input: String) {
        val inputSplit = Util().convertCommaStringToList(input)
        hateFoodList.add(inputSplit)
    }

    fun pickWeekMenu() {
        for (day in 0..4) {
            val dayFood = mutableListOf<String>()
            val category = category.pickCategory()
            for (coachList in 0 until hateFoodList.size) {
                dayFood.add(addRecommendFood(hateFoodList[coachList],category))
                println(dayFood)
            }
            weekMenu.add(dayFood)
        }
        println(weekMenu)
    }

    private fun addRecommendFood(hateFood: List<String>,category : String): String {
        var coachFood = food.recommendFood(category)
        if (hateFood.contains(coachFood)) {
            return addRecommendFood(hateFood,category)
        }
        return coachFood
    }
}