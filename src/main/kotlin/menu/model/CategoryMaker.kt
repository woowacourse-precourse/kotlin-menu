package menu.model

import menu.util.Constants

class CategoryMaker(private val categoryRandomGenerator: CategoryRandomGenerator){

    fun makeCategories() : List<Category> {
        val categories = mutableListOf<Category>()
        while(categories.size != Constants.LIMIT_DAYS) {
            val category = getCategory()
            if(categories.count { it == category } < Constants.LIMIT_CATEGORY_DISTINCT ) categories.add(category)
        }
        return categories
    }

    fun getCategory() : Category = categoryRandomGenerator.generate()

}