package menu.message

class Message {
    companion object {
        const val isNotMoreThanTwo = "[ERROR] 입력된 코치가 두명 미만입니다."
        const val isMoreThanSix = "[ERROR] 입력된 코치가 여섯명 이상입니다."
        const val isNotAvailableName = "[ERROR] 입력된 코치 이름 중 최소 2글자, 최대 4글자를 지키지 못하는 값이 있습니다."

        const val notEatMenuIsMoreThanThree = "[ERROR] 입력된 못 먹는 메뉴의 갯수가 3개 이상입니다."
    }
}