public class Main {

    public static void main(String[] args) {
        Counter c = new Counter();
        two(c);
        int count = c.get();
        System.out.println(count);
    }

    private static void two(Counter c) {
        c.increment();
        c.increment();
    }
}

class Counter {
    private int state = 0;
    public void increment() {
        state ++;
    }
    public int get() {
        return state;
    }
}
