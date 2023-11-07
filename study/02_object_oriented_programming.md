# 자바 기초 강의 - 2-1강 객체지향 프로그래밍의 이해

## 2.1 객체지향 프로그래밍
- 프로그래밍 언어의 패러다임을 이해하는 과정은 해당 프로그램 언어를 익히고 사용하는데 매우 중요한 절차이다.
- 프로그래밍은 현실 세계의 특정 문제를 컴퓨터 세계를 통해 풀어가는 방법이라고 할 수 있다.
- 현실 세계의 문제를 기능 또는 구조위주의 관점으로 보고, 기능을 세분화하여 풀어가는 것을 절차지향이라고 한다.
- 객체지향은 문제를 데이터의 관점으로 보며, 데이터들의 상화 관계를 정의함으로써 해결함책을 찾아간다.

## 2.2 클래스(Class) 그리고 객체(Object)
- 자바 언어로 구현하는 프로그램은 다수의 클래스들로 이루어지며 이 클래스를 이용해 객체를 만들고 사용한다.
- 클래스를 정의한다는 것은 객체를 만들기 위한 과정이며 클래스는 객체에 대한 청사진 또는 템플릿이라 할 수 있다.
- 클래스로부터 만들어지는 객체를 인스턴스(instance) 혹은 인스턴스 객체(instance object)라고 한다.


## 2.3 클래스의 구성요소 
- 자바 프로그램의 기본인 클래스를 잘 정의하기 위해서는 클래스를 구성요소에 대한 이해가 필요하다.
- 클래스는 상태와 행위를 가지며 상태를 필드(Field), 행위를 메소드(Method)라고 한다.
- 클래스에는 필드와 메소드 외에 생성자(Constructor)라는 특수한 메소드도 반드시 하나 이상 갖는다.


![](https://github.com/dididiri1/java_basic/blob/main/study/images/02_01.png?raw=true)

# 자바 기초 강의 - 2-2강 클래스의 이해 - 필드의 정의

## 개요

- 클래스에 정의하는 속성은 특정한 값을 가지며, 객체의 속성 값은 해당 객체의 상태를 표현한다.
- 현실 세계의 객체는 다양하고 광범위한 속성들을 갖고 있기 때문에 정의하고자 하는 클래스의 특성을 잘 이해하고 해당  
  클래스의 핵심 속성들들 정의한다.
- 필드를 정의할 떄는 반드시 접근지정자(Access Modifier), 타입, 필드명을 명시한다.

![](https://github.com/dididiri1/java_basic/blob/main/study/images/02_02.png?raw=true)

## 변수의 유형
### 변수는 정의된 위체 따리 4가지의 유형으로 구분하며 각 유형에 따라 갖는 특성에 차이가 있다.
- 지역변수(Local variables)
- 매개변수(Parameter variables)
- 인스턴스 변수(Instance variables)
- 정적 변수(Class variables)

``` java
public class VariableTypes {
    
    /** 정적 변수 */
    public static int cassVar = 1;
    
    /** 인스턴스 변수 */
    private int instanceVar;
    
    /**
     * @param paramVar 매개변수
     */
    public static void main(String[] paramVar)  {
        // 지역변수
        int localVal = 10;
        
    }
    
}

```

## 자료형(Data Type)의 이해

### 정수형은 소수부가 없는 숫자를 나태나는 자료형이다.
- 자바는 데이터의 표현범위에 따라 4가지의 정수형을 제공한다.

|  자료형  |  메모리 크기  | 표현범위                              |  표현 범위(지수표현)  |
|:-----:|:--------:|----------------------------------------------|:-------------:|
| byte  |  1 바이트   | -128 ~ 127                                   |  -27 ~ 27-1   |
| short |  2 바이트   | -32,768 ~ 32,767                             | -215 ~ 215-1  |
|  int  |  4 바이트   | -2,147,483,648 ~ 2,147,483,647               | -231 ~ 231-1  |
| long  |  8 바이트   | -9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807 | -263 ~ 263-1  |

## 논리 자료형 (Boolean Type)
### 논리 자료형은 **참과 거짓**을 표현하는 자료형이다.
- true : 참을 표현하는 값
- false : 거짓을 표현하는 값
``` java
public class BooleanType {

    public static void main(String[] args) {
        boolean isTrue = true;
        boolean isFalse = false;
        System.out.println(isTrue);
        System.out.println(isFalse);
    }

}
```
``` console
true
false
```

## 상수 (Constants)
- 사용자 정의 상수는 변수를 선언하고 여게에 final 키워드를 붙이면 한번 초기화 후 그 값을 변경 할 수 없다.
``` java
final double PI = 3.14;
System.out.println("PI is " + PI);
```

## 참조 자료형 (Reference Type)
- 참조 자료형은 갖는 변수는 특정 객체의 참조 정보를 저장한다.
- 기본 데이터 타입(byte, short, int, long, float, double 등) 이외의 타입을 의미한다.
- 참조 자료형 변수는 4byte의 크기를 갖으며 인스턴스 객체에 접근할 수 있는 정보를 갖는다.
- 객체의 삭제는 객체가 더 이상 사용되지 않을 때 자바의 Garbage Collector에 의해 자동적으로 제거된다.

![](https://github.com/dididiri1/java_basic/blob/main/study/images/02_03.png?raw=true)


# 2.5 연산자(Operators)의 이해

## 대입연산자

| 연산자 | 예         | 의미             |
|:---:|:-----------:|:----------------:|
| +=  | num += 10 | num = num + 10 |
| -=  | num -= 10 | num = num - 10 |
| *=  | num *= 10 | num = num * 10 |
| /=  | num /= 10 | num = num / 10 |
| %=  | num %= 10 | num = num % 10 |

## 산술연산자
| 연산자 |  연산식   |
|:---:|:------:|
|  +  | 10 + 5 |
|  -  | 10 - 5 |
|  *  | 10 * 5 |
|  %  | 10 % 5 |

## 관계연산자
| 연산자 |   예    |      의미       |
|:---:|:------:|:-------------:|
| ==  | a == b |   a와 b가 같다    |
| !=  | a != b |  a와 b가 같지 않다  |
|  >  | a > b  |   a가 b보다 크다   |
| >=  | a >= b | a가 b보다 크거나 같다 |
|  <  | a < b  |   a가 b보다 작다   |
| <=  | a <= b | a가 b보다 작거나 같다 |

## 증감 연산자
- 변수에 저장된 값을 증가(++)시키거나 또는 감소(--) 시키는 단항 연산자이다.
- 연산자를 정의하는 위체에 따라 연산이 수행되는 시점이 다르게 적용된다.

|    연산자    |   예    |
|:---------:|:------:|
|  전위 연산자   |  ++a   |
|  후위 연산자   |  a++   |

## 논리 연산자
- 논리 연산을 수행하는 연산자로 이항 연산자인 AND (논리곱, &&), OR(논리합, ||) 연산자와  
  단항 연산자인 NOT(논리부정, !) 연산자가 있다. 
- 우선 순위는 NOT > AND > OR

## 비트 연산자(Shift)
- 정수형 피연산자에 대해 비트를 왼쪽, 혹은 오른쪽으로 이동시키는 연산자.

| 연산자 |   의미    |                의미                |
|:---:|:-------:|:--------------------------------:|
| >>  | 5 >> 2  |     5의 이진수표현에서 오른쪽으로 2칸 쉬프트      |
| <<  | 5 << 2  |      5의 이진수표현에서 왼쪽으로 2칸 쉬프트      |
| >>> | 5 >>> 2 | 5의 이진수표현에서 오른쪽으로 2칸 쉬프트(0으로 채워짐) |

## 삼항 연산자
- 삼항 연산자는 피연산자를 3개 갖는 연산자 이다.
- 조건의 참, 거짓 여부에 따라 서로 다른 수식을 실행함.

``` java
int x, y, z;
x = 10; y = 20;

z = ( x > y ? x : y);
System.out.println(z); //z : 20

z = ( y > x ? x : y);
System.out.println(z); // z : 10
``` 

## 형변환(casting) 연산자
### 암묵적 형 변환(Implicit Conversion)
- Java는 데이터가 손실되지 않거나, 손실이 제한적인 범위 내에서 암묵적으로 형을 변환한다.
- 자료형이 다른 변수에 값을 할당하는 경우
``` java
float f = 10;
```
- 자료형이 다른 값을 연산하는 경우
``` java
double d = 10.0 + 20;
``` 

### 명시적 형 변환(Explicit Conversion)
- 명시적으로 형 변환하는 것을 캐스팅(Casting)이라고 한다.
- 자동 형 변환 규칙에 위배되는 상황임에도 강제로 형 변환할 경우 데이터 손실의 위험이 있음.
``` java
int i1 = 20.5; // Error

int i2 = (int) 20.5; // 20
```

### Reference

- [자바 기초 - 나무소리](https://www.youtube.com/@namoosori/playlists)