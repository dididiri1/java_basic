package exam01;

import java.awt.*;

class Shape {

    protected int x;
    protected int y;
    protected Color color;

    public void draw() {
        System.out.println("Drawing exam01.Shape~");
    }
}

public class Rectangle extends Shape {

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
