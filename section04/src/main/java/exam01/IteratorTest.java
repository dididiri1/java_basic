package exam01;

import java.util.*;

public class IteratorTest {

    public static void main(String[] args) {

        Iterator<Customer> iterator = null;

        List<Customer> list = new ArrayList<>();
        list.add(new Customer("kim@namoosori.io", "Kim"));
        list.add(new Customer("lee@namoosori.io", "Lee"));
        list.add(new Customer("park@namoosori.io", "Park"));

        iterator = list.iterator();
        while (iterator.hasNext()) {
            Customer customer = iterator.next();
            System.out.println("customer = " + customer);
        }

        System.out.println();

        Map<String, Customer> map = new HashMap();
        map.put("kim@namoosori.io", new Customer("kim@namoosori.io", "Kim"));
        map.put("lee@namoosori.io", new Customer("lee@namoosori.io", "Lee"));
        map.put("park@namoosori.io", new Customer("park@namoosori.io", "Park"));

        Collection<Customer> coll = map.values();
        iterator = coll.iterator();
        while(iterator.hasNext()){
            Customer customer = iterator.next();
            System.out.println("customer = " + customer);
        }
    }
}
