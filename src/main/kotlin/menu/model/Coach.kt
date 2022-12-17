package menu.model

class Coach(
    private val name: String,
    private val cantEatMenus: List<String>
) {

    private val recommendations: MutableList<DayWeekRecommendation> = mutableListOf()

    fun containsMenu(menu: String): Boolean {
        repeat(cantEatMenus.size) { index ->
            if(cantEatMenus[index] == menu) {
                return true
            }
        }

        return false
    }

    fun addRecommendation(dayWeekRecommendation: DayWeekRecommendation) {
        recommendations.add(dayWeekRecommendation)
    }

}