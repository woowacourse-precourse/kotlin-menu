package menu.domain

class Categories(private val categories: MutableList<Category> = mutableListOf()) {

    init {
        require(categories.size <= MAX_LENGTH)
        require(categories.all {
            categories.count { it in categories }  <= MAX_DUPLICATED
        })
    }

    fun add(category: Category): Boolean {
        if (count(category) >= MAX_DUPLICATED || categories.size >= MAX_LENGTH) return false
        return categories.add(category)
    }

    private fun count(category: Category) = categories.count { it == category }

    companion object {
        private const val MAX_LENGTH = 5
        private const val MAX_DUPLICATED = 2
    }
}