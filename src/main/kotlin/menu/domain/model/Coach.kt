package menu.domain.model

class Coach(
    private val name: String,
    private val inedible: MutableList<Food> = mutableListOf()
) {

    init {
        require(name.length in 2..4) {
            "코치의 이름은 2글자 이상 4글자 이하로 작성해 주세요."
        }
    }

    fun getName() = name

    fun addInedible(food: Food) {
        require(!inedible.contains(food)) {
            "해당 음식은 이미 입력됬습니다."
        }
        inedible.add(food)
    }

    fun containsName(checkingName: String): Boolean {
        return name == checkingName
    }
}