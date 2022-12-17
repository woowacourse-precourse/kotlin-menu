package menu.util

class InputValidator {
    fun validateMultipleInputRange(inputs: List<String>): List<String> {
        inputs.forEach { input ->
            validateInputRange(input)
        }
        return inputs
    }

    private fun validateInputRange(input: String, start: Int = 2, end: Int = 4) {
        if (input.length !in start..end) {
            throw IllegalArgumentException(INVALID_COACH_NAME_LENGTH_EXCEPTION_MESSAGE)
        }
    }

    companion object {
        private const val ERROR_PREFIX = "[ERROR]"
        private const val INVALID_COACH_NAME_LENGTH_EXCEPTION_MESSAGE = "$ERROR_PREFIX 코치 이름은 최소 2글자 최대 4글자입니다."
    }
}