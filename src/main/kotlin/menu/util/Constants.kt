package menu.util

class Constants {

    companion object {

        const val COACH_NAME_MIN_SIZE = 2
        const val COACH_NAME_MAX_SIZE = 4
        const val COACHES_MIN_SIZE = 2
        const val COACHES_MAX_SIZE = 5
        const val FOODS_MIN_SIZE = 0
        const val FOODS_MAX_SIZE = 2
        const val LIMIT_DAYS = 5
        const val LIMIT_CATEGORY_DISTINCT = 2


        //Validator
        const val ERROR_MESSAGE = "[ERROR] "
        const val NAME_VALUE_ERROR = ERROR_MESSAGE + "한글만 입력되어야 합니다."
        const val COACH_NAME_SIZE_ERROR = ERROR_MESSAGE + "코치의 이름은 최소 2글자 최대 4글자 이어야합니다."
        const val COACHES_SIZE_ERROR = ERROR_MESSAGE + "코치의 수는 최소 2명 최대 5명이어야 합니다."
        const val FOODS_SIZE_ERROR = ERROR_MESSAGE + "음식의 수는 최대 2개까지여야 합니다."

        //OutputView
        const val START_GAME_MESSAGE = "점심 메뉴 추천을 시작합니다."
        const val INPUT_COACHES_NAME_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)"
        const val INPUT_HATE_FOOD_MESSAGE = "%s(이)가 못 먹는 메뉴를 입력해 주세요."

    }
}