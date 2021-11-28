package main.java.promotionengine;



import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Map<String, Integer> totUserInput = new HashMap<>();

        TotalPrice tp = new TotalPrice();


        while(true) {
            System.out.println("Enter a product to buy or 0 to Exit:");
            System.out.println("A - 50\nB - 30\nC - 20\nD -15");

            Scanner s = new Scanner(System.in);
            String productId = s.next();

            if(productId.equals("0")) break;
            System.out.println("Enter the quantity:");
            Integer quantity = s.nextInt();

            totUserInput.put(productId,totUserInput.getOrDefault(productId, 0)+quantity);

        }

        System.out.println("Total Price: "+ tp.getTotalPrice(totUserInput));
    }


}
