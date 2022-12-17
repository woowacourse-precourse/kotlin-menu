package menu.domain.use_case

import menu.data.Error
import menu.data.Error.Companion.ERROR_HEADER
import menu.data.Error.Companion.ERROR_MEMBER_NUMBERS
import menu.data.Error.Companion.ERROR_NAME_LENGTH
import menu.data.ErrorState.isOkMemberNumbers
import menu.data.ErrorState.isOkNameLength
import menu.data.State.coachNames
import menu.ui.Views
import java.lang.IllegalArgumentException

class ValidateCoachNameUseCase(
    private val views: Views = Views()
) {
    operator fun invoke() {
        do {
            val notSeparatedCoachNames = views.inputView.readCoachName()
            val names = separatedCoachNames(notSeparatedCoachNames)
            validateNameLength(names)
            validateMemberNumbers(names)
            coachNames = names
            // TODO save하는 객체 따로 생성!
        } while (!isOkNameLength || !isOkMemberNumbers)
    }

    private fun List<String>.isValidNameLength(): Boolean {
        return this.all { it.length in COACH_NAME_MIN_LENGTH..COACH_NAME_MAX_LENGTH }
    }

    private fun validateNameLength(names: List<String>) {
        try {
            isOkNameLength = true
            require(names.isValidNameLength())
        } catch (exception: IllegalArgumentException) {
            isOkNameLength = false
            views.outputView.printError(Error.NameLengthError(message = ERROR_HEADER + ERROR_NAME_LENGTH))
        }
    }

    private fun List<String>.isValidMemberNumbers(): Boolean {
        return this.size in COACH_MEMBERS_MIN_COUNT..COACH_MEMBERS_MAX_COUNT
    }

    private fun validateMemberNumbers(names: List<String>) {
        try {
            require(names.isValidMemberNumbers())
            isOkMemberNumbers = true
        } catch (exception: IllegalArgumentException) {
            isOkMemberNumbers = false
            views.outputView.printError(Error.NameLengthError(message = ERROR_HEADER + ERROR_MEMBER_NUMBERS))
        }
    }

    private fun separatedCoachNames(coachNames: String): List<String> {
        return coachNames.split(",")
    }

    companion object {
        const val COACH_NAME_MIN_LENGTH = 2
        const val COACH_NAME_MAX_LENGTH = 4
        const val COACH_MEMBERS_MIN_COUNT = 2
        const val COACH_MEMBERS_MAX_COUNT = 5
    }
}