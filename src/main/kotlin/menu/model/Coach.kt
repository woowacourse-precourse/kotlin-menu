package menu.model

class Coach(
    private val name: String,
    private val cantEatMenus: List<String>
) {

    fun containsMenu(menu: String): Boolean {
        repeat(cantEatMenus.size) { index ->
            if(cantEatMenus[index] == menu) {
                return true
            }
        }

        return false
    }

}