package menu.controller

import menu.CategoryService
import menu.domain.Food
import menu.utils.Validator
import menu.values.MenuGroup
import menu.view.Input
import menu.view.Output

class MenuController {

    var hateFood = ArrayList<List<String>>()
    val foodType = MenuGroup.GROUP.menu.split(",").map { it }
    val koreanFood = MenuGroup.KOREAN.menu.split(",").map { it }
    val japanFood = MenuGroup.JAPAN.menu.split(",").map { it }
    val chinaFood = MenuGroup.CHINA.menu.split(",").map { it }
    val asianFood = MenuGroup.ASIAN.menu.split(",").map { it }
    val westernFood = MenuGroup.WESTERN.menu.split(",").map { it }

    fun run() {
        Output().printStart()
        val coachName = Input().printSize()

        coachHateFood(coachName)

        Output().printResultPhrases()
        Output().printStandard()

        val a = changeCategory(CategoryService().makeFoodCategory())
        println(a)

        println(Output().printFoodCategory(a))

        for (i in 0 until coachName.size) {
            println(Output().printFoodGroup(makeMenu(a), coachName[i]))
        }

        Output().printEnd()
    }

    fun coachHateFood(coachGroup: List<String>) {
        for (i in 0 until coachGroup.size) {
            hateFood.add(Input().InputHateFood(coachGroup[i]))
            println()
        }
    }

    fun changeCategory(foodCategory: ArrayList<String>): ArrayList<String> {
        var foodTypeCategory = ArrayList<String>()
        for (foodNum in 0 until foodCategory.size) {
            when (foodCategory[foodNum]) {
                "1" -> foodTypeCategory.add(foodType[0])
                "2" -> foodTypeCategory.add(foodType[1])
                "3" -> foodTypeCategory.add(foodType[2])
                "4" -> foodTypeCategory.add(foodType[3])
                "5" -> foodTypeCategory.add(foodType[4])

            }
        }
        return foodTypeCategory
    }

    fun changeCategoryName(category: ArrayList<String>, index: Int): List<String> {
        when (category[index].toString()) {
            "일식" -> return japanFood
            "한식" -> return koreanFood
            "중식" -> return chinaFood
            "아시안" -> return asianFood
            "양식" -> return westernFood
        }

        return japanFood
    }

    fun makeMenu(category: ArrayList<String>): ArrayList<String> {
        var arr = ArrayList<String>()
        for (i in 0 until 5) {
            arr.add(Food().choiceFood(changeCategoryName(category, i) as ArrayList<String>))
        }
        return arr
    }


}