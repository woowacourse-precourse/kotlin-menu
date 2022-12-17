package menu

import menu.UI.InputView
import menu.UI.OutputView

class Domain {
    fun createCoach() : MutableList<Coach>{
        val coachNames = InputView().coachName()
        val coaches = mutableListOf<Coach>()
        for (i in coachNames){
            val person = Coach()
            person.setName(i)
            coaches.add(person)
        }
        return coaches
    }

    fun coachHateFood(coaches : MutableList<Coach>) : MutableList<Coach>{
        for (i in coaches){
            val hateFoods = InputView().hateFood(i)
            i.hateFood = hateFoods.toMutableList()
        }
        return coaches
    }

    fun createCategory(weekCategory: MutableList<String>) : MutableList<String>{
        var weekCategory = weekCategory
        weekCategory = Category().recommendCategory(weekCategory)
        return weekCategory
    }

    fun coachMenuRecommend(coaches: MutableList<Coach>, category: String) : MutableList<Coach>{
        var coaches = coaches
        if (category =="일식") coaches = Category().coachJapanMenu(coaches)
        if (category == "한식") coaches = Category().coachKoreaMenu(coaches)
        if (category == "중식") coaches = Category().coachChinaMenu(coaches)
        if (category == "아시안") coaches = Category().coachAsianMenu(coaches)
        if (category == "양식") coaches = Category().coachWestMenu(coaches)
        return coaches
    }

    fun serviceResult(coaches: MutableList<Coach>, weekCategory: MutableList<String>){
        OutputView().menuResult(coaches, weekCategory)
        OutputView().serviceEnd()
    }
}