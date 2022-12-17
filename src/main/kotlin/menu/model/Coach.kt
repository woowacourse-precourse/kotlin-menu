package menu.model

class Coach(private val name:String) {

    private val recommendFoods = mutableListOf<String>()
    private var excludeMenus  = listOf<String>()

    fun getRecommendFoods() = recommendFoods

    fun getName() = name

    fun getExcludeMenus() = excludeMenus
    fun recommend(menu:String){
        recommendFoods.add(menu)
    }

    fun addExcludeMenus(menus:List<String>){
        excludeMenus = menus
    }


}