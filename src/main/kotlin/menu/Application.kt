package menu

import menu.service.Service
import menu.view.InputView
import menu.view.OutputView

fun main() {
    OutputView().printStartRecommand()
    var coachName = InputView().inputName()
    var cantEatMenu = mutableMapOf<String, List<String>>()
    coachName.forEachIndexed() { _, it ->
        OutputView().printCantEat(it)
        cantEatMenu[it] = InputView().inputMenu()
    }
    val category = Service().createRandomCategory()
    OutputView().printRecommandResult(category)
    for(i in coachName.indices) {
        OutputView().printCoachMenu(Service().startService(cantEatMenu, category,i))
    }
    OutputView().printRecommandComplete()
}


