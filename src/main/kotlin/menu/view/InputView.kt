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

    fun readCoachWithMenuBan(coachName: String): List<String> {
        return try {
            inputValidator.getCoachWithMenuBan(userInput = readLine(), coachName = coachName)
        } catch (error: IllegalArgumentException) {
            println(error.message)
            readCoachWithMenuBan(coachName = coachName)
        }
    }
}
