package menu

import menu.UI.OutputView

class ServiceController {
    fun serviceStart(){
        var domain = Domain()
        OutputView().serviceStart()

        var coaches = domain.createCoach()
        coaches = domain.coachHateFood(coaches)
        var weekCategory = mutableListOf<String>()
        for (i in 0..4){
            weekCategory = domain.createCategory(weekCategory)
            coaches = domain.coachMenuRecommend(coaches, weekCategory[i])
        }
        domain.serviceResult(coaches, weekCategory)
    }
}