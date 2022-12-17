package menu.dto

class MenusDTO(private val menus: List<String>) {
    init {
        isSizeValid()
    }

    fun getMenus(): List<String> {
        return menus
    }

    private fun isSizeValid() {
        require(menus.size in MIN_SIZE..MAX_SIZE) { SIZE_ERROR_MESSAGE }
    }

    companion object {
        const val MAX_SIZE = 2
        const val MIN_SIZE = 0
        const val SIZE_ERROR_MESSAGE = "각 코치는 최소 0개, 최대 2개의 못 먹는 메뉴가 있어야 합니다."
    }
}