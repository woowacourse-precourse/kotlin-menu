package menu.domain

class Coach(private val names: List<CoachName>) {

    fun isSize(): Boolean =


    companion object {
        fun from(names: List<String>): Coach =
            Coach(names.map { coach ->
                CoachName(coach)
            })
    }
}