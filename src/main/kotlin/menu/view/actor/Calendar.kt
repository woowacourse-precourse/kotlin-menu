package menu.view.actor

import menu.strings.CalendarStrings

class Calendar {
    val weeks = listOf(
        CalendarStrings.MON.str,
        CalendarStrings.THE.str,
        CalendarStrings.WED.str,
        CalendarStrings.THU.str,
        CalendarStrings.FRI.str
    )

    override fun toString(): String {
        return "[ ${CalendarStrings.SORT.str} | ${weeks[0]} | ${weeks[1]} | ${weeks[2]} | ${weeks[3]} | ${weeks[4]} ]"
    }
}