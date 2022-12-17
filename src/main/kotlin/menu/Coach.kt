package menu

class Coach(
    val name: String,
) {

    //TODO : private
    var hatingMenus = arrayListOf<String>()
    var thisWeekMenus = arrayListOf<String>()

    fun setHatingMenus(inputHatingMenus: List<String>) {
        inputHatingMenus.forEach { eachHatingMenu ->
            if (eachHatingMenu != "") {
                hatingMenus.add(eachHatingMenu)
            }
        }
    }

    fun selectMyMenu(menu: String): Boolean {
        if (isMyHatingMenu(menu)) {
            return false
        }
        thisWeekMenus.add(menu)
        return true
    }

    private fun isMyHatingMenu(menu: String): Boolean {
        if (hatingMenus.contains(menu)) {
            return true
        }
        return false
    }
}