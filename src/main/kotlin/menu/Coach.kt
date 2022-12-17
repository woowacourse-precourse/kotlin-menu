package menu

data class Coach(
    val name: String,
    val canNotEats: MutableList<String>,
    val menu: MutableList<String>,
)
