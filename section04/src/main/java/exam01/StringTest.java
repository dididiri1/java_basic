package exam01;

public class StringTest {

    public static void main(String[] args) {
        String str1 = "Java Programming";
        String str2 = new String("Java Programming");
        String str3 = "Java Programming";

        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
    }
}
