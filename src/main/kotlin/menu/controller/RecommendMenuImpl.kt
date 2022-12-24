package menu.controller

import camp.nextstep.edu.missionutils.Randoms
import menu.model.*

class RecommendMenuImpl(coaches: List<Coach>) : RecommendMenu() {
    private val week = Week()
    private val menu = Menu()
    private val coaches = coaches
    private val randomNumberGenerator = RandomNumberGenerator()

    init {
        val category = Category.values()
        category.shuffle()
        repeat(week.getDayOfWeek().size) {
            addRandomCategory(category[0])
            recommendMenu(category[0], menu)
        }

    }

    override fun addRandomCategory(category: Category) {
        val categoriesCount = week.getCategories().size
        var categories = week.getCategories().size
        while (categoriesCount == categories) {
            val categoriesName = Category.values().map { category -> category.getCategoryName() }
            week.addCategory(categoriesName[randomNumberGenerator.generator() - 1])
            categories = week.getCategories().size
        }
    }

    override fun recommendMenu(category: Category, menu: Menu) {
        coaches.map { coach ->
            val coachMenusCount = coach.getRecommendedMenus().size
            while (coachMenusCount == coach.getRecommendedMenus().size) {
                println("멍청이")
                val menu = Randoms.shuffle(menu.getCategoryMenu(category.getCategoryName()))[0]
                println(menu)
                println(coach.getRecommendedMenus())
                coach.addRecommendedMenus(menu)
            }
        }
    }

    fun getWeek() = week

    fun getCoaches() = coaches
}