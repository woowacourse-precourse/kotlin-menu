package menu.domain

import camp.nextstep.edu.missionutils.Randoms
import menu.values.Category
import java.util.*

class CategoryGenerator() {

    private val categories =  mutableListOf<Category>()

    fun generate():List<Category>{
        while (categories.size < 5) {
            val randomNumber = Randoms.pickNumberInRange(1, 5)
            addCategories(randomNumber)
        }
        return categories
    }

    private fun addCategories(randomNumber: Int) {
        var category = Category.KOR
        when (randomNumber) {
            Category.JAP.number -> category = Category.JAP
            Category.KOR.number -> category = Category.KOR
            Category.CHA.number -> category = Category.CHA
            Category.ASH.number -> category = Category.ASH
            Category.WES.number -> category = Category.WES
        }
        if(Collections.frequency(categories,category)<2){
            categories.add(category)
        }
    }

}