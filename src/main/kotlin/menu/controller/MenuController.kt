package menu.controller

import camp.nextstep.edu.missionutils.Randoms
import menu.data.Menus

class MenuController(private val coaches: List<String>, private val recommendCategories: List<String>, private val notEatMenus: List<List<String>>) {
    private val recommendMenus = mutableListOf<List<String>>()

    init {
        recommendMenu()
    }

    private fun recommendMenu() {
        recommendCategories.forEach {
            val nowDay = mutableListOf<String>()
            for(coachIndex in coaches.indices) {
                val menu = getMenu(it, coachIndex)
                nowDay.add(menu)
            }

            recommendMenus.add(nowDay)
        }
    }

    fun getRecommendMenus(): List<List<String>> = recommendMenus

    private fun checkEatMenu(menuName: String, coachIndex: Int): Boolean {
        if(notEatMenus[coachIndex].contains(menuName))
            return true

        recommendMenus.forEach {
            if(it[coachIndex] == menuName)
                return true
        }

        return false
    }

    private fun getMenu(category: String, coachIndex: Int): String {
        var menuName = ""

        do{
            when(category) {
                "일식" -> { menuName = Randoms.shuffle(Menus.japanMenus)[0] }
                "한식" -> { menuName = Randoms.shuffle(Menus.korMenus)[0] }
                "중식" -> { menuName = Randoms.shuffle(Menus.chinaMenus)[0] }
                "아시안" -> { menuName = Randoms.shuffle(Menus.asianMenus)[0] }
                "양식" -> { menuName = Randoms.shuffle(Menus.eastMenus)[0] }
            }
        }while(checkEatMenu(menuName, coachIndex))

        return menuName
    }
}