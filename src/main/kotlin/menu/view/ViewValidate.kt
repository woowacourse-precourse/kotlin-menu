package menu.view

class ViewValidate {

    fun coachNamesForm(input: String) {
        val names = input.split(",")
        names.forEach { name ->
            require(COACH_NAMES_FORM.toRegex().matches(name)) { println("[ERROR] 코치의 이름은 2글자 부터 4명글자 까지 입력해야 합니다.") }
        }
        require((2..5).contains(names.size)) { println("[ERROR] 코치는 최소 2명 부터 최대 5명 까지만 입력해주세요.") }
    }

    companion object {
        private const val COACH_NAMES_FORM = "^.{2,4}\$"
    }
}