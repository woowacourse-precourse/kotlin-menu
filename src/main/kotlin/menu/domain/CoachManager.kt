package menu.domain

class CoachManager(coachNames: List<String>,
                   unavailableFoods: List<List<String>>) {
    private val coaches = mutableListOf<Coach>()
    init {
        for (i in coachNames.indices){
            coaches.add(Coach(coachNames[i], unavailableFoods[i]))
        }
    }
}