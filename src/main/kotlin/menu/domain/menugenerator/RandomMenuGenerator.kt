package menu.domain.menugenerator

import camp.nextstep.edu.missionutils.Randoms.*
import menu.domain.AvaliableMenu

class RandomMenuGenerator : MenuGenerator {
    override fun generate(category: AvaliableMenu): String =
        shuffle(category.menus)[0]
}
