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