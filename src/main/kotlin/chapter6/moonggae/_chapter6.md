# Chapter 6

### 73. 예외 처리
1. 오류 보고
   - `Exception`을 이용해 오류를 `throw`
   - `throw`는 `Throwable`의 하위 타입을 요구
   - `Exception`을 상속해서 구체적인 예외 타입을 정의할 수 있음


2. 복구
   - `Exception`을 `throw`하면 함수 호출 체인의 위쪽으로 전달됨.
   - 예외가 전달되는 과정에서 `Exception Handler`(`try catch`구문)에서 잡히면 `catch`가 실행되고, 그렇지 않다면 콘솔에 스택 트레이스를 출력하고 프로그램이 종료됨
   - `catch`절이 여러개일 경우 순서에 따라 부모 클래스 예외가 자식 클래스 예외를 잡을 수 있다.
   - 핸들러를 여러개 사용할 때 처리 방식이 달라야 한다면 다른 예외 타입을 사용하고, 처리 방법이 같은 경우 동일한 예외 타입을 쓰면서 생성자 인자를 다르게 주는 방식으로 구체적은 정보를 전달할 것


3. 자원 해제
    - `try`블록의 예외 발생 유무에 관계 없이 `finally`절이 실행됨

가이드라인
- 코틀린 예외 처리 주목적은 버그를 발견하는 것임
1. 논리 오류: 최상위 수준에서 예외를 잡고 버그를 보고
2. 데이터 오류: 프로그래머가 제어할 수 없는 잘못된 데이터에 의해 발생
   - `orNull`, `orNull ?: default` 등으로 처리
3. 검사 명령: 검사 명령으로 오류 검사하기
4. 입출력(I/O) 오류: 제어할 수 없는 외부 조건이지만 복구를 시도 해야함

### 74. 검사 명령
- 검사 명령을 사용하면 요구 조건을 명확히 나타내 코드 가독성을 높인다.

`require()`: 인자 검사
- 보통 함수 본문 맨 앞에 위치
- throw `IllegalArgumentException`
```kotlin
data class Month(val monthNumber: Int) {
    init {
        require(monthNumber in 1..12) { 
            "Month out of range: $monthNumber" // 오류 메시지 
        }
    }
}

fun main() {
    Month(1) eq "Month(monthNumber=1)"
    capture { Month(13) } eq
            "IllegalArgumentException: " +
            "Month out of range: 13"
}
```

`requireNotNull()`: 값이 `null`일 경우 `throw IllegalArgumentException`, 아닐 경우 그 값을 반환
```kotlin
fun notNull(n: Int?): Int {
    requireNotNull(n) {             
        "notNull() argument cannot be null" // 오류 메시지
    }
    return n * 9
}

fun main() {
    val n: Int? = null
    capture {
        notNull(n)
    } eq "IllegalArgumentException: " +
            "notNull() argument cannot be null"
    capture {
        requireNotNull(n) // 오류 메시지 람다 없이 사용 가능 
    } eq "IllegalArgumentException: " +
            "Required value was null."
    notNull(11) eq 99
}
```

`check()`: 결과를 검사 할 때 사용
- 보통 함수 끝에 위치
- throw `IllegalStateException`
```kotlin
fun createResultFile(create: Boolean) {
    if (create)
        resultFile.writeText("Results\n# ok")
    check(resultFile.exists()) {
        "${resultFile.name} doesn't exist!"
    }
}

fun main() {
    resultFile.erase()
    capture {
        createResultFile(false)
    } eq "IllegalStateException: " +
            "Results.txt doesn't exist!"
    createResultFile(true)
}
```

`assert()`: `check()`와 사용방법은 동일
- `assert()`검사는 활성화, 비활성화 가능
- 기본적으로 비활성화
- `-ea` 플래그를 이용해 활성화


### Nothing
- 항상 예외를 던지는 함수의 반환 타입


`TODO()`
```kotlin
public inline fun TODO(): Nothing = throw NotImplementedError()
```
```kotlin
fun later(s: String): String = TODO("later()")

fun later2(s: String): Int = TODO()

fun main() {
    capture {
        later("Hello")
    } eq "NotImplementedError: " +
            "An operation is not implemented: later()"
    capture {
        later2("Hello!")
    } eq "NotImplementedError: " +
            "An operation is not implemented."
}
```
- 리스트를 `null`로 초기화 할 때 타입을 명시하지 않으면 컴파일러가 `List<Nothing?>` 탑으로 추론한다.


### 자원 해제 - use()
- `try finally` 복잡도를 낮추기 위해 제공
- 자바의 `AutoCloseable` 인터페이스를 구현하는 객체에 작용
- 코드 블록 실행후 `close()` 호출
```kotlin
fun main() {
    DataFile("Results.txt")
        .bufferedReader()
        .use { it.readLines().first() } eq
            "Results"
}
```
- `AutoCloseable` 인터페이스 구현 가능

### 로깅
- 로깅 라이브러리를 사용하여 동적으로 켜고 끄기

```kotlin
// 빠르지만 지저분한 전역 함수 사용 예제

val logFile = DataFile("simpleLogFile.txt").reset()

fun debug(msg: String) =
    System.err.println("Debug: $msg")
// 비활성화하고 싶으면 다음과 같이 바꿔라
// fun debug(msg: String) = Unit

fun trace(msg: String) =
    logFile.appendText("Trace: $msg\n")

fun main() {
    debug("Simple Logging Strategy")
    trace("Line 1")
    trace("Line 2")
    println(logFile.readText())
}
/* Sample Output:
Debug: Simple Logging Strategy
Trace: Line 1
Trace: Line 2
*/
```
```kotlin
// 간단한 로깅 클래스
class Logger(fileName: String) {
   val logFile = DataFile(fileName).reset()
   private fun log(type: String, msg: String) =
      logFile.appendText("$type: $msg\n")
   fun trace(msg: String) = log("Trace", msg)
   fun debug(msg: String) = log("Debug", msg)
   fun info(msg: String) = log("Info", msg)
   fun warn(msg: String) = log("Warn", msg)
   fun error(msg: String) = log("Error", msg)
   // 기본 테스트를 위한 함수다
   fun report(msg: String) {
      trace(msg)
      debug(msg)
      info(msg)
      warn(msg)
      error(msg)
   }
}

private val logger = Logger("AtomicLog.txt")

fun main() {
   logger.report("Hello, Atomic Log!")
   logger.logFile.readText() eq """
  Trace: Hello, Atomic Log!
  Debug: Hello, Atomic Log!
  Info: Hello, Atomic Log!
  Warn: Hello, Atomic Log!
  Error: Hello, Atomic Log!
  """
}
```

### 단위 테스트
- 함수의 여러 측면에 대해 올바른지 검증하는 테스트를 작성하는 방법
- 망가진 코드가 빠르게 드러나고 개발속도가 향상됨
- 프로젝트를 빌드할 때마다 실행: 실행 속도가 빨라야함
- 의존성 추가: `implementation(kotlin("test"))`
```
assertTrue(), assertFalse()
assertEquals(), assertNotEquals()
assertSame(), assertNotSame()
assertIs(), assertIsNot()
assertIsOfType(), assertIsNotOfType()
assertNull(), assertNotNull()
assertContains()
assertRangeContains()
assertContentEquals()
// ...
```
[예제](unittest/UsingExpect.kt)

### 테스트 프레임워크
- JUnit5: 종속성 추가
- `test` directory 에서 진행
- `@Test` 어노테이션 사용
- `public actual typealias Test = org.junit.jupiter.api.Test`


- `@Test` 함수 실행 항법
  - 독립적으로 실행
  - 클래스의 일부분으로 실행
  - 애플리케이션에 정의된 모든 테스트와 함께 실행


- \`\`기호를 이용해 함수 이름을 정의하면 아무 문자나 이름으로 사용할 수 있다. ([StateMachineTest](../../../../test/kotlin/moonggae/unittesting/StateMachineTest.kt))
- 테스트 데이터를 생성하기 위한 유틸리티 함수를 추가해서 이용하기 ([makeLearner](../../../../test/kotlin/moonggae/unittesting/LearnerTest.kt))


모킹과 통합 테스트
- `mock`: 실물을 대신하는 가짜(db, mock class, etc ..)
- 통합 테스트: 시스템의 여러 부분을 합쳤을 때 작동하는지 검증

