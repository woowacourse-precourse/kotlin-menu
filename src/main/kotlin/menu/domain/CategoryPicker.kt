package menu.domain

import menu.domain.categorynumbergenerator.CategoryNumberGenerator

class CategoryPicker(private val categoryNumberGenerator: CategoryNumberGenerator) {

    val categorys = mutableListOf<AvaliableMenu>()

    fun genrateCategorys(): MutableList<AvaliableMenu> {
        while (categorys.size < 6) {
            val randomNumber = categoryNumberGenerator.generate()
            if (categorys.count { it == AvaliableMenu.convertPickerNumberToValue(randomNumber) } < 2) {
                categorys.add(AvaliableMenu.convertPickerNumberToValue(randomNumber))
            }
        }
        return categorys
    }
}
