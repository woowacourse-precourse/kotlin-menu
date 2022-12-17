package menu.service

import camp.nextstep.edu.missionutils.Randoms
import menu.repository.MenuRepository

class MenuService {
    private val menuRepository = MenuRepository()

    fun recommendMenuByDaysOfWeek(coach: String, inedibleFoods: List<String>) {

    }

    fun recommendMenu(inedibleFoods: List<String>) {
        val categories = menuRepository.getAllCategoryAsString()
        val randomCategoryName = categories[Randoms.pickNumberInRange(1, 5)]
        val randomCategory = menuRepository.getCategory(randomCategoryName)
        randomCategory?.getRandomFood(inedibleFoods)
    }
}