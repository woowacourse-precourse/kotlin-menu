package menu

class InputValidator {
    fun validateCoachNames(coachName: String): List<String> {
        val names = coachName.split(',')
        if (names.size !in 2..5) {
            throw IllegalArgumentException("[ERROR] 코치는 최소 2명, 최대 5명입니다.")
        }
        names.forEach {
            if (it.length !in 2..4) {
                throw IllegalArgumentException("[ERROR] 이름의 길이는 최소 2글자 최대 4글지입니다. (잘못된 입력: ${it})")
            }
        }
        return names
    }

    fun validateDislikeMenus() {

    }
}