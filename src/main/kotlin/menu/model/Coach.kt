package menu.model

import menu.exceptions.ValidateBusinessLogic

class Coach(coachName: String) {

    private var name = ""
    private val cantEat = mutableListOf<String>()
    private val recommendedMenus = mutableListOf<String>()

    init {
        ValidateBusinessLogic.validateCoachName(coachName)
        name = coachName
    }

    fun initRecommendedMenus(pickedCategory: String) {
        while (recommendedMenus.size < 5) {
            val pickedMenu = Menu.getRandomPickedMenu(Menu.getPickedCategoryMenus(pickedCategory)!!)
            if (cantEat.contains(pickedMenu)) continue
            recommendedMenus.add(pickedMenu)
        }
    }

    fun getName() = name

    fun setCantEat(cantEat: List<String>) {
        ValidateBusinessLogic.validateCantEatCount(cantEat.size)
        this.cantEat.addAll(cantEat)
    }

    fun getCantEat() = cantEat

    fun getRecommendMenus() = recommendedMenus

}