package menu.domain

import menu.util.Util

class MenuRecommender {
    val coachNameList = mutableListOf<String>()

    fun setCoachNameList(input : String) {
        val inputSplit = Util().convertCommaStringToList(input)
        coachNameList.addAll(inputSplit)
    }
}