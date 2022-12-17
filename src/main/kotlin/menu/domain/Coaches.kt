package menu.domain

class Coaches(val coaches: List<Coach>) {

    init {
        require(coaches.size in MIN_COACH..MAX_COACH)
    }

    companion object {
        private const val MIN_COACH = 2
        private const val MAX_COACH = 5
    }
}