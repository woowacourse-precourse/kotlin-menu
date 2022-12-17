package menu

import java.lang.Error

class UIController {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val validateService = ValidateService()

    fun start() {
        outputView.printStart()
    }

    fun getCoachName(): List<String> {
        //try catch
        var coaches: List<String> = listOf()
        while (coaches.isEmpty()) {
            try {
                coaches = validateService.validateCoachName(inputView.getCoachName())
            } catch (e: Error) {
                println(e.message)
            }
        }
        return coaches
    }


}