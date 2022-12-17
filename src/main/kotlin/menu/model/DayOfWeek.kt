package menu.model

class DayOfWeek() {
    private val category = ""
    private var menus = listOf<String>()

    fun addMenus(coachMenus:List<String>) {
        menus = coachMenus
    }

}