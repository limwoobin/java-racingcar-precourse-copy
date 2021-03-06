## 구현 기능 목록 명세

- 자동차의 이름을 입력받는 기능에 대해, 테스트 코드를 작성하여 검증하고, 기능을 구현하라
  - 자동차의 이름이 5자리를 초과하면 IllegalArgumentException 발생시킨다
  - 입력한 자동차가 최소 2대 이상이어야 한다, 아니라면 IllegalArgumentException 을 발생시킨다 (추가 요구사항)
  - 자동차의 이름이 중복되면 IllegalArgumentException 을 발생시킨다 (추가 요구사항)
- 사용자가 몇번을 이동할지 입력하는 기능에 대해 테스트 코드를 작성하여 검증하고 기능을 구현하라
  - 이동할 수 있는 값은 정수만 와야한다. 아니라면 IllegalArgumentException 을 발생시킨다
  - 이동할 수 있는 숫자는 1~9 사이다. 아니라면 IllegalArgumentException 을 발생시킨다 (추가 요구사항)
- 전진하는 조건을 제시하는 0,9 사이의 랜덤값을 제공하는 기능에 대해 테스트 코드를 작성하여 검증하고, 기능을 구현하라
- 추출된 랜덤값에 대해 4 이상이면 전진하는 기능에 대해 테스트 코드를 작성하여 검증하고, 기능을 구현하라
- 추출된 랜덤값에 대해 3 이하의 값이면 멈추는 기능에 대해 테스트 코드를 작성하여 검증하고, 기능을 구현하라
- 잘못된 값을 입력해 IllegalArgumentException 이 발생된 경우 "[ERROR]" 를 출력하는 기능을 구현하라
- IllegalArgumentException 발생 후 발생 부분부터 다시 로직이 수행되는 기능에 대해 테스트 코드를 작성하고, 기능을 구현하라
- 경주를 진행하는 기능을 구현하고 테스트코드를 작성한다
  - 이동할때마다 레이싱카의 이동 거리를 출력한다
- 경주가 완료한 후 누가 우승자인지 판단하는 기능에 대해 테스트 코드를 작성하여 검증하고, 기능을 구현한다
- 우승자를 출력하는 기능을 작성하라
  - 한명 이상인 경우 쉼표(,)로 이름을 구분해 출력해야 한다