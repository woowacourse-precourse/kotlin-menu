package menu

class MenuController(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView()
) {
    private lateinit var coachesName: List<String>
    private val coachesCantEat = mutableListOf<List<String>>()

    fun standByPhase() {
        outputView.printRecommendMenuStart()
        coachesName = inputView.readCoachesName()
        outputView.printBlank()
    }

    fun mainPhase() {
        for (coachName in coachesName) {
            outputView.printCoachCantEatMenu(coachName)
            coachesCantEat.add(inputView.readCoachCantEatMenu())
            outputView.printBlank()
        }
    }

    fun endPhase() {
        val menuCategoryGenerator = MenuCategoryGenerator(coachesName, coachesCantEat)
        outputView.printResult(
            coachesName,
            menuCategoryGenerator.menuCategory,
            menuCategoryGenerator.getMenuFromCategory()
        )
    }
}
