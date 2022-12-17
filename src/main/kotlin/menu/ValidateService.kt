package menu

import java.lang.IllegalArgumentException

const val ERROR = "[ERROR]"

class ValidateService {
    fun validateCoachName(names: List<String>): List<String> {
        if(names.size < 2 || names.size > 5) throw IllegalArgumentException("$ERROR 코치는 최소 2명, 최대 5명까지 식사를 함께 한다.")
        for(name in names) {
            if(name.length < 2 || name.length > 4) throw IllegalArgumentException("$ERROR 코치의 이름은 최소 2글자, 최대 4글자이다.")
        }
        return names

    }

}
