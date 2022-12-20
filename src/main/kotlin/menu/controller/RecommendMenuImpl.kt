package menu.controller

import camp.nextstep.edu.missionutils.Randoms
import menu.model.*

class RecommendMenuImpl(coaches: List<Coach>) : RecommendMenu() {
    private val week = Week()
    private val menu = Menu()
    private val randomNumberGenerator = RandomNumberGenerator()

    init {
        val category = Randoms.shuffle(Category.values().toList())[0]
        addRandomCategory(category)
        recommendMenu(coaches, category, menu)
    }

    override fun isDuplicateCategory(category: Category): Boolean {
        return week.getCategories().count { category -> category == category } > 2
    }

    override fun addRandomCategory(category: Category) {
        if (!isDuplicateCategory(category)) {
            val categoriesName = Category.values().map { category -> category.getCategoryName() }
            week.addCategory(categoriesName[randomNumberGenerator.generator()])
        }
    }

    override fun isDuplicateMenu(coach: Coach, menu: String): Boolean {
        return coach.getRecommendedMenus().contains(menu)
    }

    override fun hasExcludeMenu(coach: Coach, menu: String): Boolean {
        return coach.getExcludeMenus().contains(menu)
    }

    override fun recommendMenu(coachs: List<Coach>, category: Category, menu: Menu) {
        val menu = Randoms.shuffle(menu.getCategoryMenu(category.getCategoryName()))[0]
        coachs.forEach { coach ->
            if (!isDuplicateMenu(coach, menu) && !hasExcludeMenu(coach, menu)) coach.addRecommendedMenus(menu)
        }
    }

}