package menu

class Coach(
    val name: String,
) {

    private var hatingMenus = arrayListOf<String>()
    var thisWeekMenus = arrayListOf<String>()

    fun setHatingMenus(inputHatingMenus: List<String>) {
        inputHatingMenus.forEach { eachHatingMenu ->
            if (eachHatingMenu != "") {
                hatingMenus.add(eachHatingMenu)
            }
        }
    }

    /**
     * 이미 선택한 메뉴이거나 내가 싫어하는 메뉴에 포함된다면 해당 메뉴를 선택할 수 없다.
     */
    fun selectMyMenu(menu: String): Boolean {
        if (isMyHatingMenu(menu) || thisWeekMenus.contains(menu)) {
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