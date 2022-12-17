package menu

class OutputView {
    enum class Message(val sentence:String){
        START_MESSAGE("점심 메뉴 추천을 시작합니다.\n"),
        INPUT_COACH_NAME("코치의 이름을 입력해 주세요. (, 로 구분)"),
        INPUT_CANT_EAT_MENU("(이)가 못 먹는 메뉴를 입력해 주세요."),
        RESULT("메뉴 추천 결과입니다."),
        START_LINE("[ "),
        END_LINE(" ]"),
        PARTITION(" | "),
        COMPLETE("추천을 완료했습니다."),
        CATEGORY("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]\n[ 카테고리 | ")
    }


    fun printStartMessage(){
        println(Message.START_MESSAGE.sentence)
    }

    fun printInputCoachNames(){
        println(Message.INPUT_COACH_NAME.sentence)
    }

    fun printCantEatMenu(name:String){
        print(name)
        println(Message.INPUT_CANT_EAT_MENU.sentence)
    }

    fun printError(message:String){
        println(message)
    }

    fun printCategoryResult(result:List<String>){
        println(Message.RESULT.sentence)
        print(Message.CATEGORY.sentence)
        var i = 0
        while (i < result.size - 1) {
            print(result[i] + Message.PARTITION.sentence)
            i++
        }
        print(result[result.size - 1])
        println(Message.END_LINE.sentence)
    }

    fun printFinalResult(result: Pair<List<String>, MutableList<String>>){
        for (i in 0 until result.first.size){
            print(Message.START_LINE.sentence)
            print(result.first[i]+ Message.PARTITION.sentence)
            for(n in 0 until 5) {
                if(n<4){
                    print(result.second[i + result.first.size*n] + Message.PARTITION.sentence)
                }
                if(n==4){
                    print(result.second[i + result.first.size*n])
                }
            }
            println(Message.END_LINE.sentence)
        }
        println(Message.COMPLETE.sentence)
    }

}