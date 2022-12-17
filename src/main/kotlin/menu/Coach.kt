package menu

class Coach(
    val name: String,
) {

    private var hatingMenus = arrayListOf<Menu>()

    fun setHatingMenus(inputHatingMenus: List<Menu>) {
        inputHatingMenus.forEach { eachHatingMenu ->
            if (eachHatingMenu != Menu("")) {
                hatingMenus.add(eachHatingMenu)
            }
        }
    }

    fun hatingMenus() = hatingMenus
}