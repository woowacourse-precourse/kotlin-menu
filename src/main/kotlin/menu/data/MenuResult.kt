package menu.data

data class MenuResult(val categories: List<Category>, val recommendations: Map<String, List<String>>)