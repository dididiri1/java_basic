package exam11;

public class FinalExam {
    private final String message;

    public FinalExam() {
        this.message = "Final Message";
    }

    public final void showMessage() {
        System.out.println(message);
    }

    public void showMessage(final String message) {
        //message = "New Message!";
        //Cannot assign a value to final variable 'message'
        System.out.println(message);
    }
}
