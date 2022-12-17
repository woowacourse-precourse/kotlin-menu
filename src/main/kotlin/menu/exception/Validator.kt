package menu.exception

import menu.constants.ERROR_NAMES_LENGTH
import menu.constants.ERROR_NAMES_SIZE

class Validator {
    fun checkCoachNames(input: String): List<String> {
        val inputSplit = input.split(",")
        val names = mutableListOf<String>()
        inputSplit.forEach { names.add(it.replace(" ", "")) }
        if ((names.size < 2) or (names.size > 5)) throw IllegalArgumentException(ERROR_NAMES_SIZE)
        names.forEach {
            if ((it.length < 2) or (it.length > 4)) throw IllegalArgumentException(ERROR_NAMES_LENGTH)
        }
        return names
    }
}