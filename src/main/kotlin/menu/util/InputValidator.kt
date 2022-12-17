package menu.util

class InputValidator {
    fun validateCoachesNames(inputs: List<String>): List<String> {
        validateMultipleInputRange(inputs, INVALID_COACH_NAME_LENGTH_EXCEPTION_MESSAGE)
        validateInputSize(inputs, INVALID_COACHES_SIZE_EXCEPTION_MESSAGE)
        return inputs
    }

    fun validateInedibleFoods(inputs: List<String>): List<String> {
        validateInputSize(inputs, INVALID_INEDIBLE_FOODS_SIZE_EXCEPTION_MESSAGE, 0, 2)
        return inputs
    }

    private fun validateMultipleInputRange(
        inputs: List<String>,
        exceptionMessage: String,
        start: Int = 2,
        end: Int = 4,
    ): List<String> {
        inputs.forEach { input ->
            validateInputRange(input, exceptionMessage, start, end)
        }
        return inputs
    }

    private fun validateInputRange(input: String, exceptionMessage: String, start: Int, end: Int) {
        if (input.length !in start..end) {
            throw IllegalArgumentException(exceptionMessage)
        }
    }

    private fun validateInputSize(
        inputs: List<String>,
        exceptionMessage: String,
        minSize: Int = 2,
        maxSize: Int = 5,
    ): List<String> {
        if (inputs.size !in minSize..maxSize) {
            throw IllegalArgumentException(exceptionMessage)
        }
        return inputs
    }

    companion object {
        private const val ERROR_PREFIX = "[ERROR]"
        private const val INVALID_COACH_NAME_LENGTH_EXCEPTION_MESSAGE = "$ERROR_PREFIX 코치 이름은 최소 2글자 최대 4글자입니다."
        private const val INVALID_COACHES_SIZE_EXCEPTION_MESSAGE = "$ERROR_PREFIX 코치는 최소 2명 이상, 5명 이하로 입력해야 합니다."
        private const val INVALID_INEDIBLE_FOODS_SIZE_EXCEPTION_MESSAGE =
            "$ERROR_PREFIX 음식 이름은 최소 0개 이상, 2개 이하로 입력해야 합니다."
    }
}