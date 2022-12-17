package menu

import camp.nextstep.edu.missionutils.Randoms

class RecommendMenu(private val coachesNotEatFoods: Map<String, List<String>>) {

    var recommendMenuTable = mutableMapOf<String, List<String>>()

    var recommendFoodCateories = mutableMapOf<String, Int>()

    init {
        for (fc in FoodCategory.values()) {
            recommendFoodCateories[fc.name] = 0
        }

        coachesNotEatFoods.forEach { it ->
            recommendMenuTable[it.key] = listOf()
        }
    }

    fun processRecommendMenu() {
        for (i in DAYS_FIRST_COUNT..DAYS_LAST_COUNT) {
            while (true) {
                val selectedCategory = getSelectCategory()
                if (isValidSelectedFoodCategory()) {
                    break
                } else {
                    recommendFoodCateories[selectedCategory?.name]?.minus(1)
                }
            }




        }
    }

    fun getSelectCategory(): FoodCategory? {
        val categoryNumber = Randoms.pickNumberInRange(1, 5)
        for (fc in FoodCategory.values()) {
            if (fc.getCategoryNumber() == categoryNumber) {
                recommendFoodCateories[fc.name]?.plus(1)
                return fc
            }
        }
        return null
    }

    fun isValidSelectedFoodCategory(): Boolean {
        recommendFoodCateories.forEach{it ->
            if (it.value > 2) {
                return false
            }
        }
        return true
    }




//    임의로 메뉴의 순서 또는 데이터를 변경하면 안 된다.
//    Randoms.shuffle() 메서드의 인자로 전달되는 메뉴 데이터는, 최초에 제공한 목록을 그대로 전달해야 한다.
//    코치에게 추천할 메뉴를 정할 때 이미 추천한 메뉴, 먹지 못하는 메뉴도 포함된 리스트를 전달해야 한다.
//    추천할 수 없는 메뉴인 경우 다시 섞은 후 첫 번째 값을 사용해야 한다.
    fun selectFood(foodCategory: FoodCategory) {



    }

    companion object {
        const val DAYS_FIRST_COUNT = 0
        const val DAYS_LAST_COUNT = 4
    }


}