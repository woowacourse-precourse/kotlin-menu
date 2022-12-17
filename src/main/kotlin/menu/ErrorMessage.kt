package menu

class ErrorMessage {
    private val Error = "[ERROR]"
    val onlyLetter = Error+" 글자만 입력해야 합니다."
    val wrongLength = Error+" 코치 이름길이는 2~4입니다."
    val wrongNumber = Error+" 코치는 최소 2명 이상 입력해야 합니다."
    val wrongMenuNum = Error+" 못먹는 메뉴는 최대 2개입니다."
}