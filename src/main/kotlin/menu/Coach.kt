package menu

class Coach(
    val name: String,
) {

    private var hatingMenus = arrayListOf<String>()

    fun setHatingMenus(inputHatingMenus: List<String>) {
        inputHatingMenus.forEach { eachHatingMenu ->
            if (eachHatingMenu != "") {
                hatingMenus.add(eachHatingMenu)
            }
        }
    }

    fun hatingMenus() = hatingMenus
}