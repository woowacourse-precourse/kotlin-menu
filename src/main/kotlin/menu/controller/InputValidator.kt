package menu.controller

import menu.domain.Validator
import menu.model.Coach
import menu.model.Food
import menu.view.InputView

class InputValidator {
    private val inputView: InputView = InputView()
    private val validator: Validator = Validator()

    fun getValidatedCoach(): Coach {
        val input = inputView.readCoach().split(',')
        println(input)
        validator.checkValidateCoach(input)
        return Coach(input)
    }

    fun getValidatedFood(): Food {
        val input = inputView.readFood().split(',')
        println(input)
        validator.checkValidateFood(input)
        return Food(input)
    }
}