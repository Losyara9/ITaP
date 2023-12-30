import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        HashTable<String, Order> orders = new HashTable<>(3);

        System.out.println(orders.isEmpty());

        orders.put("1", new Order("02.11.23", "keybord, mouse", "delivered"));

        System.out.println(orders.get("1"));
        System.out.println(orders.size());

        orders.get("1").setStatus("on the way");
        System.out.println(orders.get("1"));

        orders.put("2", new Order("02.10.23", "fridge", "delivered"));
        orders.put("3", new Order("01.11.23", "mask", "delivered"));
        orders.put("3", new Order("01.11.23", "mask", "on the way"));

        System.out.println(Arrays.toString(orders.view()));

        for (char i = 1; i <= 200; i++) {
            if (String.valueOf(i).hashCode() % 3 == "1".hashCode() % 3) {
                System.out.println(String.valueOf(i));

           }
      }
    }
}
