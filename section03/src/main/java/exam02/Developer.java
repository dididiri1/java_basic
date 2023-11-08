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
