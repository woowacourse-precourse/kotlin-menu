package menu.domain

import menu.dto.CoachesDTO

class CoachGenerator {
    fun generate(inputs: Map<String, List<String>>): CoachesDTO {
        val coaches = mutableListOf<Coach>()
        inputs.map { (name, menus) ->
            coaches.add(Coach(name, menus))
        }
        return CoachesDTO(coaches)
    }
}