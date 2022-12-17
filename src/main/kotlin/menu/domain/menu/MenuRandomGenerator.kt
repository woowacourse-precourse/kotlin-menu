package menu.domain.menu

import camp.nextstep.edu.missionutils.Randoms

class MenuRandomGenerator : MenuGenerator {
    override fun generate(menus: List<String>): String {
        return Randoms.shuffle(menus)[0]
    }
}