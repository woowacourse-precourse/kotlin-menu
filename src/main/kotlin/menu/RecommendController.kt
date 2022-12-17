package menu

class RecommendController {

    private val categories: CategoryRepository = CategoryRepository()
    private val menus: MenuRepository = MenuRepository()
    private val recommendCategory = categories.getRecommendCategory()
    private val recommendMenu: MutableMap<String, MutableList<String>> = mutableMapOf()

    private var coaches: List<String> = listOf()
    private var coachHateMenu: Map<String, List<String>> = mutableMapOf()


    fun recommend() {
        for(coach in coaches) {
            recommendMenu[coach] = mutableListOf()
        }
        for(category in recommendCategory) {
            for(coach in coaches) {
                recommendMenu[coach]!!.add(menus.getRecommendMenu(coachHateMenu[coach]!!, recommendMenu[coach]!!, category))
            }
        }
    }
}