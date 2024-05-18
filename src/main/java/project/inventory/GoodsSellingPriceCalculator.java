package project.inventory;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class GoodsSellingPriceCalculator implements SellingPriceCalculation, Serializable {
        @Override
        public BigDecimal calculateSellingPrice(Goods goods) {
            BigDecimal sellingPrice = BigDecimal.ZERO;

            // Getting the overcharge percentage for the specific category
            BigDecimal overchargePercent = goods.getCategory().getDefaultOverchargePercent();

            sellingPrice = goods.getDelivery_price().multiply(BigDecimal.ONE.add(overchargePercent.divide(BigDecimal.valueOf(100), 4, RoundingMode.HALF_UP)));

            long daysUntilExpiration = ChronoUnit.DAYS.between(LocalDate.now(), goods.getExpiry_date()); // Should be put in another method

            if (daysUntilExpiration > 0 && daysUntilExpiration <= 3) { // Considered close to expiration if less than or equal to 3 days left
                sellingPrice = sellingPrice.multiply(BigDecimal.ONE.subtract(overchargePercent.divide(BigDecimal.valueOf(100), 4, RoundingMode.HALF_UP)));
            }

            sellingPrice = sellingPrice.setScale(2, RoundingMode.HALF_UP); // Should be put in another method and used in shop too!!!

            return sellingPrice;
        }
    }

