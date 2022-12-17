package menu

class Categories(private val categoryNames:List<Category>) {


    fun get(num:Int):String{
        return categoryNames[num-1].country
    }
    fun checkCount(num:Int):Boolean{
        if(categoryNames[num-1].count>2) return false

        return true
    }
}