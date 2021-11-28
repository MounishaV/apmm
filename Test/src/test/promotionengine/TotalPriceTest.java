package promotionengine;

import main.java.promotionengine.TotalPrice;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TotalPriceTest {

    TotalPrice tp = new TotalPrice();
    Map<String, Integer> totUserInput ;


    @Test
    public void getTotalPriceWhenListIsEmpty(){
        totUserInput = new HashMap<>();
        int total = tp.getTotalPrice(totUserInput);
        Assert.assertEquals(total,0);
    }

    @Test
    public void getTotalPriceForThreeProducts(){
        totUserInput = new HashMap<>();
        totUserInput.put("A",4);
        totUserInput.put("B",5);
        totUserInput.put("C",1);
        int total = tp.getTotalPrice(totUserInput);
        Assert.assertEquals(total,320);
    }

    @Test
    public void getTotalPriceForAllProducts(){
        totUserInput = new HashMap<>();
        totUserInput.put("A",4);
        totUserInput.put("B",5);
        totUserInput.put("C",1);
        totUserInput.put("D",1);
        int total = tp.getTotalPrice(totUserInput);
        Assert.assertEquals(total,330);
    }

    @Test
    public void getTotalPriceUnequalCAndD(){
        totUserInput = new HashMap<>();
        totUserInput.put("A",4);
        totUserInput.put("B",5);
        totUserInput.put("C",1);
        totUserInput.put("D",2);
        int total = tp.getTotalPrice(totUserInput);
        Assert.assertEquals(total,345);
    }

    @Test
    public void getTotalPriceLessAAndB(){
        totUserInput = new HashMap<>();
        totUserInput.put("A",1);
        totUserInput.put("B",1);
        totUserInput.put("C",1);
        totUserInput.put("D",2);
        int total = tp.getTotalPrice(totUserInput);
        Assert.assertEquals(total,125);
    }


}

