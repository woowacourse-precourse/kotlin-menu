package menu.domain

import menu.ui.InputView
import menu.ui.OutputView

class UserController {
    private val outputView = OutputView()
    private val inputView = InputView()

    fun programRun() {
        outputView.printInitNotice()
        outputView.printNoticeEnterName()
        val coachNameContainer = inputView.enterCoachName()

        for (coachName in coachNameContainer.indices) {
            outputView.printNoticeNoEating(coachNameContainer[coachName])
            inputView.enterNoEating()
        }
//        print(a.length)
//
//        val temp = a.split(",")
//        print("dd$temp")
//        for (i in temp.indices){
//            print(i)
//        }
        //inputView.enterNoEating()
    }
}