package menu

class Coach(private val name: String) {
    private var bias = listOf<String>()

    fun getName() = this.name

    fun saveBias(input: List<String>) {
        bias = input
    }
}