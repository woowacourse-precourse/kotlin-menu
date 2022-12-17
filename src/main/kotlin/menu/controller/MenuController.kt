package menu.controller

import camp.nextstep.edu.missionutils.Randoms
import menu.data.Categories
import menu.data.Menus
import menu.input.InputView
import menu.output.OutputView

class MenuController {
    // TODO: 전체적인 메뉴 추천 기능 진행

    private val inputView = InputView()
    private val outputView = OutputView()

    private val coaches: List<String>
    private val notEatMenus = mutableListOf<List<String>>()

    private val recommendCategories= mutableListOf<String>()
    private val recommendMenus = mutableListOf<List<String>>()

    init {
        setRecommendCategory()

        outputView.startRecommendMenu()

        outputView.inputCoachName()
        coaches = inputView.inputCoachName()

        notEatMenu()

        recommendMenu()

        outputView.resultRecommendMenu()
        outputView.outputHeaderDay()
        outputView.outputCategory(recommendCategories)
        outputView.outputRecommendMenu(coaches, recommendMenus)
        outputView.outputSuccessRecommend()
    }

    private fun notEatMenu() {
        coaches.forEach {
            outputView.inputNotEatMenu(it)
            notEatMenus.add(inputView.inputNotEatMenu(it))
        }
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

    private fun setRecommendCategory() {
        for(day in 0 until 5) {
            var category = getCategory()

            while(true) {
                if(recommendCategories.count{ it == category } < 2) {
                    break
                }
                category = getCategory()
            }
            recommendCategories.add(category)
        }
    }

    private fun getCategory(): String {
        return Categories.categories[Randoms.pickNumberInRange(1, 5) - 1]
    }
}