package menu.exception

import menu.utils.*

class Validator {
    fun checkCoachNames(input: String): List<String> {
        val inputSplit = input.split(",")
        val names = mutableListOf<String>()
        inputSplit.forEach { names.add(it.replace(" ", "")) }
        checkCoachCount(names)
        checkNameLength(names)
        return names
    }

    private fun checkCoachCount(names: List<String>) {
        if ((names.size < MINIMUM_COACH_COUNT) or (names.size > MAXIMUM_COACH_COUNT)) throw IllegalArgumentException(
            ERROR_NAMES_SIZE
        )
    }

    private fun checkNameLength(names: List<String>) {
        names.forEach {
            if ((it.length < MINIMUM_NAME_LENGTH) or (it.length > MAXIMUM_NAME_LENGTH)) throw IllegalArgumentException(
                ERROR_NAMES_LENGTH
            )
        }
    }

    fun checkCantEatMenu(input: String): List<String> {
        val inputSplit = input.split(",")
        val menus = mutableListOf<String>()
        inputSplit.forEach {
            menus.add(it.replace(" ", ""))
        }
        if (menus.size > 2) throw IllegalArgumentException(ERROR_CANT_EAT_MENUS_SIZE)
        return menus
    }
}