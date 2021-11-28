package main.java.promotionengine;



import main.java.promotionengine.daos.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TotalPrice {

    public TotalPrice() {
    }

    public Integer getTotalPrice(Map<String, Integer> input){
        Integer totalPrice = 0;

        Map<Product, Integer> productQuantityMap  = getProductQuantityMap(input);

        //verifying A&B promotions
        for (Map.Entry<Product, Integer> productQuantity: productQuantityMap.entrySet()) {
            switch (productQuantity.getKey().getName()){
            case "A":
                totalPrice+=(((productQuantity.getValue()/3)*130)+((productQuantity.getValue()%3)*productQuantity.getKey().getPrice()));
                break;
                case "B":
                totalPrice+=(((productQuantity.getValue()/2)*45)+((productQuantity.getValue()%2)*productQuantity.getKey().getPrice()));
                break;
                case "C":
                case "D":
                    totalPrice+=(productQuantity.getValue()*productQuantity.getKey().getPrice());
                    break;
            }
        }
        //verifying C&D Promotions
        if(input.containsKey("C")&&input.containsKey("D")){
            Integer countC = input.get("C");
            Integer countD = input.get("D");

            totalPrice-= (countC>countD ? (countD)*5 : (countC)*5);
        }


        return totalPrice;
    }

    private Map getProductQuantityMap(Map<String, Integer> input){
        List<Product> products = getProductList();
        Map<Product, Integer> productQuantityMap = new HashMap<>();

        for (String productId: input.keySet()) {
            List<Product> product = products.stream().filter(product1  -> product1.getName().equals(productId)).collect(Collectors.toList());
            productQuantityMap.put(product.get(0), input.get(productId));
        }
        return productQuantityMap;
    }


    public List getProductList(){
        Product A = new Product("A",50);
        Product B = new Product("B", 30);
        Product C = new Product( "C",20);
        Product D = new Product( "D", 15);

        List<Product> list = new ArrayList<>();
        list.add(A);
        list.add(B);
        list.add(C);
        list.add(D);

        return list;

    }
}
