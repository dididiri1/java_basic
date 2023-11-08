package exam11;

public class StaticExam {

    private static String staticMessage = "Static Message";

    private String instanceMessage = "instance Message";

    public void showInstanceMessage() {
        System.out.println(instanceMessage);
        System.out.println(staticMessage); // O
        StaticExam.showStaticMessage(); // O
    }

    public static void showStaticMessage() {
        System.out.println(staticMessage);
        // System.out.println(instanceMessage);  X
        // this.showStaticMessage();  X
        new StaticExam().showInstanceMessage(); // O
    }

}