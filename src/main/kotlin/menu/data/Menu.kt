package menu.data

class Menu(private val name: String) {
    override fun equals(other: Any?) = (other is Menu) && (name == other.name)
    override fun toString(): String = name
}