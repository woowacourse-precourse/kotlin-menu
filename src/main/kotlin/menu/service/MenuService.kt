package menu.service

import camp.nextstep.edu.missionutils.Randoms
import menu.repository.MenuRepository

class MenuService {
    private val menuRepository = MenuRepository()

    fun recommendMenuByDaysOfWeek(inEdibleFoodsAboutCoaches: Map<String, List<String>>) {
        for (day in 0 until WEEKDAY_SIZE) {
            val coaches = inEdibleFoodsAboutCoaches.keys.toList()
            val recommendedMenus = recommendMenu(coaches, inEdibleFoodsAboutCoaches)
            menuRepository.putMenu(day, coaches, recommendedMenus)
        }
    }

    private fun recommendMenu(coaches: List<String>, inEdibleFoodsAboutCoaches: Map<String, List<String>>): List<String> {
        do {
            val categories = menuRepository.getAllCategoryAsString()
            val randomCategoryName = categories[Randoms.pickNumberInRange(1, 5)]
            if (validateCategory(randomCategoryName)) continue
            val recommendedMenus = arrayListOf<String>()
            coaches.forEach { coach ->
                val inedibleFoods = inEdibleFoodsAboutCoaches[coach]
                val randomCategory = menuRepository.getCategory(randomCategoryName)
                val randomMenu = randomCategory?.getRandomFood(inedibleFoods!!)!!
                if (validateRecommendable(coach, randomMenu)) return@forEach
                recommendedMenus.add(randomMenu)
            }
            menuRepository.plusCategoryCount(randomCategoryName)
            return recommendedMenus
        } while (true)
    }

    private fun validateCategory(randomCategoryName: String): Boolean {
        if (!isMenuCategoryLessThan(randomCategoryName, 2)) {
            return true
        }
        return false
    }

    private fun validateRecommendable(coach: String, randomMenu: String): Boolean {
        if (!isMenuCategoryLessThan(randomMenu, 2)) {
            return true
        }
        if (menuRepository.isRecommendedAlready(randomMenu, coach)) {
            return true
        }
        return false
    }

    private fun isMenuCategoryLessThan(categoryName: String, size: Int): Boolean {
        val recommendedSizes = menuRepository.getCategoriesCount(categoryName)
        return recommendedSizes < size
    }

    fun getRecommendedMenus() = menuRepository.getCoachRecommendedMenus()

    companion object {
        private const val WEEKDAY_SIZE = 5
    }
}