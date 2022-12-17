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

    fun processRecommendMenu() {
        for (i in DAYS_FIRST_COUNT..DAYS_LAST_COUNT) {
            var selectedCategory: FoodCategory
            while (true) {
                selectedCategory = getSelectCategory()!!
                println(selectedCategory)
                if (isValidSelectedFoodCategory()) {
                    break
                } else {
                    recommendFoodCateories[selectedCategory.name] = recommendFoodCateories[selectedCategory.name]!! - 1
                }
            }
            selectingMenu(selectedCategory)
        }

        println(recommendMenuTable)
        println()
        println(recommendFoodCateories)
    }

    fun getSelectCategory(): FoodCategory? {
        val categoryNumber = Randoms.pickNumberInRange(1, 5)
        for (fc in FoodCategory.values()) {
            if (fc.getCategoryNumber() == categoryNumber) {
                recommendFoodCateories[fc.name] = recommendFoodCateories[fc.name]!! + 1
                println(recommendFoodCateories[fc.name])
                return fc
            }
        }
        return null
    }

    fun isValidSelectedFoodCategory(): Boolean {
        recommendFoodCateories.forEach { it ->
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
    fun selectingMenu(foodCategory: FoodCategory) {
        val foodNames = foodCategory.getFoodNames()
        for (coach in recommendMenuTable.keys) {
            while (true) {
                val selectedMenu = shuffleMenu(foodNames)
                println("selectedMenu,$selectedMenu")
                if (checkSelectedMenu(selectedMenu = selectedMenu, coach = coach)) { // 성공하면
                    val currentMenus = recommendMenuTable[coach]
                    currentMenus!!.add(selectedMenu)
                    recommendMenuTable[coach] = currentMenus
//                    println(recommendMenuTable[coach])
                    break
                } else { // 실패하면
//                    println("fail")
//                    println(recommendMenuTable[coach])
                }
            }
        }
    }

    fun shuffleMenu(foodNames: List<String>): String {
        return Randoms.shuffle(foodNames)[0].split(", ")[0]
    }

    fun checkSelectedMenu(selectedMenu: String, coach: String): Boolean {
        if (!notEatMenuCheck(coach = coach, selectedMenu = selectedMenu)) {
            return false
        }
        if (duplicatedMenusCheck(coach = coach, selectedMenu = selectedMenu)) {
            return false
        }

        return true
    }

    fun notEatMenuCheck(coach: String, selectedMenu: String): Boolean {
        if (selectedMenu in coachesNotEatFoods[coach]!!) {
            return false
        }
        return true
    }

    fun duplicatedMenusCheck(coach: String, selectedMenu: String): Boolean {
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