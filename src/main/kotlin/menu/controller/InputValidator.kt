package menu.controller

import menu.domain.Validator
import menu.model.Coach
import menu.model.Food
import menu.view.InputView

class InputValidator {
    private val inputView: InputView = InputView()
    private val validator: Validator = Validator()

    fun getValidatedCoach(): Coach {
        try {
            val input = inputView.readCoach().split(',')

            validator.checkValidateCoach(input)
            return Coach(input)

        } catch (e: IllegalArgumentException) {
            throw e
        }
    }

    fun getValidatedFood(): Food {
        try {
            val input = inputView.readFood().split(',')

            validator.checkValidateFood(input)
            return Food(input)

        } catch (e: IllegalArgumentException) {
            throw e
        }
    }
}