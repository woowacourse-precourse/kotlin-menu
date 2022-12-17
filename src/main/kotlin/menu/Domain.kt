package menu

import menu.UI.InputView
import menu.UI.OutputView

class Domain {
    fun createCoach() : MutableList<Coach>{
        var coachNames = InputView().coachName()
        var coaches = mutableListOf<Coach>()
        for (i in coachNames){
            var person = Coach()
            person.setName(i)
            coaches.add(person)
        }
        return coaches
    }

    fun coachHateFood(coaches : MutableList<Coach>) : MutableList<Coach>{
        for (i in coaches){
            var hateFoods = InputView().hateFood(i)
            i.hateFood = hateFoods.toMutableList()
        }
        return coaches
    }

    fun createCategory() : MutableList<String>{
        var category = Category()
        var weekCategory = category.recommendCategory()
        return weekCategory
    }

    fun coachMenuRecommend(coaches: MutableList<Coach>, weekCategory: MutableList<String>) : MutableList<Coach>{
        var coaches = coaches
        for (i in weekCategory){
            if (i =="일식") coaches = Category().coachJapanMenu(coaches)
            if (i == "한식") coaches = Category().coachKoreaMenu(coaches)
            if (i == "중식") coaches = Category().coachChinaMenu(coaches)
            if (i == "아시안") coaches = Category().coachAsianMenu(coaches)
            if (i == "양식") coaches = Category().coachWestMenu(coaches)
        }
        return coaches
    }

    fun serviceResult(coaches: MutableList<Coach>, weekCategory: MutableList<String>){
        OutputView().menuResult(coaches, weekCategory)
        OutputView().serviceEnd()
    }
}