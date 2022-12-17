package menu

private const val ERROR_COACH_COUNT_MSG="[ERROR] 코치는 최소 2명 최대 5명입니다."
private const val ERROR_COACH_NAME_MSG="[ERROR] 코치의 이름은 최소 2글자 최대 4글자입니다."
private const val ERROR_HATE_FOOD_COUNT_MSG="[ERROR] 못먹는 음식은 최대 2개입니다."
private const val SPLIT_UNIT=","
private const val MINIMUM_COACHS=2
private const val MAXIMUM_COACHS=5
private const val MINIMUM_NAME=2
private const val MAXIMUM_NAME=4
private const val MINIMUM_HATE_FOOD=2


class ValidChecker {


    fun checkCoachNames(names: String): List<String> {
        val coachNames = names.replace(" ","").split(SPLIT_UNIT) //공백 포함 입력 시 공백 제거
        if (coachNames.size < MINIMUM_COACHS || coachNames.size > MAXIMUM_COACHS) {
            throw IllegalArgumentException(ERROR_COACH_COUNT_MSG)
        }
        for (name in coachNames) {
            if (name.length < MINIMUM_NAME || name.length > MAXIMUM_NAME) {
                throw IllegalArgumentException(ERROR_COACH_NAME_MSG)
            }
        }
        return coachNames
    }

    fun checkHateFood(foodName: String): List<String> {
        val hateFood = foodName.replace(", ",",").replace(" ,",",").split(SPLIT_UNIT) //공백 포함 입력 시 공백 제거
        if (hateFood.size > MINIMUM_HATE_FOOD) {
            throw IllegalArgumentException(ERROR_HATE_FOOD_COUNT_MSG)
        }
        return hateFood
    }

}