package exam01;

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
