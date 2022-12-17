package menu

class Exception {
    fun coachException(coachNames: List<String>){
        coachNameException(coachNames)
        coachNumberException(coachNames)
    }

    fun coachNameException(coachNames : List<String>){
        for (i in coachNames){
            if (i.length < 2 || i.length > 4){
                throw IllegalArgumentException("[ERROR] 코치 이름은 최소 2글자, 최대 4글자여야 합니다.")
            }
        }
    }

    fun coachNumberException(coachNames: List<String>){
        if (coachNames.size < 2){
            throw IllegalArgumentException("[ERROR] 코치는 최소 2명 이상 입력해야 합니다.")
        }
        if (coachNames.size > 5){
            throw IllegalArgumentException("[ERROR] 코치는 최대 5명 이하로 입력해야 합니다.")
        }
    }

    fun hateFoodException(hateFoods: List<String>){
        if (hateFoods.size >= 3){
            throw  IllegalArgumentException("[ERROR] 각 코치는 최소 0개, 최대 2개의 못 먹는 메뉴를 입력해야합니다.")
        }
    }
}