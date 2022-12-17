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

    companion object{
        const val MAX_DUPLICATED_CATEGORY_NUMBER = 2
    }
}