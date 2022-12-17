package menu.domain

class Validator {

    fun validate(input: String) {
        require(input.toIntOrNull() != null) {
            "[ERROR]"
        }
    }

}