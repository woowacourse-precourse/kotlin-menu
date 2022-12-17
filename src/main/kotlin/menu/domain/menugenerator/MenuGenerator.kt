package menu.domain.menugenerator

import menu.domain.AvaliableMenu

interface MenuGenerator {

    fun generate(category: AvaliableMenu): String
}
