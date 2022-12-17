package menu.domain

class Validator {
    fun checkValidateCoach(coach: List<String>) {
        require(coach.size == coach.distinct().size && coach.size >= 2 && coach.size <= 5)
        coach.forEach {
            name -> require(name.length in 2..4)
        }
    }
}