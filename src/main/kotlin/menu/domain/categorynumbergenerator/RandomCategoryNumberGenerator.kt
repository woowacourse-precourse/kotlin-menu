package menu.domain.categorynumbergenerator

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange
import menu.domain.AvaliableMenu

class RandomCategoryNumberGenerator : CategoryNumberGenerator {

    override fun generate(): Int = pickNumberInRange(MENU_START_PICKER_NUMBER, AvaliableMenu.values().size)

    companion object {
        const val MENU_START_PICKER_NUMBER = 1
    }
}
