package menu.domain.model

class WeeklyCategory(private val weeklyCategory: List<Weekday>) : List<Weekday> by weeklyCategory {

    // 한 주에 같은 카테고리는 최대 2회까지만 고를 수 있다.
    init {
        validateWeeklyCategory()
    }

    private fun validateWeeklyCategory() {
        require(weeklyCategory.size == 5) {
            "월, 화, 수, 목, 금으로 이루어진 카테고리를 입력해 주세요."
        }
    }

    fun hasDuplicatedCategory(): Boolean {
        if (weeklyCategory.count { it.getCategory() == FoodCategory.JAPANENSE } > 2 ||
            weeklyCategory.count { it.getCategory() == FoodCategory.KOREAN } > 2 ||
            weeklyCategory.count { it.getCategory() == FoodCategory.JAPANENSE } > 2 ||
            weeklyCategory.count { it.getCategory() == FoodCategory.WESTERN } > 2 ||
            weeklyCategory.count { it.getCategory() == FoodCategory.CHINESE } > 2) {
            return true
        }
        return false
    }

}