package menu

class Coach(val name: String,
            var hateFood: MutableList<String>,
            var foodToEat: MutableList<String> = mutableListOf()) {

    fun checkCantEat(menu: String): Boolean {
        if (hateFood.contains(menu)) return true
        if (foodToEat.contains(menu)) return true

        return false
    }
}