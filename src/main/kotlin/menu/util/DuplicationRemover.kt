package menu.util

object DuplicationRemover {
    fun removeDuplication(data: List<String>): List<String> = data.toSet().toList()
}