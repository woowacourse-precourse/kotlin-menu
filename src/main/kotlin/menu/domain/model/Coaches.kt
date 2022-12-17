package menu.domain.model

class Coaches(private val coaches: List<Coach>) : List<Coach> by coaches {

    init {
        require(coaches.all { coach ->
            coaches.count { it.equalName(coach.getName()) } == 1
        }) {
            "코치 이름은 중복되면 안됩니다."
        }
        require(coaches.size in 2..5) {
            "코치는 최소 2명, 최대 5명 입니다."
        }
    }
}