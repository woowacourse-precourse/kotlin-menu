package menu.domain.model

import menu.util.LEFT_BRACKET
import menu.util.RIGHT_BRACKET
import menu.util.SEPERATOR
import java.lang.StringBuilder

class Coach(
    private val name: String,
    private val inedible: MutableList<Food> = mutableListOf()
) {

    private val diet = mutableListOf<Food>()

    init {
        require(name.length in 2..4) {
            "코치의 이름은 2글자 이상 4글자 이하로 작성해 주세요."
        }
    }

    override fun toString(): String {
        val stringBuilder = StringBuilder()
        stringBuilder.append(LEFT_BRACKET)
        stringBuilder.append(name)
        stringBuilder.append(SEPERATOR)
        for (i in diet.indices) {
            stringBuilder.append(diet[i].getName())
            if (i == diet.size - 1) continue
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
            "해당 음식은 이미 입력됬습니다."
        }
        require(inedible.size <= 1) {
            "금식은 최대 2개까지 입니다."
        }
    }

}