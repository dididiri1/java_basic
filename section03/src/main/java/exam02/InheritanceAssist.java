package exam02;

class Art {
    public Art() {
        System.out.println("Art 호출");
    }
}

class Drawing extends Art {
    public Drawing() {
        System.out.println("Drawing 호출");
    }
}

class Cartoon extends Drawing {
    public Cartoon() {
        System.out.println("Cartoon 호출");
    }
}

public class InheritanceAssist {

    public static void main(String[] args) {
        Cartoon cartoon = new Cartoon();
    }
}
