package menu.domain.menugenerator

import menu.domain.AvaliableMenu

class StubMenuGenerator(private val testMenus: MutableList<String>) : MenuGenerator {
    override fun generate(category: AvaliableMenu): String = testMenus.removeAt(0)
}
