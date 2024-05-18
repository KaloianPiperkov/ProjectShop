package project.inventory;

import java.math.BigDecimal;

public interface SellingPriceCalculation {
    BigDecimal calculateSellingPrice(Goods goods);
}
