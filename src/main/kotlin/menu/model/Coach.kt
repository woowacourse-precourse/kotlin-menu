package menu.model

class Coach(
    private val name: String,
    private val cantEatMenus: List<String>
) {

    private val recommendations: MutableList<String> = mutableListOf()

    fun containsCantEatMenu(menu: String): Boolean {
        repeat(cantEatMenus.size) { index ->
            if(cantEatMenus[index] == menu) {
                return true
            }
        }

        return false
    }

    fun containsRecommends(menus: List<String>): Boolean {
        repeat(recommendations.size) { index ->
            if(menus.contains(recommendations[index])) {
                return true
            }
        }

        return false
    }

    fun addRecommendation(recommendation: String) {
        recommendations.add(recommendation)
    }

}