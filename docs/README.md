# 미션 - 자동차 경주

##  기능 요구 사항
초간단 자동차 경주 게임을 구현한다.

- 각 자동차에 이름을 부여할 수 있다, 자동차 이름은 쉼표(,)를 기준으로 구분하여 입력받는다. O
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다. O
- 예외 처리 : 이름은 5자 이하만 가능하다. 입력 시도 횟수가 마이너스이거나 0일 수 없다. 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다. O
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다. O
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다. O
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다. O
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다. O
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.  O

### 입출력 요구 사항

#### 입력

- 경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)

```
pobi,woni,jun
```

- 시도할 회수

```
5
```

#### 출력

- 각 차수별 실행 결과

```
pobi : --
woni : ----
jun : ---
```

- 단독 우승자 안내 문구

```
최종 우승자 : pobi
```

- 공동 우승자 안내 문구

```
최종 우승자 : pobi, jun
```

##  프로그래밍 요구 사항

- JDK 17 버전에서 실행 가능해야 한다. **JDK 17에서 정상적으로 동작하지 않을 경우 0점 처리한다.**
- 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- `build.gradle` 파일을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.
- [Java 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java) 가이드를
  준수하며 프로그래밍한다.
- 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- 프로그램 구현이 완료되면 `ApplicationTest`의 모든 테스트가 성공해야 한다. **테스트가 실패할 경우 0점 처리한다.**
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.


##  과제 진행 요구 사항

- **기능을 구현하기 전 `docs/README.md`에 구현할 기능 목록을 정리**해 추가한다.
- **Git의 커밋 단위는 앞 단계에서 `docs/README.md`에 정리한 기능 목록 단위**로 추가한다.

------------------------------------
# 2주차 - Refactoring

##  기능 요구 사항

- 사용하지 않는 코드 삭제
- 적합하지 않은 변수명 변경
- 쓸데없는 개행 정리
- carSplit() 매서드에서 새로운 배열에 넣었다가 return 하지 않고 바로 return 하도록 수정
- for-each 문 사용 시 변수명 의미있는 변수명으로 수정
- 예외처리 시 매서드 명 validate(검증하다) 이용해서 변경
- 자동차 움직임 관리를 Car 클래스로 분리해서 만들어보기
- 코드 depth 3 넘는지 확인
