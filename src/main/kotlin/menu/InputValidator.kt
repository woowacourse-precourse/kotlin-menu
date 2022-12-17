package menu

class InputValidator {

    fun validateCoaches(coachesName: String){
        coachesName.validateCoachesName()
        coachesName.validateNumberOfCoach()
    }

    private fun String.validateCoachesName() {
        this.split(",").forEach { eachCoachName ->
            require(eachCoachName.length in 2..4) {
                "[ERROR] 코치 이름의 길이는 2이상 4이하만 유효합니다."
            }
        }
    }


    private fun String.validateNumberOfCoach() {
        require(this.split(",").size in 2..5){
            "[ERROR] 식사를 하는 코치는 2명에서 5명 사이만 유효합니다."
        }
    }

}