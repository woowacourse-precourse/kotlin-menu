package menu.domain

import menu.values.*

class Validator {

    fun validateRecommendCoaches(input: String) {
        val coaches = input.split(",")

        require(coaches.size in MIN_COACHES_NUMBER..MAX_COACHES_NUMBER) {
            ERROR_MESSAGE + RECOMMEND_COACHES_CONDITION_MESSAGE
        }

        repeat(coaches.size) { index ->
            require(coaches[index].length in MIN_COACH_NAME_LENGTH..MAX_COACH_NAME_LENGTH) {
                ERROR_MESSAGE + RECOMMEND_COACH_NAME_CONDITION_MESSAGE
            }
        }
    }

    fun validateCoachCantEatMenus(input: String) {
        val menus = input.split(",")

        require(menus.size in MIN_COACH_CANT_EAT_MENU_NUMBER..MAX_COACH_CANT_EAT_MENU_NUMBER) {
            ERROR_MESSAGE + RECOMMEND_CANT_EAT_MENUS_CONDITION_MESSAGE
        }

        // todo 아무것도 없을 때 공백인지 확인
    }

}