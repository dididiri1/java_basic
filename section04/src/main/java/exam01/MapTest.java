package exam01;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

    public static void main(String[] args) {
        Map<String, Customer> map = new HashMap<>();
        Customer kim = new Customer("kim@namoosori.io", "Kim");

        map.put(kim.getEmail(), kim);

        System.out.println(map);
    }
}
