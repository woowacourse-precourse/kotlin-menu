package menu.model

import camp.nextstep.edu.missionutils.Randoms

class RandomNumberGenerator : NumberGenerator {
    override fun generator() :Int {
        return Randoms.pickNumberInRange(0,4)
    }
}