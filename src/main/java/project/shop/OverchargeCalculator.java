package project.shop;

import java.io.Serializable;
import java.math.BigDecimal;
import project.inventory.Goods;
import project.inventory.Category;

public class OverchargeCalculator  implements Serializable {

    public BigDecimal calculateOverchargePercentage(Shop shop, Goods goods) {
        Category category = goods.getCategory();
        switch (category) {
            case FOOD:
                return shop.getFoodOverchargePercent();
            case NON_FOOD:
                return shop.getNonFoodOverchargePercent();
            default:
                return BigDecimal.ZERO;
        }
    }
}