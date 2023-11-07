public class Customer {

    private String name;
    private int age;
    private String department;

    public Customer() {
        System.out.println("Customer() 생성자 호출");
    }
    public Customer(String name) {
        System.out.println("Customer(String name) 생성자 호출");
    }
    public Customer(String name, int age){
        System.out.println("Customer(String name, int age) 생성자 호출");
    }
}
