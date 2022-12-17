package menu

class InputValidator(private val userInput: String) {
    enum class ErrorMessage(val sentence: String) {
        LENGTH_ERROR("[ERROR] 이름은 최소 2글자 이상 최대 4글자까지 입력할 수 있습니다."),
        NAME_SIZE_ERROR("[ERROR] 최소 2명, 최대 5명까지 입력할 수 있습니다."),
        MENU_SIZE_ERROR("[ERROR] 먹지 못하는 메뉴는 최대 2개 까지 입력할 수 있습니다."),
        OVERLAP_ERROR("[ERROR] 코치 이름은 중복될 수 없습니다.")
    }

    fun checkCoachNamesException(): Boolean {
        val names = userInput.replace(" ", "").split(',')
        if(names.size!=names.distinct().size){
            throw IllegalArgumentException(ErrorMessage.OVERLAP_ERROR.sentence)
        }
        if (names.size < 2 || names.size > 5) {
            throw IllegalArgumentException(ErrorMessage.NAME_SIZE_ERROR.sentence)
        }
        for (name in names) {
            if (name.length < 2 || name.length > 4) {
                throw IllegalArgumentException(ErrorMessage.LENGTH_ERROR.sentence)
            }
        }
        return true
    }

    fun checkMenuException(): Boolean {
        val menus = userInput.split(',')
        if(menus.size!=menus.distinct().size){
            throw IllegalArgumentException(ErrorMessage.OVERLAP_ERROR.sentence)
        }
        if (menus.size > 2) {
            throw IllegalArgumentException(ErrorMessage.MENU_SIZE_ERROR.sentence)
        }
        return true
    }

}