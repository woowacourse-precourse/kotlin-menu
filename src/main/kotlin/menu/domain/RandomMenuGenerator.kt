package menu.domain

import camp.nextstep.edu.missionutils.Randoms

class RandomMenuGenerator: MenuGenerator {
    override fun generate(menus: List<String>): String {
        return Randoms.shuffle(menus)[0]
    }
}