
# 기능 목록
- [x] 코치들에게 메뉴를 무작위로 추천한다.
- [x] 월화수목금 음식 카테고리를 무작위 생성한다. 
- [x] 코치 이름 입력
- [x] 코치마다 못먹는 메뉴 입력
- [x] 메뉴를 랜덤으로 추천한다.
  - 두명이라면 월월, 화화, 수수, 목목, 금금 순서
  - val menu: String = Randoms.shuffle(menus)[0]

# 구조
- controller
  - MenuController
- domain
  - CategoryGenerator
- model
  - Coach
  - Coaches
- values
  - Category
  - ErrorMessage
  - MenuMessage
- view
  - InputView
  - OutputView
  - InputValidator

# 추가 예외 목록 
- 콤마가 앞이나 뒤에 입력
- 싫어 하는 음식이 중복 입력

- 코치가 중복인 경우도 다루어야 하는지 모르겠음

# 미션 분석
점심 메뉴 추천 서비스
코치들은 월, 화, 수, 목, 금요일

월, 화, 수, 목, 금 반복
1. 카테고리 무작위 선정
2. 각 코치들은 먹을 메뉴 추천

입력 주의사항
- 코치 이름
  - 2 ~ 4 글자
- 코치 숫자
  - 2 ~ 5 명

- 각 코치가 못먹는 메뉴
  - 0 ~ 2 개
  - ',' 로 구분함
  - 0개는 빈 값 입력
  - 추천을 못하는 경우는 발생하지 않는다.

- 한 주에 같은 카테고리는 최대 2회
  - 각 코치에게 한 주에 중복되지 않는 메뉴를 추천해야 한다.
    예시)
