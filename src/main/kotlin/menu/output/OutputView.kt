package menu.output

import menu.data.InputType
import menu.message.PrintMessage

class OutputView {
    fun startRecommendMenu() {
        println(PrintMessage.startRecommend)
    }

    fun inputCoachName() {
        println(PrintMessage.inputCoachName)
    }

    fun inputNotEatMenu(coachName: String) {
        println("$coachName" + PrintMessage.inputNotEatMenu)
    }

    fun resultRecommendMenu() {
        println(PrintMessage.resultToRecommendMenu)
    }

    fun outputHeaderDay() {
        println(PrintMessage.resultHeaderOfDay)
    }

    fun outputSuccessRecommend() {
        println(PrintMessage.successRecommend)
    }

    fun outputCategory(categories: List<String>) {
        print("[ 카테고리 |")

        for(index in categories.indices) {
            print(" ${categories[index]} ")
            compareLastIndex(categories, index)
        }
    }

    fun outputRecommendMenu(coaches: List<String>, recommendMenus: List<List<String>>) {
        for(coachIndex in coaches.indices) {
            print("[ ${coaches[coachIndex]} |")

            for(day in recommendMenus.indices) {
                print(" ${recommendMenus[day][coachIndex]} ")
                compareLastIndex(recommendMenus, day)
            }
        }
    }

    fun outputException(inputType: InputType, exceptionMessage: String, coachName: String = "") {
        println(exceptionMessage)

        when(inputType) {
            InputType.COACH_NAME -> inputCoachName()
            InputType.MENU -> inputNotEatMenu(coachName)
        }
    }

    private fun compareLastIndex(list: List<Any>, index: Int) {
        if(list.size - 1 == index) {
            println("]")
            return
        }
        print("|")
    }

}