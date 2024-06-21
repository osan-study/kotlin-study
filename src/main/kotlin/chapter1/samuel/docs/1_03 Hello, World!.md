# 03 Hello, World!

## 문제소지가 있는 표현

### <span style="color: red;">문제의 소지가 있는 표현</span>
> println()은 파라미터를 하나만 받는데 오직 String 타입, 즉 문자열이다. 큰따옴표로 문자들을 감싸서 문자열로 만들 수 있다.  
> <span style="font-style: italic;"><b>40 page 의 내용</b></span>

### <span style="color: red;">내가 생각하는 올바른 표현</span>
> <span><b>println()은 파라미터를 하나만 받는데 어떤 타입이든 입력할 수 있고, 해당 입력을 String 값으로 변환하여 출력하는 함수이다.</b></span>

### 문제라고 생각한 이유
println() 함수는 오버로딩된 함수로  
파라미터를 하나만 받는 것은 맞으나, 여러 타입을 받아 처리하는 함수임

<span><b>Kotlin.io</b></span> 의 println 의 정의는 두번 째 코드블럭과 같음  
아래의 코드블럭과 같이 println 에 대한 정의가 <span><b>파라미터만 다른 형태로 정의(오버로딩)</b></span> 되어있음  
참고링크: [https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.io/println.html](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.io/println.html)

<span><b>System.<span style="color: indigo;">out</span>.println()</b></span> 의 println 함수는  
<span><b>PrintStream.java</b></span> 의 println() 메소드를 의미하며 세번 째 코드블럭과 같음  
(대부분의 타입은 <span><b>String.valueOf()</b></span> 로 입력 타입의 값을 String 으로 치환 후 출력)  

```kotlin
/***
 * atom1.main 함수는 프로그램의 진입점(Entry Point)
 * 괄호 안은 파라미터 목록
 * 중괄호 이후는 함수 본문
 */
fun atom1.main() {
    // 한줄 주석
    println("Hello, World!")
    /*
     여
     러
     줄
     
     주
     석
     */
}

== result
Hello, World!
```
```kotlin
package kotlin.io

@kotlin.internal.InlineOnly
public actual inline fun println(message: Any?) {
    System.out.println(message)
}

/** Prints the given [message] and the line separator to the standard output stream. */
@kotlin.internal.InlineOnly
public inline fun println(message: Int) {
    System.out.println(message)
}

/** Prints the given [message] and the line separator to the standard output stream. */
@kotlin.internal.InlineOnly
public inline fun println(message: Long) {
    System.out.println(message)
}

/** Prints the given [message] and the line separator to the standard output stream. */
@kotlin.internal.InlineOnly
public inline fun println(message: Byte) {
    System.out.println(message)
}

/** Prints the given [message] and the line separator to the standard output stream. */
@kotlin.internal.InlineOnly
public inline fun println(message: Short) {
    System.out.println(message)
}

/** Prints the given [message] and the line separator to the standard output stream. */
@kotlin.internal.InlineOnly
public inline fun println(message: Char) {
    System.out.println(message)
}

/** Prints the given [message] and the line separator to the standard output stream. */
@kotlin.internal.InlineOnly
public inline fun println(message: Boolean) {
    System.out.println(message)
}

/** Prints the given [message] and the line separator to the standard output stream. */
@kotlin.internal.InlineOnly
public inline fun println(message: Float) {
    System.out.println(message)
}

/** Prints the given [message] and the line separator to the standard output stream. */
@kotlin.internal.InlineOnly
public inline fun println(message: Double) {
    System.out.println(message)
}

/** Prints the given [message] and the line separator to the standard output stream. */
@kotlin.internal.InlineOnly
public inline fun println(message: CharArray) {
    System.out.println(message)
}

/** Prints the line separator to the standard output stream. */
@kotlin.internal.InlineOnly
public actual inline fun println() {
    System.out.println()
}
```
```java

// package java.io 의 PrintStream 클래스 
// int 형 값에 대한 println 예시만 가져옴
public void println(int x) {
    if (getClass() == PrintStream.class) {
        writeln(String.valueOf(x));
    } else {
        synchronized (this) {
            print(x);
            newLine();
        }
    }
}
```