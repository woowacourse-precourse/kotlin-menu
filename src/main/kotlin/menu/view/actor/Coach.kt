package menu.view.actor

class Coach (val name: String){
    private val denialMenus = mutableListOf<String>()
    private val receivedRecommendations = mutableListOf<String>()

    fun receiveRecommendation(foodName: String) {
        receivedRecommendations.add(foodName)
    }

    fun addDenialMenu(foodName: String) {
        denialMenus.add(foodName)
    }

    fun toListRecommendations(): List<String> {
        return receivedRecommendations
    }

    fun toListDenialMenus(): List<String> {
        return denialMenus
    }

    fun toStringSummary(): String {
        val builder = StringBuilder()
        builder.append("[ $name |")
        for(menu in receivedRecommendations) {
            builder.append(" $menu |")
        }
        builder.setLength(builder.length - 1)
        builder.append("]")
        return builder.toString()
    }
}
