package menu.domain

class Coach(private val name: String, private val unavailableFoods: List<String>) {
    private val eatenFoods = mutableListOf<String>()  // 이미 먹은 음식 리스트

    fun addEatenFood(food: String) {
        eatenFoods.add(food)
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

    override fun toString(): String {
        return name + unavailableFoods.toString()
    }
}