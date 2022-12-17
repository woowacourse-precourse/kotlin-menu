package menu

class Categories(private val categoryNames:MutableList<Category>) {


    fun get(num:Int):Category{
        return categoryNames[num-1]
    }
    fun checkCount(num:Int):Boolean{
        if(categoryNames[num-1].count>2) return false

        return true
    }

    fun getLastCategoryMenus(num:Int):List<String>{
        return categoryNames[num].menus
    }
    fun add(category:Category){
        categoryNames.add(category)
    }

    fun getCategories():List<String>{
        var categoryList= mutableListOf<String>()
        for(category in categoryNames){
            categoryList.add(category.country)
        }
        return categoryList
    }
}