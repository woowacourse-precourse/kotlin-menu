package menu.domain

import camp.nextstep.edu.missionutils.Randoms
import menu.util.FRIDAY_NUMBER
import menu.util.MONDAY_NUMBER

class GenerateRandomNumbers : GenerateNumber {
    override fun generate(): Int {
        return Randoms.pickNumberInRange(MONDAY_NUMBER, FRIDAY_NUMBER)
    }


}