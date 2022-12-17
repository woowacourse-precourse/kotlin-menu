package menu

import menu.domain.Category

class CategoryService {


    fun makeFoodCategory() : ArrayList<String>{
        var categoryGroup = ArrayList<String>()
        while (categoryGroup.size != 5){
            val foodNum = Category().choiceCategory()
            if (categoryGroup.count{it == foodNum} >= 2){
                continue
            }
            categoryGroup.add(foodNum)
        }

        return categoryGroup
    }

}