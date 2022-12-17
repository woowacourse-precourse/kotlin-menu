package menu.controller

import menu.domain.Validator
import menu.model.Coach
import menu.view.InputView

class InputValidator {
    private val inputView: InputView = InputView()
    private val validator: Validator = Validator()

    fun getValidatedCoach(): Coach {
        try {
            val input = inputView.readCoach()

            validator.checkValidateCoach(input)
            return Coach(input)

        } catch (e: IllegalArgumentException) {
            throw e
        }
    }
}