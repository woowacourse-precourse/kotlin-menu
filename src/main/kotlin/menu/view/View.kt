package menu.view

import menu.model.Category
import menu.model.Coach
import menu.model.CoachGroup

object View {
    fun printStartComment() {
        UI.printStartMenuRecommend()
        println()
    }

    fun requestInputCoachName(): String {
        UI.printRequestInputCoachNames()
        return InputView.inputCoachNames()
    }

    fun requestInputCantEat(coachName : String) : List<String> {
        println()
        print(coachName)
        UI.printRequestInputCantEatMenu()
        return InputView.inputCantEat().split(",")
    }

    fun printResultRecommendedMenu(coachGroup: CoachGroup){
        println()
        UI.printResultMenuRecommend()
        UI.printResultMenuRecommendCategory()
        printRecommendedCategories()
        for (coach in coachGroup.getCoachGroup()){
            printRecommendedMenuForCoach(coach)
        }
        println()
        UI.printEndMenuRecommend()
    }

    private fun printRecommendedCategories(){
        val result = mutableListOf<String>()
        result.add("카테고리")
        result.addAll(Category.getRecommendCategories())
        println(result.joinToString(separator = " | ", prefix = "[ ", postfix = " ]"))
    }

    private fun printRecommendedMenuForCoach(coach : Coach){
        val result = mutableListOf<String>()
        result.add(coach.getName())
        result.addAll(coach.getRecommendMenus())
        println(result.joinToString(separator = " | ", prefix = "[ ", postfix = " ]"))
    }
}