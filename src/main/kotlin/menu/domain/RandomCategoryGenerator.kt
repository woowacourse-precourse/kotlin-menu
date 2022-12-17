package menu.domain

import camp.nextstep.edu.missionutils.Randoms

class RandomCategoryGenerator : NumberGenerator {
    override fun generate(): Int {
        return Randoms.pickNumberInRange(1, 5)
    }
}