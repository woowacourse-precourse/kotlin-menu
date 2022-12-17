package menu.domain

import camp.nextstep.edu.missionutils.Randoms

class CategoryRandomNumberGenerator : CategoryNumberGenerator {
    override fun generate(): Int {
        return Randoms.pickNumberInRange(RANDOM_CATEGORY_MIN_NUMBER, RANDOM_CATEGORY_MAX_NUMBER)
    }

    companion object {
        const val RANDOM_CATEGORY_MIN_NUMBER = 1
        const val RANDOM_CATEGORY_MAX_NUMBER = 5
    }
}
