package menu

import java.util.*

class MenuRepository {
    private val menus: MutableList<String> = ArrayList()
    private var category = ""
    fun menus(): List<String> {
        return Collections.unmodifiableList(menus)
    }

    fun setCategory(name: String?) {
        if (name != null) {
            category = name
        }
    }

    fun getCategory(): String {
        return category
    }

    fun addLine(menu: String) {
        menus.add(menu)
    }


}