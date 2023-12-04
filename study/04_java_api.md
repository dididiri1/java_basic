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


### 문자열 클래스 - StringBuilder, StringBuffer 클래스의 차이
- StringBuilder 클래스와 StringBuffer 클래스의 유일한 차이는 동기화 처리 여부이다.
- StringBuffer 클래스는 멀티스레드(Multi Thread) 프로그램에서 데이터에 대한 동기화 문제가 발생하지 않도록 대두분의  
  메소드에서 동기화 처리를 하고 있다.
- 이런 동기화 처리 과정은 성능에 영향을 주기 때문에 단일스레드(Single Thread) 프로그램에서는 StringBuilder 클래스를 사용한다.

### 문자열 클래스 - + 연산자
- 자바의 + 연산자는 피연산자 문자열일 경우 두 피연산자을 문자열로 연결해 주는 기능을 갖고 있다.
- 문자열의 연결은 String 클래스의 concat(), StringBuilder 클래스의 append()와 동일한 기능이다.
- java 8까지 문자열에 대한 + 연산은 StringBuilder 클스의 append() 기능을 이용해 수행한다.
- java 9부터 StringConcatFactory라는 새로운 클래스의 기능을 이용해 문자열에 대한 + 연산을 진행한다.

``` java
String str = new String("Java");
str = str.concat("Programming");
str = str + "Programming";
```

### Wrapper 클래스(1/2) - Wrapper 클래스의 이해
- 자바프로그램에서 관리하는 데이터의 기본 단위는 객체이다.
- 자바에서는 int, double 등과 같은 기본 데이터 타입(Primitive Data Type)들은 객체로 관리 할 수 있도록 하는 클래스들을  
  제공하며 이 클래스들을 Wrapper 클래스라고 한다.
- Wrapper 클래스들은 기본 데이터 타입에 대한 객체화와 함께 다양한 기능들을 정의하고 있다.



| Primitive Type           |           Wrapper Class           |
|:-----------------|:--------------------------:|
| boolean          |           Boolean           |
| byte          |           Byte           |
| short          |           Short           |
| int          |           Integer           |
| char          |           Character           |
| long          |           Long           |
| float          |           Float           |
| double          |           Double           |


### Wrapper 클래스(2/2) - Auto Boxing, Unboxing
- 기본 데이터 타입을 Wrapper 클래스로 감싸거나 Wrapper 클래스가 갖고 있는 기본 데이터 타입을 다시 꺼내는 과정은  
  Auto Boxing, Unboxing 기능을 통해 손쉽게 구현할 수 있다.
``` java
Integer intWrap = Integer.valueOf(10);
int number = intWrap.intValue();

Integer intWrap = 10; // Auto Boxing
int number = intWrap; // Unboxing
``` 

- Wrapper 이외에도 실수 계산과 같은 오차가 발생할 수 있는 연산에는 BigInterger, BigDecimal과 같은 클래스의 기능을 사용한다.
``` java
double da = 3.14;
System.out.println(da + 1); // 4.140000000000001

System.out.println(BigDecimal.valueOf(3.14).add(BigDecimal.valueOf(1))); // 4.14
```

### Java Collection Framework의 이해(1/3)