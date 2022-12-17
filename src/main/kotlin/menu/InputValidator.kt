package menu

import java.lang.IllegalArgumentException

object InputValidator {
    fun coachNames(input: String) {
        val coaches = input.split(",").map { it.trim() }
        if (coaches.size < MIN_COACH || coaches.size > MAX_COACH) throwError(Error.ERROR_COACH_PERSON_NUM_WRONG)
        coaches.forEach {
            if (it.length < MIN_NAME_LENGTH || it.length > MAX_NAME_LENGTH) throwError(Error.ERROR_COACH_NAME_WRONG)
        }
        if (coaches.size != coaches.distinct().size) throwError(Error.ERROR_DUPLICATE_COACH_NAME)
    }

    fun hateMenu(input: String, allMenus: List<List<String>>) {
        if (input.trim().isEmpty()) return // 빈 것은 괜찮음. 못 먹는 음식이 없다는 의미.
        val hateMenus = input.split(",").map { it.trim() }
        if (hateMenus.size > MAX_HATE_FOOD) throwError(Error.ERROR_HATE_MENU_MAX_TWO)
        if (hateMenus.size != hateMenus.distinct().size) throwError(Error.ERROR_HATE_MENU_DUPLICATE)
        val allMenuOne = mutableListOf<String>()
        for (i in SuggestionMenu.LOW_CATEGORY..SuggestionMenu.HIGH_CATEGORY) {
            allMenus[i].forEach { allMenuOne.add(it.trim()) }
        }
        hateMenus.forEach { if (it !in allMenuOne) throwError(Error.ERROR_NOT_EXIST_MENU) }
    }

    private fun throwError(error: Error) {
        throw IllegalArgumentException(error.message)
    }

    private const val MAX_COACH = 5
    private const val MIN_COACH = 2
    private const val MIN_NAME_LENGTH = 2
    private const val MAX_NAME_LENGTH = 4
    private const val MAX_HATE_FOOD = 2
}