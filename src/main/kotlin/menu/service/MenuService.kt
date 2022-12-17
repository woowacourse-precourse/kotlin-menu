package menu.service

import camp.nextstep.edu.missionutils.Randoms
import menu.repository.MenuRepository

class MenuService {
    private val menuRepository = MenuRepository()

    fun recommendMenuByDaysOfWeek(inEdibleFoodsAboutCoaches: Map<String, List<String>>): Map<String, List<String>> {
        inEdibleFoodsAboutCoaches.forEach { (coach, inEdibleFoods) ->
            while (menuRepository.getRecommendedFoodsSize(coach) != WEEKDAY_SIZE) {
                val recommendedMenu = recommendMenu(coach, inEdibleFoods)
                menuRepository.putMenu(coach, recommendedMenu)
            }
        }
        return menuRepository.getCoachRecommendedMenus()
    }

    private fun recommendMenu(coach: String, inedibleFoods: List<String>): String {
        val categories = menuRepository.getAllCategoryAsString()
        val randomCategoryName = categories[Randoms.pickNumberInRange(1, 5)]
        val randomCategory = menuRepository.getCategory(randomCategoryName)

        do {
            val randomMenu = randomCategory?.getRandomFood(inedibleFoods)!!
            if(randomMenu !in menuRepository.getRecommendFoods(coach) && isMenuCategoryLessThan(coach, randomMenu, 2)) {
                return randomMenu
            }
        } while (true) // 이미 추천한 메뉴가 포함되어 있지 않을 때까지
    }

    private fun isMenuCategoryLessThan(coach: String, menu: String, size: Int): Boolean {
        val category = menuRepository.getCategoryByMenu(menu)
        val recommendedSizes = menuRepository.getRecommendedSizePerCategories(coach)
        return (recommendedSizes[category] ?: 0) <= size
    }

    companion object {
        private const val WEEKDAY_SIZE = 5
    }
}