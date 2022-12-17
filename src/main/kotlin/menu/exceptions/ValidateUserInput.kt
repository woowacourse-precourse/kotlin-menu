package menu.exceptions

object ValidateUserInput {
    private const val PREFIX = "[ERROR] "

    fun validateInputDisallowBlank(input: String) {
        require(input.isNotBlank()) { PREFIX + "빈 값이 들어있습니다." }
    }
}