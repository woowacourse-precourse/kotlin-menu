package menu

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertTimeoutPreemptively
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable
import org.mockito.ArgumentMatchers
import org.mockito.MockedStatic
import org.mockito.Mockito.mockStatic
import java.time.Duration
import java.util.Arrays


class ApplicationTest : NsTest() {
    @DisplayName("전체 기능 테스트")
    @Nested
    internal inner class AllFeatureTest {
        @Test
        fun `추천할 카테고리를 고르는 기능 테스트 - 카테고리는 2회 이상 중복될 수 없다`() {
            assertTimeoutPreemptively(RANDOM_TEST_TIMEOUT) {
                val executable = Executable {
                    var category = CategoryRepository().getRecommendCategory()
                    category = CategoryRepository().getRecommendCategory()
                    category = CategoryRepository().getRecommendCategory()
                    assertThat(category == "중식")
                    //1: "일식", 2: "한식", 3: "중식", 4: "아시안", 5: "양식"
                }
                assertRandomTest(
                    executable,
                    Mocking.ofRandomNumberInRange(2, 2, 2, 3),  // 숫자는 카테고리 번호를 나타낸다.
                )
            }
        }

        @Test
        fun `추천할 카테고리를 고르는 기능 테스트 - 각 숫자에 대응하는 카테고리를 추천해야 한다`() {
            assertTimeoutPreemptively(RANDOM_TEST_TIMEOUT) {
                val executable = Executable {
                    var category = CategoryRepository().getRecommendCategory()
                    assertThat(category == "일식")
                    category = CategoryRepository().getRecommendCategory()
                    assertThat(category == "한식")
                    category = CategoryRepository().getRecommendCategory()
                    assertThat(category == "중식")
                    category = CategoryRepository().getRecommendCategory()
                    assertThat(category == "아시안")
                    category = CategoryRepository().getRecommendCategory()
                    assertThat(category == "양식")
                    //1: "일식", 2: "한식", 3: "중식", 4: "아시안", 5: "양식"
                }
                assertRandomTest(
                    executable,
                    Mocking.ofRandomNumberInRange(1, 2, 3, 4, 5),  // 숫자는 카테고리 번호를 나타낸다.
                )
            }
        }

        @Test
        fun `메뉴 추천 기능 테스트 - 추천할 수 없는 메뉴인 경우 다시 섞은 후 첫 번째 값을 사용해야 한다`() {
            assertTimeoutPreemptively(RANDOM_TEST_TIMEOUT) {
                val executable = Executable {
                    val menu = MenuRepository().getRecommendMenu(listOf("김치찌개, 제육볶음"), listOf("김밥"), "한식")
                    assertThat(menu == "쌈밥")
                }
                assertRandomTest(
                    executable,Mocking.ofShuffle(
                        listOf("김치찌개", "김밥", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"),
                        listOf("제육볶음", "김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이"),
                        listOf("김밥", "제육볶음", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이"),
                        listOf("쌈밥", "김밥", "김치찌개", "제육볶음", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이"),
                    )
                )
            }
        }


        @Test
        fun `기능 테스트`() {
            assertTimeoutPreemptively(RANDOM_TEST_TIMEOUT) {
                val executable = Executable {
                    runException("구구,제임스", "김밥", "떡볶이")
                    assertThat(output()).contains(
                        "점심 메뉴 추천을 시작합니다.",
                        "코치의 이름을 입력해 주세요. (, 로 구분)",
                        "구구(이)가 못 먹는 메뉴를 입력해 주세요.",
                        "제임스(이)가 못 먹는 메뉴를 입력해 주세요.",
                        "메뉴 추천 결과입니다.",
                        "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]",
                        "[ 카테고리 | 한식 | 양식 | 일식 | 중식 | 아시안 ]",
                        "[ 구구 | 김치찌개 | 스파게티 | 규동 | 짜장면 | 카오 팟 ]",
                        "[ 제임스 | 제육볶음 | 라자냐 | 가츠동 | 짬뽕 | 파인애플 볶음밥 ]",
                        "추천을 완료했습니다."
                    )
                }
                assertRandomTest(
                    executable,
                    Mocking.ofRandomNumberInRange(2, 5, 1, 3, 4),  // 숫자는 카테고리 번호를 나타낸다.
                    Mocking.ofShuffle(
                        // 월요일
                        listOf("김치찌개", "김밥", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"),  // 구구
                        listOf("제육볶음", "김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이"),  // 제임스
                        // 화요일
                        listOf("스파게티", "라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "피자", "파니니"),  // 구구
                        listOf("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"),  // 제임스
                        // 수요일
                        listOf("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"),  // 구구
                        listOf("가츠동", "규동", "우동", "미소시루", "스시", "오니기리", "하이라이스", "라멘", "오코노미야끼"),  // 제임스
                        // 목요일
                        listOf("짜장면", "깐풍기", "볶음면", "동파육", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"),  // 구구
                        listOf("짬뽕", "깐풍기", "볶음면", "동파육", "짜장면", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"),  // 제임스
                        // 금요일
                        listOf("카오 팟", "팟타이", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"),  // 구구
                        listOf("파인애플 볶음밥", "팟타이", "카오 팟", "나시고렝", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜") // 제임스
                    )
                )
            }
        }
        @Test
        fun `기능 테스트 2`() {
            assertTimeoutPreemptively(RANDOM_TEST_TIMEOUT) {
                val executable = Executable {
                    runException("토미,제임스,포코", "우동,스시", "뇨끼,월남쌈", "마파두부,고추잡채")
                    assertThat(output()).contains(
                        "점심 메뉴 추천을 시작합니다.",
                        "코치의 이름을 입력해 주세요. (, 로 구분)",
                        "토미(이)가 못 먹는 메뉴를 입력해 주세요.",
                        "제임스(이)가 못 먹는 메뉴를 입력해 주세요.",
                        "포코(이)가 못 먹는 메뉴를 입력해 주세요.",
                        "메뉴 추천 결과입니다.",
                        "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]",
                        "[ 카테고리 | 한식 | 한식 | 일식 | 중식 | 아시안 ]",
                        "[ 토미 | 쌈밥 | 김치찌개 | 미소시루 | 짜장면 | 팟타이 ]",
                        "[ 제임스 | 된장찌개 | 비빔밥 | 가츠동 | 토마토 달걀볶음 | 파인애플 볶음밥 ]",
                        "[ 포코 | 된장찌개 | 불고기 | 하이라이스 | 탕수육 | 나시고렝 ]",
                        "추천을 완료했습니다."
                    )
                }
                assertRandomTest(
                    executable, //1: "일식", 2: "한식", 3: "중식", 4: "아시안", 5: "양식"
                    Mocking.ofRandomNumberInRange(2, 2, 1, 3, 4),  // 숫자는 카테고리 번호를 나타낸다.
                    Mocking.ofShuffle(
                        // 월요일
                        listOf("쌈밥", "김밥", "김치찌개", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"),  // 토미
                        listOf("된장찌개", "김밥", "김치찌개", "쌈밥", "제육볶음", "비빔밥", "칼국수", "불고기", "떡볶이"),  // 제임스
                        listOf("된장찌개", "김밥", "김치찌개", "쌈밥", "제육볶음", "비빔밥", "칼국수", "불고기", "떡볶이"),  // 포코
                        // 화요일
                        listOf("김치찌개", "김밥", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"),  // 토미
                        listOf("비빔밥", "김밥", "김치찌개", "쌈밥", "제육볶음", "된장찌개", "칼국수", "불고기", "떡볶이"),  // 제임스
                        listOf("불고기", "김밥", "김치찌개", "쌈밥", "제육볶음", "비빔밥", "칼국수", "된장찌개", "떡볶이"),  // 포코
                        // 수요일
                        listOf("미소시루", "우동", "규동", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"),  // 토미
                        listOf("가츠동", "규동", "우동", "미소시루", "스시", "오니기리", "하이라이스", "라멘", "오코노미야끼"),  // 제임스
                        listOf("하이라이스", "규동", "우동", "미소시루", "스시", "오니기리", "가츠동", "라멘", "오코노미야끼"),  // 포코
                        // 목요일
                        listOf("짜장면", "깐풍기", "볶음면", "동파육", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"),  // 토미
                        listOf("토마토 달걀볶음", "깐풍기", "볶음면", "동파육", "짜장면", "마파두부", "탕수육", "짬뽕", "고추잡채"),  // 제임스
                        listOf("탕수육", "깐풍기", "볶음면", "동파육", "짜장면", "마파두부", "토마토 달걀볶음", "짬뽕", "고추잡채"),  // 포코
                        // 금요일
                        listOf("팟타이", "카오 팟",  "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"),  // 토미
                        listOf("파인애플 볶음밥", "팟타이", "카오 팟", "나시고렝", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"), // 제임스
                        listOf("나시고렝", "팟타이", "카오 팟", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜") // 포코
                    )
                )
            }
        }
    }



    @DisplayName("전체 예외 테스트")
    @Nested
    internal inner class ExceptionTest {
        val ERROR_MESSAGE = "[ERROR]"
        @Test
        fun `코치 이름 예외 테스트 - 코치의 이름이 최소 2글자, 최대 4글자가 아닌 경우 예외를 발생시킨다`() {
            assertSimpleTest {
                runException("구구구구구구구,제임스")
                assertThat(output()).contains(ERROR_MESSAGE)
            }
            assertSimpleTest {
                runException("구,제임스")
                assertThat(output()).contains(ERROR_MESSAGE)
            }
        }
        @Test
        fun `코치 이름 예외 테스트 - 코치가 최소 2명, 최대 5명이 아닌 경우 예외를 발생시킨다`() {
            assertSimpleTest {
                runException("제임스")
                assertThat(output()).contains(ERROR_MESSAGE)
            }
            assertSimpleTest {
                runException("구,제임스,제,임,스,구구")
                assertThat(output()).contains(ERROR_MESSAGE)
            }
        }
        @Test
        fun `못 먹는 메뉴 예외 테스트 - 못 먹는 메뉴가 최소 0개, 최대 2개가 아니면 예외를 발생시킨다`() {
            assertSimpleTest {
                runException("구구,제임스", "김,치,찌,개")
                assertThat(output()).contains(ERROR_MESSAGE)
            }
            assertSimpleTest {
                runException("구구,제임스", "김,밥", "김,치,찌,개")
                assertThat(output()).contains(ERROR_MESSAGE)
            }
        }
    }

    class Mocking<T>(
        /**
         * stubbing lambda verification
         * 예시)
         * () -> Randoms.pickNumberInList(anyList())
         */
        private val verification: MockedStatic.Verification,
        // 반환할 첫 번째 값
        private val value: T,
        vararg values: T
    ) {
        /**
         * 첫 번째 값을 반환하고 나서 다음에 반환할 값들.
         * 예를 들면, verification을 처음 실행하면 value를 반환하고
         * 두 번째 실행하면 values[0]을 반환한다.
         */
        private val values: Array<T>

        init {
            this.values = values as Array<T>
        }

        fun <S> stub(mock: MockedStatic<S>) {
            mock.`when`<Any>(verification).thenReturn(value, *Arrays.stream(values).toArray())
        }

        companion object {
            fun ofRandomNumberInRange(value: Int?, vararg values: Int?): Mocking<*> {
                return Mocking<Any?>({
                    Randoms.pickNumberInRange(
                        ArgumentMatchers.anyInt(),
                        ArgumentMatchers.anyInt()
                    )
                }, value, *values)
            }

            fun <T> ofShuffle(value: List<T>?, vararg values: List<T>?): Mocking<*> {
                return Mocking<Any?>({ Randoms.shuffle(ArgumentMatchers.anyList<Any>()) }, value, *values)
            }
        }

    }

    override fun runMain() {
        main()
    }

    companion object {
        private val RANDOM_TEST_TIMEOUT = Duration.ofSeconds(10L)
        private fun assertRandomTest(
            executable: Executable,
            vararg mockingValues: Mocking<*>
        ) {
            assertTimeoutPreemptively(RANDOM_TEST_TIMEOUT) {
                mockStatic(Randoms::class.java).use { mock ->
                    Arrays.stream(mockingValues).forEach { mocking -> mocking.stub(mock) }
                    executable.execute()
                }
            }
        }
    }
}
