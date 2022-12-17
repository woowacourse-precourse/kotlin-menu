package menu.domain

import menu.utils.ERROR
import menu.utils.ERROR_COACH_SIZE
import menu.utils.MAX_COACH_COUNT
import menu.utils.MIN_COACH_COUNT

class Coach(private val names: List<String>) {

    init {
        require(isSize()) { ERROR.format(ERROR_COACH_SIZE) }
    }

    fun names(): List<CoachName> =
        this.names.map { name ->
            CoachName(name)
        }

    private fun isSize(): Boolean =
        names.size >= MIN_COACH_COUNT && names.size <= MAX_COACH_COUNT
}