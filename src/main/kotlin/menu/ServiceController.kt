package menu

import menu.UI.OutputView

class ServiceController {
    fun serviceStart(){
        var domain = Domain()
        OutputView().serviceStart()

        var coaches = domain.createCoach()
        coaches = domain.coachHateFood(coaches)
        var weekCategory = domain.createCategory()
        coaches = domain.coachMenuRecommend(coaches, weekCategory)

        domain.serviceResult(coaches, weekCategory)
    }
}