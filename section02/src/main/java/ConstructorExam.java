class Employee {

    private String id;
    private String name;

    public Employee() {}

    public Employee(String id){
        this.id = id;
        System.out.println("Employee(id) 호출");
    }

    public Employee(String id, String name){
        this(id);
        this.name = name;
        System.out.println("Employee(id, name) 호출");
    }

}

public class ConstructorExam {
    public static void main(String[] args) {
        Employee employee = new Employee("001", "춘식이");
        System.out.println(employee);
    }
}
