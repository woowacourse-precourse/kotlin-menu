package menu.domain

class Coach(private val name: String) {
    private val eatenFoods = mutableListOf<String>()  // 이미 먹은 음식 리스트
    private var unavailableFoods = listOf<String>()   // 먹지 못하는 음식 리스트

    fun addEatenFood(food: String) {
        eatenFoods.add(food)
    }

    fun addUnavailableFood(unavailableFoods: List<String>) {
        this.unavailableFoods = unavailableFoods
    }

    fun getEatenFoods(): MutableList<String> {
        return this.eatenFoods
    }

    fun getUnavailableFoods(): List<String> {
        return this.unavailableFoods
    }

    fun getName(): String {
        return this.name
    }
}