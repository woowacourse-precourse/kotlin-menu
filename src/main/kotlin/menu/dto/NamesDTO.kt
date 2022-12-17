package menu.dto

class NamesDTO(private val names: List<String>) {
    init {
        isLengthValid()
    }

    private fun isLengthValid() {
        names.map { name -> require(name.length in MIN_LENGTH..MAX_LENGTH) { LENGTH_ERROR_MESSAGE } }
    }

    companion object {
        const val LENGTH_ERROR_MESSAGE = "코치 이름은 최소 2글자, 최대 4글자여야 합니다."
        const val MAX_LENGTH = 4
        const val MIN_LENGTH = 2
    }
}