package menu.model

class Menu(private  val categories : List<Category>){

    private var foods  = listOf<String>()

    fun setMenu(hateFoods : List<String>) {
        val foodsMaker = FoodMaker(FoodRandomGenerator()).makeFoods(categories, hateFoods)
        this.foods = foodsMaker
    }

    fun getFoods() = foods
}