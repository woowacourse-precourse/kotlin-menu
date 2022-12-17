package menu

class ValidChecker {

    fun checkCoachNames(names: String): List<String> {
        val coachNames = names.split(",")
        if (coachNames.size < 2 || coachNames.size > 5) {
            throw IllegalArgumentException("[ERROR] 코치는 최소 2명 최대 5명입니다.")
        }
        for (name in coachNames) {
            if (name.length < 2 || name.length > 4) {
                throw IllegalArgumentException("[ERROR] 코치의 이름은 최소 2글자 최대 4글자입니다.")
            }
        }
        return coachNames
    }

    fun checkHateFood(foodName: String): List<String> {
        val hateFood = foodName.split(",")
        if (hateFood.size > 2) {
            throw IllegalArgumentException("[ERROR] 못먹는 음식은 최대 2개입니다.")
        }
        return hateFood

    }
}