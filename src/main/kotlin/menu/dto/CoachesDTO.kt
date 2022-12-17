package menu.dto

import menu.domain.Coach

class CoachesDTO(private val coaches: List<Coach>) {
    fun getCoaches(): List<Coach> {
        return coaches
    }
}