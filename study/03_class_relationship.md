# 클래스의 관계

## 상속(Inheritance)
### 이해(1)
- 상속은 연관 있는 클래스들에 대해 공통적인 구성요소를 정의하고, 이를 대표하는 클래스를 정의하는 것을 의미한다.
- 상속 관계는 "is a" 관계를 의미하며 **extends** 키워드를 이용해 상속 관계를 정의한다.
- 상속 관계에서 상속을 받는 클래스를 sub class, derived class, extended class, child class라 한다.
- 상속 관계에서 상속을 제공하는 클래스를 super class, base class, parent class라 한다.

``` java
public class C extends P {
    
    // 필드 및 메소드 정의
}
``` 
### 이해(2)
- 자식 클래스는 부모클래스를 상속받아서 부모클래스의 모든 자원 속성, 메소드을 사용할 수 있다.
- 자식 클래스는 부모클래스에 없는 필드와 메소드를 정의하여 기능을 추가할 수 있다.
- 또한, 상위클래스에 정의된 메소드를 재정의하여 다르게 동작시킬 수 있다. (오버라이딩)

```java
public class Employee {

    private String name;
    private double salary;

    public Employee(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
```
```java
public class Manager extends exam01.Employee {

    private double bonus;
    
    public Manager(String name) { // 추가적인 필드 정의
        super(name);
    }
    
    public void setBonus(double bonus) { // 추가적인 메소드 정의
        this.bonus = bonus;
    }
    
    public double getSalary() { // 메소드 재정의 (Override)
        return super.getSalary() + bonus;
    }
}
``` 

### protected
- 상속 대상이 되는 부모 클래스에 **protected** 접근 지정자로 정의된 구성요소는 자식 클래스 구성요소가 된다.
- 자식 클래스는 부모 클래스의 protected, public 구성요소에 대해 **this** 접근이 가능하다.
- 즉, 상속 관계에서 자식 클래스는 부모 클래스에서 제공하는 구성요소들을 자신의 구성요소로 포함한다.
- 부모 클래스의 private 구성요소는 자식 클래스에서 직접 접근할 수 없다.

```java
import java.awt.*;

class Shape {

    protected int x;
    protected int y;
    protected Color color;
    
    public void draw() {
        System.out.println("Drawing exam01.Shape~");
    }
}

public class Rectangle extends exam01.Shape {

    private int width;
    private int height;
    
    public void resize(int width, int height) {
        this.width = width;
        this.height = height;
    }
    
    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
```

### 생성자 호출
- 상속 관계에서 자식 클래스를 인스턴스화 하면 부모 클래스의 객체도 인스턴스화가 진행된다.
- 자식 클래스의 객체가 인스턴스화 되기 위해서는 먼저 부모 클래스의 객체가 인스턴스화 되어야 한다.
- 따라서, 상속 구조에서 가장 상위의 부모 클래스부터 차례로 인스턴스화가 진행된다.

```java
class Art {
    public Art() {
        System.out.println("Art 호출");
    }
}

class Drawing extends Art {
    public Drawing() {
        System.out.println("Drawing 호출");
    }
}

class Cartoon extends Drawing {
    public Cartoon() {
        System.out.println("Cartoon 호출");
    }
}

public class InheritanceAssist {

    public static void main(String[] args) {
        Cartoon cartoon = new Cartoon();
    }
}
```

``` console
Art 호출
Drawing 호출
Cartoon 호출
```

### super()
- super() 생성자는 자식 클래스에서 명시적으로 부모클래스의 생성자를 호출할 수 있도록 하는 방법이다.
- 상속 관계에서 부모 클래스의 생성자 호출을 외부에서 명시적으로 지정할 수 없다.
- 자바는 자식 클래스의 객체가 인스턴스화 될 때 기본적으로 부모 클래스의 디폴트 생성자를 호출한다.
- 부모 클래스에 디폴트 생성자가 정의되어 있지 않으며 자식 클래스는 명시적으로 부모 클래스의 생성자를 호출해야 한다.

```java
package exam02;

class Employee {
    
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    // public Employee() {} (1)
}
public class Developer extends Employee{
    
    private double salary;

    // (1) 디폴트 생성자가 정의되어 있지 않으며 명시적으로 부모 클래스 생성 호출해야 함.
    public Developer(String name) {
        super(name);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
```

## 메소드 재정의(overriding)

### 개요
- 메소드 재정의(overriding)는 부모 클래스의 메소드를 자식 클래스가 확장하거나 다시 정의하는 것을 의미한다.
- 메소드 재정의를 구현하는 방법은 부모 클래스로부터 상속받은 **메소드의 반환타입, 메소드명, 파라미터를 동일하게** 하여  
  자식 클래스에서 정의한다.
- 자식 클래스가 부모 클래스의 메소드를 재정의 할 때 접근 지정자의 범위는 **넓거나 같아야** 한다.


| 부모 클래스           |           자식 클래스           |
|:-----------------|:--------------------------:|
| private          |           재정의 불가           |
| protected        |     protected, public      |
| package(default) | package, protected, public |
| public           |           public          |

```java
class Shape {
    
    public void draw(){
        System.out.println("Drawing Shape~");
    }
}

public class Rectangle extends Shape{

    @Override
    public void draw() {
        System.out.println("Drawing Rectangle~");
    }
}
```

### super
- 메소드 재정의는 부모 클래스로부터 상속 받은 기능을 새롭게 변경하거나 확장하기 위해서 입니다.
- 자식 클래스에서 상속 받은 메소드의 기능을 확장하기 위해서는 부모 클래스의 메소드에 대한 호출이 필요하다.
- 자식 클래스가 부모 클래스의 구성 요소에 접근하기 위해서는 super 키워드를 이용한다.

```java
class Shape {
    
    public void draw(){
        System.out.println("Drawing Shape~");
    }
}

public class Rectangle extends Shape{

    @Override
    public void draw() {
        super.draw();
        System.out.println("Drawing Rectangle~");
    }

    public static void main(String[] args) {
        Shape shape = new Shape();
        shape.draw();

        System.out.println();

        Shape rect = new Rectangle();
      rect.draw();
    }
}
```

``` console
Drawing Shape~

Drawing Shape~
Drawing Rectangle~
```

## 객체간 타입 형변화
### Strongly typed language
- Strongly typed language 개념은 데이터의 타입을 미리 정의하고 사용 하고, 한번 정의된 데이터 타입은 프로그램 종료 까지  
  변하지 않는 것을 의미한다.
- 이 개념은 프로그램 개발에 있어 명확함과 구체성을 제공하며 많은 프로그램 언어들이 적용하고 있다.
- 다만, 프로그램의 유연성 제약이라는 단점을 갖고 있으며 반대의 개념이 Loosely typed language 이다.

``` java
int x = 10; // assign
int y = 20; // assign

public void sum(int x, int y) {
    ...
}
```

- 자바에서 예외적으로 Strongly typed language가 적용되지 않는 경우가 있다.
- 상속 관계에서 자식 클래스가 부모 클래스 타입으로 참조되는 것이 허용되며 이를 uo-casting이라고 한다.
- 한번 부모 클래 타입의 클래스로 참조가 이러우진 이후 다시 자식 클래스로 참조하는 것을 down-casting이라고 한다.

```java
public class Shape {

    public void draw(){
        System.out.println("Drawing Shape~");
    }
}
``` 

```java
public class Rectangle extends Shape{

    @Override
    public void draw() {
        super.draw();
        System.out.println("Drawing Rectangle~");
    }
}
```
```java
public class Ellipse extends Shape{

    @Override
    public void draw() {
        System.out.println("Drawing Ellipse~");
    }
}
```
```java
public class Line extends Shape{

    @Override
    public void draw() {
        System.out.println("Drawing Line~");
    }
}
```
```java
public class InheritanceAssist {

    public static void main(String[] args) {
        Shape shape = new Rectangle(); // up-casting
        Rectangle rect = (Rectangle) shape; // down-casting
    }
}
```

## 3.7 Object 클래스

### 개요
- Object 클래스는 모든 자바 클래스가 상속하는 최상위 클래스 이다.
- Object 클래스는 모두 11개의 메소드를 정의하고 있으며 이 메소드들은 자바의 모든 클래스가 갖는 기능이다.
- 자바의 모든 클래스가 상속 받아 갖는 Object 클래스 메소드에 대한 목적과 기능을 이해하는 것이 중요하다.
- Object 클래스를 통해 상속 받는 메소드의 의미를 이해해야 그 의미에 맞게 재정의 할 수 있다.

``` java
public class EmptyClass {
    
}
```
``` java
public vlass ObjectExam {
    
    public static void main(String[] args) {
        EmptyClass empty = new EmptyClass();
        empty.toString();
        empty.hashCode();
    }
    
}
```

### toString 메소드
- toString 메소드는 해당 클래스에 대한 설명을 문자열 타입으로 반환하는 메소드 이다.
- 자바의 모든 클래스는 스스로에 대한 정보를 읽기 쉬운 형태로 제공 할 수 있으며 이 기능이 toString() 메소드 이다.
- 클래스를 정의할 때 그 클래스를 나타내는 주요 정보를 이용해 toString() 메소드를 재정의 한다.

``` java
public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Name:" + name + ", " + "Age:" + age;
    }
}
```
``` java
public class ObjectExam {

    public static void main(String[] args) {
        Person person = new Person("Kim", 25);
        System.out.println(person.toString());
    }
}
``` 

``` console
Name:Kim, Age:25
```


![](https://github.com/dididiri1/java_basic/blob/main/study/images/03_01.png?raw=true)
