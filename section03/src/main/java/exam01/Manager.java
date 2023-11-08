package exam01;

public class Manager extends Employee {

    private double bonus;

    public Manager(String name) { // 추가적인 필드 정의
        super(name);
    }

    public void setBonus(double bonus) { // 추가적인 메소드 정의
        this.bonus = bonus;
    }

    public double getSalary() { // 메소드 재정의 (Override)
        return super.getSalary() + bonus;
    }
}
