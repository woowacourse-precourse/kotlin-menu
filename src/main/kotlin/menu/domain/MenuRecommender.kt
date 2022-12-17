package menu.domain

import menu.util.Util

class MenuRecommender {
    val coachNameList = mutableListOf<String>()
    val hateFoodList = mutableListOf<List<String>>()

    fun setCoachNameList(input : String) {
        val inputSplit = Util().convertCommaStringToList(input)
        coachNameList.addAll(inputSplit)
    }

    fun setHateFoodList(input : String) {
        val inputSplit = Util().convertCommaStringToList(input)
        hateFoodList.add(inputSplit)
    }
}