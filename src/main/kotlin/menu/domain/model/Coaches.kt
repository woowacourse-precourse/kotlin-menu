package menu.domain.model

class Coaches(private val coaches: List<Coach>) : List<Coach> by coaches {

    init {
        require(coaches.all {
            coaches.count { it.containsName(it.getName()) } < 2
        }) {
            "코치 이름은 중복되면 안됩니다."
        }
    }
}