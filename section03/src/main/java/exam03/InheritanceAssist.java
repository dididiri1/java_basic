package exam03;

public class InheritanceAssist {

    public static void main(String[] args) {
        Shape shape = new Rectangle(); // up-casting
        Rectangle rect = (Rectangle) shape; // down-casting
    }
}