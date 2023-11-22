package exam05;

public interface MyInterface {

    public static final String MESSAGE = "User define constant";

    default void defaultMethod(){
        System.out.println("Default Method~~");
    }

    public static void staticMethod(){
        System.out.println("Static Method~~");
    }

    void play();
}
