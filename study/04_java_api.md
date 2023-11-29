# 4. Java API

> 4.1 문자열 클래스
> 4.2 Wrapper 클래스
> 4.3 예외처리
> 4.4 Java Collection Framework의 이해
> 4.5 제네릭의 이해
> 4.6 Collection 인터페이스
> 4.7 List 인터페이스
> 4.8 Set 인터페이스
> 4.9 Map 인터페이스
> 4.10 Iterator 인터페이스

## 4.1 문자열 클래스

### 문자열 클래스 - String 클래스
- 자바는 문자열 관리하기 위한 여러 클래스를 제공하고 있으며 대표적인 클래스가 바로 String 클래스 이다.
- String 클래스는 문자열 제어를 위한 다수의 메소드를 정의하고 있다.
- 프로그램내에 빈번하게 발생하는 문자열 처리를 위해서는 String 클래스의 주요 기능들에 대한 이해와 특성에 대한  
  이해가 필요하다.

```java
public class StringTest {

    public static void main(String[] args) {
        // Creating Strings
        String str1 = "Java Programming";
        String str2 = new String("Java Programming");
        char[] charAry = {'J', 'A', 'V', 'A'};
        String str3 = new String(charAry);

        // String's Methods
        System.out.println(str1.length());
        System.out.println(str1.toUpperCase());
        System.out.println(str2);
        System.out.println(str3);
    }
}
``` 

``` console
16
JAVA PROGRAMMING
Java Programming
JAVA
```

### 문자열 클래스 - String 클래스 문자 체계
- String 클래스는 내부적으로 byte[]을 이용해 문자열을 관리한다. (java 8까지 char[])
- 자바의 문자형 체계는 UTF-16 코드 체계를 채댁하고 있으며 이는 2byte 기반의 문자 체계이다.
- 1byte로 표현 가능한 문자의 경우 남은 1byte에 대한 메모리 낭비가 발상하게 되면 이를 개선하기 위해 java 9부터  
  Compact Strings 개념이 도입이 된다.

### 문자열 클래스 - String 클래스 특징
- String 클래스의 기능을 사용할 때 String 클래스의 특징을 이해하고 사용하는 것이 필요함.
- String 객체의 초기화 방식은 **리터럴**을 이용한 방식과 **객체 생성**을 통한 초기화 방식 2가지 이다.
- String은 불변(immutability)의 특성을 갖고 있으며 내부적으로 String Pool을 통해 문자열 상수를 관리한다.
- 문자열의 변경이 빈번한 로직에서 String의 사용은 메모리 누수(memory leak)이 발생할 수 있기 떄문에 주의해야한다.

```java
public class StringTest {

    public static void main(String[] args) {
        String str1 = "Java Programming";
        String str2 = new String("Java Programming");
        String str3 = "Java Programming";
    
        System.out.println(str1 == str2);
        System.out.println(str1 == str3);

        System.out.println();
  
        String str = "Java";
        str = str.concat(" Programming");
        System.out.println(str.toString());
        
    }
}
```
``` console
false
true

Java Programming
```

### 문자열 클래스 - StringBuilder, StringBuffer 클래스
- StringBuilder와 StringBuffer 클래스는 동기화(syschronized) 특성을 제외하고 모든 메소드의 기능이 동일하다.
- 이 두 클래스는 String 클래스와 달리 가변(mutable)의 특성을 갖고 있다.
- StringBuilder, StringBuffer 두 클래스는 AbstractStringBuilder 추상 클래스를 상속하고 있으며 이 클래스는 내부 적으로  
  문자열 관리하기 위한 byte[]과 배열의 길이를 계산히기 위한 count 속성을 갖고 있다.
- 