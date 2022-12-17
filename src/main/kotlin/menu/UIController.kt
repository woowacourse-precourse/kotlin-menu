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

    fun getCoachHateMenu(coaches: List<String>): Map<String, List<String>> {
        var coachHateMenu = mapOf<String, List<String>>()
        while(coachHateMenu.size != coaches.size) {
            try {
                coachHateMenu = getAllCoachHateMenu(coaches, coachHateMenu)
            } catch (e: Error) {
                println(e.message)
            }
        }

        return coachHateMenu
    }

    private fun getAllCoachHateMenu(coaches: List<String>, coachHateMenu: Map<String, List<String>>): Map<String, List<String>> {
        val newCoachHateMenu = mutableMapOf<String, List<String>>()
        newCoachHateMenu.putAll(coachHateMenu)
        for (i in coachHateMenu.size until coaches.size) {
            var coach = coaches[i]
            newCoachHateMenu[coach] = getOneCoachHateMenu(coach)
        }
        return newCoachHateMenu
    }

    private fun getOneCoachHateMenu(name: String): List<String> {
        var coachHateMenu = listOf<String>()
        try {
            while (coachHateMenu.isEmpty()) {
                coachHateMenu = validateService.validateHateMenu(inputView.getHateMenu(name))
            }
        } catch(e: Error) {
            println(e.message)
        }
        return coachHateMenu
    }


}