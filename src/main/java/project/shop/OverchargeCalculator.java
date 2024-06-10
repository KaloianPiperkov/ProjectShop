package project.shop;

import java.io.Serializable;
import java.math.BigDecimal;
import project.inventory.Goods;
import project.inventory.Category;

//class that calculates the overcharge percentage
public class OverchargeCalculator  implements Serializable {


    //the calculating is based on the category of the food for each shop
    public BigDecimal calculateOverchargePercentage(Shop shop, Goods goods) {
        if (shop == null) {
            throw new IllegalArgumentException("Shop cannot be null");
        }
        if (goods == null) {
            throw new IllegalArgumentException("Goods cannot be null");
        }
        Category category = goods.getCategory();
        if (category == null) {
            throw new IllegalArgumentException("Goods category cannot be null");
        }
        switch (category) {
            case FOOD:
                BigDecimal foodOverchargePercent = shop.getFoodOverchargePercent();
                if (foodOverchargePercent == null) {
                    throw new IllegalArgumentException("Food overcharge percent cannot be null");
                }
                return foodOverchargePercent;
            case NON_FOOD:
                BigDecimal nonFoodOverchargePercent = shop.getNonFoodOverchargePercent();
                if (nonFoodOverchargePercent == null) {
                    throw new IllegalArgumentException("Non-food overcharge percent cannot be null");
                }
                return nonFoodOverchargePercent;
            default:
                return BigDecimal.ZERO;
        }
    }
}