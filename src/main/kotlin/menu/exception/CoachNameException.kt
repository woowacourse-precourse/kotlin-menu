package menu.exception

import menu.message.ExceptionMessage

class CoachNameException(coaches: String) {
    // TODO: 코치 이름 입력 시 발생 되는 예외 처리

    init {
        isNotAvailableName(coaches)
        isNotMoreThanTwo(coaches)
        isMoreThanSix(coaches)
    }

    private fun isNotMoreThanTwo(coaches: String) {
        val coach = coaches.split(',')

        if(coach.size < 2)
            throw IllegalArgumentException(ExceptionMessage.isNotMoreThanTwo)
    }

    private fun isMoreThanSix(coaches: String) {
        val coach = coaches.split(',')

        if(coach.size > 5)
            throw IllegalArgumentException(ExceptionMessage.isMoreThanSix)
    }

    private fun isNotAvailableName(coaches: String) {
        val coach = coaches.split(',')

        coach.forEach {
            if(it.length < 2 || it.length > 4) {
                throw IllegalArgumentException(ExceptionMessage.isNotAvailableName)
            }
        }
    }
}