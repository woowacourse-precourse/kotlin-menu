package menu

class LaunchMenuService {

    fun getCategories(categoriesGenerator: CategoriesGenerator):List<Category>{
        val categories = mutableListOf<Category>()
        while(categories.size!=5){
            val category = categoriesGenerator.generate()
            if(isValidCategory(categories,category)) categories.add(category)
        }
        return categories
    }

    fun isValidCategory(categories:List<Category>,category: Category):Boolean{
        if(categories.count{presentCategory-> presentCategory == category}> MAX_DUPLICATED_CATEGORY_NUMBER) return false
        return true
    }

    fun getMenu(category: Category,impossibleMenus:List<String>,menuGenerator: MenuGenerator):String{
        val menu = menuGenerator.generate(category.food)
        if(isValidMenu(impossibleMenus,menu)) return menu
        return getMenu(category,impossibleMenus,menuGenerator)
    }

    fun isValidMenu(impossibleMenus: List<String>, menu:String):Boolean{
        if(impossibleMenus.contains(menu)) return false
        return true
    }

    fun categoryToString(categories:List<Category>):List<String>{
        val categoriesToString = mutableListOf<String>()
        categories.forEach{category->
            categoriesToString.add(category.categoryName)
        }
        return categoriesToString
    }

    companion object{
        const val MAX_DUPLICATED_CATEGORY_NUMBER = 2
    }
}