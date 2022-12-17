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

    fun countContainsRecommends(menus: List<String>): Int {
        var count = 0

        repeat(recommendations.size) { index ->
            if(menus.contains(recommendations[index])) {
                count++
            }
        }

        return count
    }

    fun containsRecommend(menu: String): Boolean {
        return recommendations.contains(menu)
    }

    fun addRecommendation(recommendation: String) {
        recommendations.add(recommendation)
    }

}