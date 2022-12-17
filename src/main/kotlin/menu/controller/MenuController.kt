package menu.controller

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import menu.domain.Category
import menu.utils.CATEGOTY
import menu.utils.DAYS
import menu.view.InputView

class MenuController {
    fun run() {
        val coaches = InputView.readCoaches().names()
        val weekend = mutableMapOf<String, String>()
        val categories = CATEGOTY.split(", ")
        val days = DAYS.split(", ")
        var tryNumber = 1
        while (tryNumber <= 5) {
            val category = categories.get(Randoms.pickNumberInRange(1, 5))
            if (weekend.values.filter { it == category }.size >= 2) {
                continue
            }
            weekend[days[tryNumber]] = category
            tryNumber++
        }

        val coachMenus = mutableMapOf<String, MutableList<MutableList<String>>>()
        val result = mutableMapOf<String, MutableList<String>>()
        for (coach in coaches) {
            coachMenus[coach.getName()] = mutableListOf()
            result[coach.getName()] = mutableListOf()
        }

        for (coach in coaches) {
            val foods = InputView.readMenus(coach).getMenus()
            println()

            for (i in 0 until 5) {
                val category = getCategory(i, weekend)
                val menus = category.menus.toMutableList()
                for (food in foods) {
                    if (menus.contains(food.getName())) {
                        menus.remove(food.getName())
                    }
                }
                for (c in coaches) {
                    coachMenus[c.getName()]?.add(menus)
                }
            }
        }
        for (i in 0 until 5) {
            for (c in result) {

                while (true) {
                    val menu = Randoms.shuffle(c.value)[0]

                    if (result[c.key]?.contains(menu) ?: false) {
                        continue
                    }
                    result[c.key]?.add(menu)
                    break
                }
            }
        }

    }
}

private fun getCategory(index: Int, weekend: MutableMap<String, String>): Category {
    val weekendCategory = weekend.values.toList().get(index)
    val category = Category.of(weekendCategory)
    return category
}