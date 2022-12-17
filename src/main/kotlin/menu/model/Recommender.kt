package menu.model

// 카테고리 당 나온 횟수를 저장하고 있으며
// 이미 2번 나온 카테고리를 다시 추천할 경우 다시 정한다.
// 정해진 카테고리에 해당하는 메뉴를 랜덤으로 코치들에게 배정
// 해당 메뉴가 못먹는 메뉴인지 판단하여 그렇다면 다시 배정하는 기능
// 해당 메뉴가 이미 먹은 메뉴인지 판단하여 그렇다면 다시 배정하는 기능
class Recommender(coach: List<String>, banFood: MutableList<List<String>>) {
    private val japan = Menu.JAPAN
    private val korean = Menu.KOREAN
    private val china = Menu.CHINA
    private val asian = Menu.ASIAN
    private val western = Menu.WESTERN
    private val menu = listOf<Menu>(japan, korean, china, asian, western)
    private val categoryCounter = mutableListOf<Int>(0, 0, 0, 0, 0)

    fun selectCategory(categoryNumber: Int): Flag {
        if (categoryCounter[categoryNumber] == 2) {
            return Flag.FAIL
        }
        return Flag.PASS
    }

    fun getCategory(categoryNumber: Int): Menu {
        return menu[categoryNumber]
    }

}