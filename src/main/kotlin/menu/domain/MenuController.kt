package menu.domain

class MenuController {
    private var coachNames = listOf<String>()

    fun updateCoachs(coachNames: List<String>) {
        this.coachNames = coachNames
    }
}
