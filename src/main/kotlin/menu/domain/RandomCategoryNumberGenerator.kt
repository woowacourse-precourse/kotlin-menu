package menu.domain

import camp.nextstep.edu.missionutils.Randoms

class RandomCategoryNumberGenerator : CategoryNumberGenerator {
    override fun generate(): Int {
        return Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE)
    }

    companion object {
        const val MAX_RANGE = 5
        const val MIN_RANGE = 1
    }
}