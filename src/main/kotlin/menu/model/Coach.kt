package menu.model

import camp.nextstep.edu.missionutils.Randoms

class Coach(private val name: String,private val excludeMenus : List<String>) {

    private val recommendedMenus = mutableListOf<String>()

    fun getName() = name

    fun containExcludeMenus(menu: String): Boolean = excludeMenus.contains(menu)


    fun getRecommendedMenus() = recommendedMenus

    fun addRecommendedMenus(menu: String) {
//        if(!containExcludeMenus(menu) && !recommendedMenus.contains(menu)) {
            recommendedMenus.add(menu)
      //  }
    }

}