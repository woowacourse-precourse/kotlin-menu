package menu

class MenuController {
    private val outputView = OutputView()
    private val inputView = InputView()
    private var coachNames: List<String> = listOf()
    private var nameMenu: MutableList<Pair<String, List<String>>> = mutableListOf()

    fun main() {
        startMessage()
        coachNames()
        cantEatMenu()
        printResult()
    }


    private fun startMessage() {
        outputView.printStartMessage()
    }

    fun coachNames() {
        while (true) {
            if (inputCoachNames()) break
        }
    }

    private fun inputCoachNames(): Boolean {
        try {
            outputView.printInputCoachNames()
            val userinput = inputView.inputCoachName()
            if (InputValidator(userinput).checkCoachNamesException()) {
                coachNames = userinput.replace(" ", "").split(',')
            }
        } catch (e: Exception) {
            outputView.printError(e.message.toString())
            return false
        }
        return true
    }

    private fun cantEatMenu() {
        for (name in coachNames) {
            while (true) {
                if (inputCantEatMenu(name)) break
            }
        }
    }

    private fun inputCantEatMenu(name: String): Boolean {
        try {
            outputView.printCantEatMenu(name)
            val userInput = inputView.inputCantEatMenu()
            if (InputValidator(userInput).checkMenuException()) {
                nameMenu.add(Pair(name, userInput.replace(" ", "").split(',')))
            }
        } catch (e: Exception) {
            outputView.printError(e.message.toString())
            return false
        }
        return true
    }

    private fun printResult() {
        val recommandMenuResult = RecommandMenuController(nameMenu)
        recommandMenuResult.main()
        val cateResult = recommandMenuResult.getDayCategory()
        outputView.printCategoryResult(cateResult)
        val result = recommandMenuResult.getFinalResult()
        outputView.printFinalResult(Pair(coachNames, result))
    }

}