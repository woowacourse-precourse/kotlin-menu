package menu

data class Coach(
    val name: String,
    var canNotEats: MutableList<String>,
    var menu: MutableList<String>,
)
