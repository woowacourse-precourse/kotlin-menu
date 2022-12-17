package menu.model

class Coach(private val name:String) {

    private val recommendFoods = mutableListOf<String>()

    fun recommend(menu:String){
        recommendFoods.add(menu)
    }


}