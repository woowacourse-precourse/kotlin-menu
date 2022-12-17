package menu.domain

import menu.util.Util

class MenuRecommender {
    val coachNameList = mutableListOf<String>()
    private var ateFoodList = mutableListOf<MutableList<String>>()
    private val hateFoodList = mutableListOf<List<String>>()
    private val category = Category()
    val categoryList = mutableListOf<String>()
    private val food = Food()
    val weekMenu = mutableListOf<MutableList<String>>()

    fun setCoachNameList(input: String) {
        val inputSplit = Util().convertCommaStringToList(input)
        coachNameList.addAll(inputSplit)
        initAteFoodList(coachNameList.size)
    }

    private fun initAteFoodList(coachListSize : Int) {
        for (xIndex in 0 until coachListSize) {
            val list = mutableListOf<String>()
            for (yIndex in 0..4) {
                list.add("")
            }
            ateFoodList.add(list)
        }
    }

    fun setHateFoodList(input: String) {
        val inputSplit = Util().convertCommaStringToList(input)
        hateFoodList.add(inputSplit)
    }

    fun pickWeekMenu() {
        for (day in 0..4) {
            val dayFood = mutableListOf<String>()
            val category = category.pickCategory()
            categoryList.add(category)
            for (coach in 0 until hateFoodList.size) {
                val todayFood = addRecommendFood(hateFoodList[coach], ateFoodList[coach], category)
                dayFood.add(todayFood)
                ateFoodList[coach].add(todayFood)
            }
            weekMenu.add(dayFood)
        }
    }

    private fun addRecommendFood(hateFood: List<String>, ateFood: List<String>, category: String): String {
        var coachFood = food.recommendFood(category)
        if (hateFood.contains(coachFood) || ateFood.contains(coachFood)) {
            return addRecommendFood(hateFood, ateFood, category)
        }
        return coachFood
    }
}