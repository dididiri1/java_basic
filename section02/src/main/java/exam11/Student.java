package exam11;

public class Student {

    private static int nextId = 1;
    private int id;

    public void setId() {
        id = nextId;
        nextId ++;
    }

    public int getId() {
        return id;
    }

    public int getNextId() {
        return nextId;
    }

    public static void main(String[] args) {

    }
}