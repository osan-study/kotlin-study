# 02 - 왜 코틀린인가?

## 컴파일러와 인터프리터

### 인터프리터
**인터프리터**라는 프로그램을 통해 언어를 실행함

### 컴파일러
- 소스코드를 **컴파일**하여 하드웨어 프로세서에서 직접 직접 실행 하거나 **가상 머신**에서 실행할 수 있는 다른 표현으로 변환됨
- **기계 코드**: `C`, `C++`, `Rust`는 CPU에서 직접 실행되는 기계 코드로 컴파일됨
- **바이트 코드**: `Java`, `Kotlin`은 CPU에서 실행하지 못하고 가상 머신에서 실행할 수 있는 바이트 코드로 컴파일됨

### 가상 머신(Virture Machine)
- **이식성**: 가상 머신만 설치되어 있으면 바이트 코드를 어느 기계에서나 실행할 수 있음
- **최적화**: 가상 머신은 특정 하드웨어에 맞춰 최적화되어 속도 문제를 해결
- **JMV**: 수십 년 동안 다양한 플랫폼에 최적화 기능이 포함되어 구현됨

### 컴파일 시점 오류(compile time error)
- 컴파일 시점에 컴파일러가 코드를 검사해 발견하는 오류
- 개발 환경이 코드 입력시 오류를 표시하며 쉽게 해결 할 수 있음

### 실행 시점 오류(runtime error)
- 컴파일 시점에 감지할 수 없는 오류
- 프로그램을 실행해야만 발견할 수 있는 오류
- **정적으로 타입을 지정하는 언어(statically typed language)**: 컴파일 시점에 가능한 한 많은 오류를 찾아냄
- **동적 언어(dynamic language)**: 검사를 실행 시점에 수행함

## 코틀린에 영향을 미친 언어 (ChatGPT 작성)
### 1. 포트란(FORTRAN)
- **수식 변환(FORmula TRANslation, 1957)**: 
  - 과학자와 공학자가 수식을 쉽게 코딩할 수 있도록 설계됨.
  - 튜닝되고 테스트된 포트란 라이브러리는 여전히 사용됨.
  - 다른 언어에서 호출할 수 있도록 포트란 라이브러리를 ‘감싸는’ 형태로 많이 사용됨.

### 2. 리스프(LISP)
- **리스트 처리기(LISt Processor, 1958)**: 
  - 특정 응용 분야를 목표로 개발되지 않고 필수적인 프로그래밍 개념을 구현한 언어.
  - 첫 번째 함수형 프로그래밍 언어로, 강력함과 유연성을 제공함.
  - 초기 컴퓨터에서는 성능이 좋지 않았지만, 최근에 이르러 빠른 컴퓨터에서 다시 사용됨.
  - GNU Emacs 에디터는 리스프로 작성되었고, 리스프로 확장할 수 있음.

### 3. 알골(ALGOL)
- **알고리즘적 언어(ALGOrithmic Language, 1958)**: 
  - 1950년대 언어 중 가장 영향력이 컸던 언어로, 후속 언어들에 많은 영향을 줌.
  - C와 C 기반 언어들은 모두 ‘알골과 비슷한’ 언어로 분류됨.

### 4. 코볼(COBOL)
- **일반 비즈니스 중심 언어(COmmon Business-Oriented Language, 1959)**: 
  - 비즈니스, 재무, 관리 데이터를 처리하기 위해 개발된 언어.
  - 영어와 비슷한 문법을 제공하며, 자체 문서화가 가능하도록 설계됨.
  - 미국 국방부에서 메인프레임 컴퓨터에 널리 채택되었으며, 여전히 일부 시스템에서 사용됨.

### 5. 베이직(BASIC)
- **초보자용 범용 기호 명령 코드(Beginner's All-purpose Symbolic Instruction Code, 1964)**: 
  - 사람들이 프로그래밍을 쉽게 할 수 있도록 설계된 초기 언어.
  - 인터프리터에 의해 실행되며, 마이크로소프트 오피스 제품에서 스크립트 언어로 사용됨.
  - 수많은 베이직 변종이 존재하며, 최초의 ‘열린’ 프로그래밍 언어로 간주됨.

### 6. 시뮬라(Simula)
- **객체 지향 언어의 시작(1967)**: 
  - 시뮬레이션을 위해 개체 생성을 직접 지원하는 언어로, 객체 지향 언어의 시초가 됨.
  - 시뮬레이션용 개체 생성 아이디어가 범용 프로그래밍에도 유용함이 밝혀짐.

### 7. 파스칼(Pascal)
- **단일 패스 컴파일러(Single Pass Compiler, 1970)**: 
  - 컴파일 속도를 높이기 위해 언어를 제한하여 설계됨.
  - 프로그래머가 정해진 방법에 따라 코드를 구조화하도록 강제하여, 가독성이 떨어질 수 있음.
  - 볼랜드사가 만든 터보 파스칼은 성능이 나쁜 기계에서도 빠르게 컴파일할 수 있었음.

### 8. C 언어
- **고수준 어셈블리 언어(1972)**: 
  - 시스템 프로그래밍을 위해 설계된 언어로, 어셈블리 언어를 대체할 수 있는 고수준 어셈블리 언어.
  - C 컴파일러만 있으면 다양한 프로세서에서 프로그램을 실행할 수 있음.
  - 운영체제 수준의 프로그램 작성에 널리 사용되며, 시스템 프로그래밍에서 C의 왕좌를 넘보는 언어들이 만들어짐.

### 9. 스몰토크(Smalltalk)
- **순수 객체 지향 언어(1972)**: 
  - 순수 객체 지향 언어로 설계되었으며, 애플리케이션을 신속히 개발하고 실험할 수 있는 플랫폼을 제공함.
  - 객체 지향과 언어 이론을 발전시키는 데 기여함.

### 10. C++
- **객체를 제공하는 더 나은 C(1983)**: 
  - C와의 하위 호환성을 유지하면서 객체 지향 기능을 추가한 언어.
  - 메모리 관리 문제를 개선했으며, 하위 호환성으로 인해 도입이 간편했음.

### 11. 파이썬(Python)
- **친근하고 유연한 언어(1990)**: 
  - 함수형 프로그래밍과 객체 지향 프로그래밍을 조합한 최초의 주류 언어.
  - 가비지 컬렉션을 사용한 자동 메모리 관리와 여러 플랫폼에서 프로그램을 실행하는 능력을 제공함.

### 12. 하스켈(Haskell)
- **순수 함수형 프로그래밍 언어(1990)**: 
  - 순수 프로그래밍 연구를 위한 열린 표준으로 만들어짐.
  - 문법과 아이디어가 코틀린을 포함한 여러 언어에 영향을 줌.

### 13. 자바(Java)
- **가상 머신과 가비지 컬렉션(1995)**: 
  - TV 셋톱 박스 코드를 작성하기 위해 개발된 언어로, 가상 머신과 가비지 컬렉션을 도입함.
  - 자바의 성공은 가상 머신과 가비지 컬렉션 덕분이며, 프로그래머의 생산성을 크게 향상시킴.

### 14. 자바스크립트(JavaScript)
- **웹 브라우저의 프로그래밍 언어(1995)**: 
  - 웹 브라우저에서 실행되는 스크립트 언어로, 웹 어셈블리(Web Assembly)로 발전하여 더 빠른 실행을 가능하게 함.
  - 초기 자바스크립트는 동작 예측이 어려웠으나, 개선된 자바스크립트는 안정적이고 성숙한 언어로 여겨짐.

### 15. C#
- **닷넷 플랫폼을 위한 자바(2000)**: 
  - 자바의 불편한 제약을 따르지 않으면서 중요한 기능을 제공하기 위해 개발된 언어.
  - 함수형 프로그래밍 기능을 도입하여 코틀린 설계에 영향을 줌.

### 16. 스칼라(Scala)
- **규모 변경이 가능한 언어(2003)**: 
  - 자바 기상 머신에서 실행되도록 설계되었으며, 객체 지향과 함수형 프로그래밍을 혼합한 언어.
  - 자바와 상호 작용하면서도 더 나은 프로그래밍 환경을 제공하는 기능을 실험하는 플랫폼.

### 17. 그루비(Groovy)
- **동적인 JVM 언어(2007)**: 
  - 자바를 깔끔하게 다듬어 더 나은 프로그래밍 경험을 제공하는 언어.
  - 코틀린의 일부 연산자와 기능이 그루비에서 영감을 받음.

## 왜 코틀린인가?
- '**더 나은 자바**'가 되려는 의도에서 탄생했고 목표를 훨씬 뛰어넘게 진화함
- 다른 언어에서 가장 성공적으로 도움이 되는 기능만을 실용적으로 채택함
- 검증된 개념을 활용해 생선성을 극대화함

### 가독성
간결한 문법으로 복잡한 아이디어를 표현할 수 있음

### 도구
개발자 도구 전문 기업인 `JetBrains`가 만들어서 최상급 도구를 지원함

### 다중 패러다임
- 명령형(imperactive) 프로그래밍
- 함수형 프로그래밍
- 객체 지향 프로그래밍

### 다중 플랫폼
- **JMV**: JVM 바이트코드(.class 파일)로 컴파일하고, JMV에서 실행할 수 있음
- **Android**:달빅 실행 형식(.dex 파일)으로 컴파일 할 수 있음
- **JavaScript**: 웹 브라우저에서 실행할 수 있음
- **Native Binary**: 특정 플랫폼과 CPU에 맞는 기계어 코드를 생성할 수 있음

## 코틀린의 두 가지 특징
### 자바 상호 운용성
- 뛰어난 상호 운용성으로 마이그레이션에 필요한 자원을 아낄 수 있음

### 빈 값 표현 방식
- `Java`에서 rumtime에 발생하는 NPE(Null Pointer Exception)을 컴파일 시점에 잡아 Null 오류를 최소화 할 수 있음