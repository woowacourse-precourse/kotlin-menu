package menu

import java.lang.IllegalArgumentException

const val ERROR = "[ERROR]"

class ValidateService {
    fun validateCoachName(names: List<String>): List<String> {
        if(names.size < 2) throw IllegalArgumentException("$ERROR 코치는 최소 2명 이상 입력해야 합니다.")
        if(names.size > 5)  throw IllegalArgumentException("$ERROR 코치는 최대 5명 이하로 입력해야 합니다.")
        for(name in names) {
            if(name.length < 2 || name.length > 4) throw IllegalArgumentException("$ERROR 코치의 이름은 최소 2글자, 최대 4글자이다.")
        }
        return names

    }

    fun validateHateMenu(menus: List<String>): List<String> {
        if(menus.size > 2) throw IllegalArgumentException("$ERROR 각 코치는 최소 0개, 최대 2개의 못 먹는 메뉴가 있다. (, 로 구분해서 입력한다.)")
        return menus
    }
}
