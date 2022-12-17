package menu

import camp.nextstep.edu.missionutils.Randoms

class RecommandMenuController(val nameMenu: MutableList<Pair<String, List<String>>>) {
    private val menuList = RecommandMenu()
    private var dayCategory: MutableList<String> = mutableListOf()
    private val coachNumber = nameMenu.size
    private val finalResult: MutableList<String> = mutableListOf()


    fun main() {
        setDayCategory()
        setMenus()
    }

    fun getDayCategory(): MutableList<String> {
        return dayCategory
    }

    fun getFinalResult(): MutableList<String> {
        return finalResult
    }


    fun setDayCategory() {
        var wholeCount = 0
        while (wholeCount < 5) {
            val number = Randoms.pickNumberInRange(1, 5)
            val category: String = menuList.getCategories().categories()[number - 1]
            var count = 0
            for (element in dayCategory) {
                if (element == category) {
                    count++
                }
            }
            if (count < 2) {
                dayCategory.add(category)
                wholeCount++
            }
        }
    }

    fun setMenus() {
        val personMenu: MutableList<List<String>> = mutableListOf()
        for (day in dayCategory) {
            val dayMenus = mutableListOf<String>()
            for (menus in menuList.getMenus()) {
                if (menus.getCategory() == day) {
                    for (name in nameMenu) {
                        while (true) {
                            val menu = Randoms.shuffle(menus.menus())[0]
                            if (!name.second.contains(menu)) {
                                dayMenus.add(menu)
                                break
                            }
                        }
                    }
                }
            }
            personMenu.add(dayMenus)
        }
        reshapeList(personMenu)
    }

    fun reshapeList(personMenu: MutableList<List<String>>) {
        for (day in personMenu) {
            for (element in day) {
                finalResult.add(element)
            }
        }
        for (i in 0 until coachNumber) {
            val temp = mutableListOf<String>()
            for (n in 0..4) {
                temp.add(finalResult[i + coachNumber * n])
            }
            if (temp.distinct().size != 5) {
                finalResult.clear()
                setMenus()
                break
            }
        }
    }
}