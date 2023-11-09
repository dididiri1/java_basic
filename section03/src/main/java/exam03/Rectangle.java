package exam03;

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
