package menu.controller

import camp.nextstep.edu.missionutils.Randoms
import menu.model.*

class RecommendMenuImpl(coaches: List<Coach>) : RecommendMenu() {
    private val week = Week()
    private val menu = Menu()
    private val randomNumberGenerator = RandomNumberGenerator()

    init {
        val category = Category.values()
        category.shuffle()
        repeat(week.getDayOfWeek().size) {
            addRandomCategory(category[0])
            recommendMenu(coaches, category[0], menu)
        }
    }

    override fun addRandomCategory(category: Category) {
        val categoriesCount = week.getCategories().size
        var categories = week.getCategories().size
        while (categoriesCount == categories) {
            val categoriesName = Category.values().map { category -> category.getCategoryName() }
            println("바보")
            week.addCategory(categoriesName[randomNumberGenerator.generator() - 1])
            categories = week.getCategories().size
        }
    }

    override fun isDuplicateMenu(coach: Coach, menu: String): Boolean {
        return coach.getRecommendedMenus().contains(menu)
    }

    override fun recommendMenu(coachs: List<Coach>, category: Category, menu: Menu) {
        coachs.map { coach ->
            val coachMenusCount = coach.getRecommendedMenus().size
            while (coachMenusCount == coach.getRecommendedMenus().size) {
                println("멍청이")
                val menu = Randoms.shuffle(menu.getCategoryMenu(category.getCategoryName()))[0]
                coach.addRecommendedMenus(menu)
            }
        }
    }

    fun getWeek() = week

}