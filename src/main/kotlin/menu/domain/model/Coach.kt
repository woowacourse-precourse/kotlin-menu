package menu.domain.model

import menu.util.ERROR.COACH_MAX_INEDIBLE_LENGTH
import menu.util.ERROR.COACH_NAME_LENGTH
import menu.util.ERROR.DUPLICATED_FOOD
import menu.util.LEFT_BRACKET
import menu.util.ONE
import menu.util.RIGHT_BRACKET
import menu.util.SEPERATOR
import java.lang.StringBuilder

class Coach(
    private val name: String,
    private val inedible: MutableList<Food> = mutableListOf()
) {

    private val diet = mutableListOf<Food>()

    init {
        require(name.length in MIN_COACH_NAME_LENGTH..MAX_COACH_NAME_LENGTH) {
            COACH_NAME_LENGTH
        }
    }

    override fun toString(): String {
        val stringBuilder = StringBuilder()
        stringBuilder.append(LEFT_BRACKET)
        stringBuilder.append(name)
        stringBuilder.append(SEPERATOR)
        for (i in diet.indices) {
            stringBuilder.append(diet[i].getName())
            if (i == diet.size - ONE) continue
            stringBuilder.append(SEPERATOR)
        }
        stringBuilder.append(RIGHT_BRACKET)
        return stringBuilder.toString()
    }

    fun getName() = name

    fun equalName(checkingName: String): Boolean {
        return name == checkingName
    }

    fun addInedible(food: Food) {
        indedibleValidateCheck(food)
        inedible.add(food)
    }

    fun addDiet(food: Food) {
        diet.add(food)
    }

    fun checkFood(food: Food): Boolean {
        if (diet.contains(food) || inedible.contains(food)) {
            return true
        }
        return false
    }

    private fun indedibleValidateCheck(food: Food) {
        require(!inedible.contains(food)) {
            DUPLICATED_FOOD
        }
        require(inedible.size <= ONE) {
            COACH_MAX_INEDIBLE_LENGTH
        }
    }

    companion object {
        const val MIN_COACH_NAME_LENGTH = 2
        const val MAX_COACH_NAME_LENGTH = 4
    }
}