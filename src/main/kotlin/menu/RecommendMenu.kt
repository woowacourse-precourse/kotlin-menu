package menu

import camp.nextstep.edu.missionutils.Randoms

class RecommendMenu(private val coachesNotEatFoods: Map<String, List<String>>) {

    var recommendMenuTable = mutableMapOf<String, MutableList<String>>() // 태경 : ["피자","초밥"]
    var recommendFoodCateories = mutableMapOf<String, Int>() // 양식 : 1

    init {
        for (fc in FoodCategory.values()) {
            recommendFoodCateories[fc.name] = 0
        }
        coachesNotEatFoods.forEach { it ->
            recommendMenuTable[it.key] = mutableListOf()
        }
    }

    fun processRecommendMenu(): MutableMap<String, MutableList<String>>{
        for (i in DAYS_FIRST_COUNT..DAYS_LAST_COUNT) {
            var selectedCategory: FoodCategory
            while (true) {
                selectedCategory = getSelectCategory()!!
                if (isValidSelectedFoodCategory()) {
                    break
                } else {
                    recommendFoodCateories[selectedCategory.name] = recommendFoodCateories[selectedCategory.name]!! - 1
                }
            }
            selectingMenu(selectedCategory)
        }

        return recommendMenuTable
    }

    private fun getSelectCategory(): FoodCategory? {
        val categoryNumber = Randoms.pickNumberInRange(1, 5)
        for (fc in FoodCategory.values()) {
            if (fc.getCategoryNumber() == categoryNumber) {
                recommendFoodCateories[fc.name] = recommendFoodCateories[fc.name]!! + 1
                return fc
            }
        }
        return null
    }

    private fun isValidSelectedFoodCategory(): Boolean {
        recommendFoodCateories.forEach { it ->
            if (it.value > 2) {
                return false
            }
        }
        return true
    }


    private fun selectingMenu(foodCategory: FoodCategory) {
        val foodNames = foodCategory.getFoodNames()
        for (coach in recommendMenuTable.keys) {
            while (true) {
                val selectedMenu = shuffleMenu(foodNames)
                if (checkSelectedMenu(selectedMenu = selectedMenu, coach = coach)) { // 성공하면
                    val currentMenus = recommendMenuTable[coach]
                    currentMenus!!.add(selectedMenu)
                    recommendMenuTable[coach] = currentMenus
                    break
                }
            }
        }
    }

    private fun shuffleMenu(foodNames: List<String>): String {
        return Randoms.shuffle(foodNames)[0]
    }

    private fun checkSelectedMenu(selectedMenu: String, coach: String): Boolean {
        if (!notEatMenuCheck(coach = coach, selectedMenu = selectedMenu)) {
            return false
        }
        if (duplicatedMenusCheck(coach = coach, selectedMenu = selectedMenu)) {
            return false
        }

        return true
    }

    private fun notEatMenuCheck(coach: String, selectedMenu: String): Boolean {
        if (selectedMenu in coachesNotEatFoods[coach]!!) {
            return false
        }
        return true
    }

    private fun duplicatedMenusCheck(coach: String, selectedMenu: String): Boolean {
        if (selectedMenu in recommendMenuTable[coach]!!) {
            return true
        }
        return false
    }


    companion object {
        const val DAYS_FIRST_COUNT = 0
        const val DAYS_LAST_COUNT = 4
    }


}