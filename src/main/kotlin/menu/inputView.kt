package menu

import camp.nextstep.edu.missionutils.Console.readLine

class inputView {
    val error = ErrorMessage()
    val CT = categories()

    // 숫자인지 물어보는 함수
    fun isNumeric(s: String): Boolean {
        return s.chars().allMatch { Character.isDigit(it) }
    }

    fun inputCoachName(): List<String> {
        try {
            val coachName = readLine()
            var coachCollect = coachName.split(',')
            for (i in 0 until coachCollect.size) {
                if (coachCollect.size == 1) throw IllegalArgumentException(error.wrongNumber)
                if (isNumeric(coachCollect[i])) throw IllegalArgumentException(error.onlyLetter)
                if (coachCollect[i].length > 4 || coachCollect[i].length < 2) throw IllegalArgumentException(
                    error.wrongLength
                )
            }
            return coachCollect
        } catch (e: IllegalArgumentException) {
            println(e.message)
            return inputCoachName()
        }
    }

    fun inputNotEating(): List<String> {
        try {
            val notEating = readLine()
            if (notEating == "") return listOf(notEating)
            var notEatingCollect = notEating.split(',')
            for (i in 0 until notEatingCollect.size) {
                if (notEatingCollect.size > 2) throw IllegalArgumentException(error.wrongMenuNum)
                isitExist(notEatingCollect)
            }
            return notEatingCollect
        } catch (e: IllegalArgumentException) {
            println(e.message)
            return inputNotEating()
        }
    }

    fun isitExist(notEatingCollect: List<String>) {
        for (i in 0 until notEatingCollect.size) {
            var num = 0
            if (!CT.Japanese.contains(notEatingCollect[i])) num+=1
            if (!CT.Korean.contains(notEatingCollect[i])) num+=1
            if (!CT.Chinese.contains(notEatingCollect[i])) num+=1
            if (!CT.Asian.contains(notEatingCollect[i])) num+=1
            if (!CT.Western.contains(notEatingCollect[i])) num+=1
            if (num==5) throw IllegalArgumentException(error.wrongMenu)
        }
    }

}