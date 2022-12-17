package menu

import menu.Service.Service
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
    Service().startService(cantEatMenu, category)
    OutputView().printRecommandComplete()
}


