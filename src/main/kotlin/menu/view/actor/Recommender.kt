package menu.view.actor;

import camp.nextstep.edu.missionutils.Randoms
import menu.exceptions.InvalidCoachCount
import menu.exceptions.InvalidNameLengthException
import menu.strings.GenericString
import menu.strings.MenuErrorMessage
import menu.strings.MenuNames
import java.lang.StringBuilder

class Recommender {
    val categoryRecord = mutableListOf<MenuNames>()

    fun recommendMenu(coach: Coach, category: MenuNames) {
        var menu = generateMenu(category)
        while (coach.toListRecommendations().contains(menu) || coach.toListDenialMenus().contains(menu)) {
            menu = generateMenu(category)
        }
        coach.receiveRecommendation(menu)
    }

    fun recommendCategory(): MenuNames {
        var category = generateRandomCategory()
        while (isDuplicatedCategory(category)) {
            category = generateRandomCategory()
        }
        categoryRecord.add(category)
        return category
    }

    private fun generateMenu(category: MenuNames): String {
        val menu = when (category) {
            MenuNames.JAPAN -> Randoms.shuffle(MenuNames.JAPAN_LIST)[0]
            MenuNames.KOREA -> Randoms.shuffle(MenuNames.KOREA_LIST)[0]
            MenuNames.CHINA -> Randoms.shuffle(MenuNames.CHINA_LIST)[0]
            MenuNames.ASIAN -> Randoms.shuffle(MenuNames.ASIAN_LIST)[0]
            MenuNames.WESTERN -> Randoms.shuffle(MenuNames.WESTERN_LIST)[0]
            else -> throw IllegalArgumentException(MenuErrorMessage.INVALID_CATEGORY_NAME.message)
        }
        return menu
    }

    fun toStringCategoryRecord(): String {
        val builder = StringBuilder("[ ${GenericString.CATEGORY.str} |")
        for (record in categoryRecord) {
            builder.append(" ${record.category} |")
        }
        builder.setLength(builder.length - 1)
        builder.append("]")
        return builder.toString()
    }

    private fun generateRandomCategory(): MenuNames {
        return when (Randoms.pickNumberInRange(1, 5)) {
            1 -> MenuNames.JAPAN
            2 -> MenuNames.KOREA
            3 -> MenuNames.CHINA
            4 -> MenuNames.ASIAN
            5 -> MenuNames.WESTERN
            else -> MenuNames.NONE
        }
    }

    private fun isDuplicatedCategory(category: MenuNames): Boolean {
        var count = 0
        for (record in categoryRecord) {
            if (record == category)
                count++
        }
        if (count >= 2) return true
        return false
    }


}
