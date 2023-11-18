package exam05;

abstract class Shape {

    private String type;

    public Shape(){
        System.out.println("부모 초기화");
    }

    public Shape(String type) {
        this.type = type;
    }

    public abstract  void draw();
}

public class AbstractAssist extends Shape {

    @Override
    public void draw() {
        System.out.println("재정의!");
    }

}
