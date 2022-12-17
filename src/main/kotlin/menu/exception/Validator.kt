package menu.exception

import menu.constants.*

class Validator {
    fun checkCoachNames(input: String): List<String> {
        val inputSplit = input.split(",")
        val names = mutableListOf<String>()
        inputSplit.forEach { names.add(it.replace(" ", "")) }
        if ((names.size < MINIMUM_NAME_SIZE) or (names.size > MAXIMUM_NAME_SIZE)) throw IllegalArgumentException(
            ERROR_NAMES_SIZE
        )
        names.forEach {
            if ((it.length < MINIMUM_NAME_LENGTH) or (it.length > MAXIMUM_NAME_LENGTH)) throw IllegalArgumentException(
                ERROR_NAMES_LENGTH
            )
        }
        return names
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