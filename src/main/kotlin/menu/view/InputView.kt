package menu.view

import camp.nextstep.edu.missionutils.Console.*
import menu.domain.validator.InputValidator

class InputView(private val inputValidator: InputValidator) {

    fun readCoachNames(): List<String> {
        return try {
            inputValidator.getValidateCoachNames(readLine())
        } catch (error: IllegalArgumentException) {
            println(error.message)
            readCoachNames()
        }
    }

    fun readMenuBan(coachName: String): List<String> {
        return try {
            inputValidator.getCoachMenuBan(userInput = readLine(), coachName = coachName)
        } catch (error: IllegalArgumentException) {
            println(error.message)
            readMenuBan(coachName = coachName)
        }
    }
}
