package menu.model

class Coach(
    private val name : String,
    private var hateFoods : List<String>,
    private val categories : List<Category>) {

    private val menu : Menu = Menu(categories)

    fun getMenu() : List<String> {
        menu.setMenu(hateFoods)
        return menu.getFoods()
    }

    fun getName() : String = name
}