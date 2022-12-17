## 요구 사항 요약
- 코치들은 월,화,수,목,금 함께 점심 식사
- 메뉴 추천 과정
1. 월요일에 추천할 카테고리를 무작위로 정한다
2. 각 코치가 월요일에 먹을 메뉴를 추천
3. 화, 수, 목, 금요일에 대해 과정1, 2 반복
- 코치
1. 이름은 2~4글자 
2. 2~5명까지 함께 식사
3. 각 코치는 0~2개의 못먹는 메뉴 존재 (,로 구분, 먹지 못하는 메뉴는 빈 값, 추천 못하는 경우 고려 X)
- 한 주에 같은 카테고리는 최대 2회까지만 고를 수 있다
- 각 코치에게 한 주에 중복되지 않는 메뉴 추천
- 메뉴 추천 완료 후 프로그램 종료
- 잘못된 값을 입력할 경우 IllegalArgumentException 발생, 정해진 에러 메시지 출력


## 기능 정의

### Category (Enum)
```
일식: 규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼
한식: 김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음
중식: 깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채
아시안: 팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜
양식: 라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니
```
제카테고리와 카테고리에 맞는 음식을 담은 클래스
- 일식
- 양식
- 중식
- 아시안
- 전부

### MenuResult
추천 결과를 담은 클래스
#### Field
- categories : 월,화,수,목,금의 카테고리 모음 리스트
- recommendations : key(코치 이름)-value(추천 메뉴 리스트)

### Coach
코치의 정보를 담는 클래스
#### Field
- name : 코치의 이름
- uneatableMenus : 못먹는 메뉴 리스트
#### methods
- addUneatableMenus : 못먹는 메뉴 추가
- isUneatable : 인자로 들어온 메뉴를 못먹는지 판단, 못먹으면 true, 먹을 수 있으면 false 반환

### MenuRecommender
#### methods
- makeMenus : 최종 추천 메뉴를 결정해 MenuResult로 반환
- convertCategory : 1~5 랜덤값을 알맞는 Category로 반환
- makeCategories : 월,화,수,목,금 카테고리 5개를 선정하는 메소드
- getEatableMenu : 먹을 수 있는 메뉴를 선정하여 반환
- makeRecommendations : 카테고리에 알맞는 추천 메뉴를 모아 리스트로 만들어 반환

### InputView
#### methods
- checkCoachNamesRequirements : 입력된 코치 이름이 요구사항에 맞는지 확인하는 메소드, 맞지 않으면 [ERROR] 메시지 출력
- readCoaches : 코치 이름을 입력 받아 Coach 리스트로 반환
- checkMenuNameInCategory : 입력받은 메뉴가 카테고리 내에 있는 메뉴들이면 true, 없는 메뉴가 있으면 false 반환, false 반환 전에 [ERROR] 메시지 출력
- checkMenuItemSize : 입력 받은 메뉴의 개수가 2개를 초과하지 않으면 true, 초과하면 false 반환, false 반환 전에 [ERROR] 메시지 출력
- readMenu : 못 먹는 메뉴를 입력 받는 메소드
- readMenus : 코치 별로 못먹는 메뉴들을 입력 받아 인자로 받은 coaches의 각 Coach 객체들에게 먹을 수 없는 메뉴로 추가해주는 메소드 (readMenu 메소드 활용)

### OutputView
#### methods
- printCategories : 카테고리 출력
- printRecommendations : 각 코치별 추천 메뉴들 출력
- printResult : 추천 결과 전체 출력