
class Calculator {
    public int sum(int x, int y){
        return x + y;
    }
    public int sum(int x, int y, int z){
        return x + y + z;
    }
    public double sum(double x, double y){
        return x + y;
    }
}
public class OverloadingExam {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.sum(10, 20)); //30
        System.out.println(calc.sum(10, 20, 30)); //60
        System.out.println(calc.sum(10.0, 20.0)); //30.0
    }
}