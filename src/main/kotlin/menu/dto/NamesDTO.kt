package menu.dto

class NamesDTO(private val names: List<String>) {
    init {
        isLengthValid()
        isSizeValid()
    }

    fun getNames(): List<String> {
        return names
    }

    private fun isLengthValid() {
        names.map { name -> require(name.length in MIN_LENGTH..MAX_LENGTH) { LENGTH_ERROR_MESSAGE } }
    }

    private fun isSizeValid() {
        require(names.size in MIN_SIZE..MAX_SIZE) { SIZE_ERROR_MESSAGE }
    }

    companion object {
        const val LENGTH_ERROR_MESSAGE = "코치 이름은 최소 2글자, 최대 4글자여야 합니다."
        const val MAX_LENGTH = 4
        const val MAX_SIZE = 5
        const val MIN_LENGTH = 2
        const val MIN_SIZE = 2
        const val SIZE_ERROR_MESSAGE = "코치는 최소 2명, 최대 5명이어야 합니다."
    }
}