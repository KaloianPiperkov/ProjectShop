package project.inventory;

import project.shop.OverchargeCalculator;
import project.shop.Shop;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

//class that calculates the selling price of the goods
public class GoodsSellingPriceCalculator implements SellingPriceCalculation, Serializable {
    private OverchargeCalculator overchargeCalculator;
    private Shop shop;
    private long daysUntilExpirationThreshold;

    public GoodsSellingPriceCalculator(OverchargeCalculator overchargeCalculator, Shop shop, long daysUntilExpirationThreshold) {
        if (overchargeCalculator == null) {
            throw new IllegalArgumentException("OverchargeCalculator cannot be null");
        }
        if (shop == null) {
            throw new IllegalArgumentException("Shop cannot be null");
        }
        this.overchargeCalculator = overchargeCalculator;
        this.shop = shop;
        this.daysUntilExpirationThreshold = daysUntilExpirationThreshold;
    }

    public GoodsSellingPriceCalculator() {
    }



    @Override
    public BigDecimal calculateSellingPrice(Goods goods) {
        if (goods == null) {
            throw new IllegalArgumentException("Goods cannot be null");
        }
        BigDecimal sellingPrice = BigDecimal.ZERO;

        // Getting the overcharge percentage for the specific category
        BigDecimal overchargePercent = overchargeCalculator.calculateOverchargePercentage(shop, goods);

        sellingPrice = goods.getDelivery_price().multiply(BigDecimal.ONE.add(overchargePercent.divide(BigDecimal.valueOf(100), 4, RoundingMode.HALF_UP)));

        long daysUntilExpiration = ChronoUnit.DAYS.between(LocalDate.now(), goods.getExpiry_date()); // Should be put in another method

        if (daysUntilExpiration > 0 && daysUntilExpiration <= daysUntilExpirationThreshold) {
            sellingPrice = sellingPrice.multiply(BigDecimal.ONE.subtract(overchargePercent.divide(BigDecimal.valueOf(100), 4, RoundingMode.HALF_UP)));
        }

        sellingPrice = sellingPrice.setScale(2, RoundingMode.HALF_UP); // Should be put in another method and used in shop too!!!

        return sellingPrice;
    }
}


