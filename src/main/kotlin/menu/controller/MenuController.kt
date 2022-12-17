package menu.controller

import camp.nextstep.edu.missionutils.Randoms
import menu.domain.MenuMachine
import menu.util.*
import menu.view.InputView

class MenuController(
    private val inputView: InputView
) {
    lateinit var coaches: List<String>
    private var notEatMenus = mutableListOf<List<String>>()
    // 한주에 먹을 카테고리 리스트
    private val categories = mutableListOf<Int>()
    // 코치들의 한주의 먹을 음식 리스트
    private lateinit var weeklyCoachesMenus: Array<MutableList<String>>

    /*
     * 코치들의 이름과 못먹는 음식 initialize
     */
    fun inputCoachInfo() {
        coaches = inputView.readCoachName()
        coaches.forEach { coach ->
            notEatMenus.add(inputView.readCoachNotEat(coach))
        }
    }

    // 먹을 카테고리 선택
    private fun choseCategory(): Int {
        val category = randomCategory(categories)
        categories.add(category)
        return category
    }

    fun recommendWeeklyMenuList() {
        weeklyCoachesMenus = Array(coaches.size) { mutableListOf() }
        // 한 주동안 먹을 음식 추천
        repeat(MAX_DAY) {
            val category = choseCategory()
            for (index in coaches.indices) {
                val menu = randomMenu(weeklyCoachesMenus[index], index, category)
                weeklyCoachesMenus[index].add(menu)
            }
        }
    }

    // 한주의 같은 음식과 코치가 먹지 못하는 음식을 제외하고 음식 하나 추천
    private fun randomMenu(menus: MutableList<String>, index: Int, category: Int): String {
        val coachNotEat = notEatMenus[index]
        val categoryMenus = getCategoryMenus(category)
        val choseMenu = Randoms.shuffle(categoryMenus)[0]
        if (menus.contains(choseMenu) || coachNotEat.contains(choseMenu)) {
            randomMenu(menus, index, category)
        }
        return choseMenu
    }

    private fun getCategoryMenus(category: Int): List<String> {
        return when (category) {
            1 -> MenuMachine(JAPAN_MENUS).convertToList()
            2 -> MenuMachine(KOREAN_MENUS).convertToList()
            3 -> MenuMachine(CHINESE_MENUS).convertToList()
            4 -> MenuMachine(ASIAN_MENUS).convertToList()
            5 -> MenuMachine(AMERICA_MENUS).convertToList()
            else -> { throw IllegalArgumentException(ERROR_HEADER + ERROR_CATEGORY_NUMBER)}
        }
    }


    // 한주에 2회까지만 같은 카테고리 음식을 받을 수 있다
    private fun randomCategory(categories: MutableList<Int>): Int {
        val chose = Randoms.pickNumberInRange(1, 5)
        if (2 <= categories.count { category -> category == chose }) {
            randomCategory(categories)
        }
        return chose
    }
}