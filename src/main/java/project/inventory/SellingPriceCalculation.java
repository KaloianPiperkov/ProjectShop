package project.inventory;

import java.math.BigDecimal;

//interface that defines a method for calculating the selling price of the goods
public interface SellingPriceCalculation {
    BigDecimal calculateSellingPrice(Goods goods);
}
