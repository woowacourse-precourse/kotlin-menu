package menu

import menu.UI.OutputView

class ServiceController {
    fun serviceStart(){
        OutputView().serviceStart()

        var coaches = Domain().createCoach()
        coaches = Domain().coachHateFood(coaches)
        var weekCategory = mutableListOf<String>()
        for (i in 0..4){
            weekCategory = Domain().createCategory(weekCategory)
            coaches = Domain().coachMenuRecommend(coaches, weekCategory[i])
        }
        Domain().serviceResult(coaches, weekCategory)
    }
}