package menu.data

object State {
    var coachNames: List<String> = emptyList()
    var inedibleFoods: HashMap<String, List<String>> = hashMapOf()
    val recommendedFoods: HashMap<String, ArrayList<String>> = hashMapOf()
    var categories: ArrayList<String> = arrayListOf()
}