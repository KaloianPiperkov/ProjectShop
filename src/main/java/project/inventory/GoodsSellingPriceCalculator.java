package project.inventory;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class GoodsSellingPriceCalculator implements SellingPriceCalculation  {


    @Override
    public double calcualteSellingPrice(Goods goods) {
        double selling_price = 0;
        //getting the overcharge percentage for the specific category
        double overcharge_percent = (goods.getCategory() == Category.FOOD) ? Category.FOOD.getDefaultOverchargePercent() : Category.NON_FOOD.getDefaultOverchargePercent();

        selling_price = goods.getDelivery_price() * (1 + (overcharge_percent / 100));


        long days_until_expiration = ChronoUnit.DAYS.between(LocalDate.now(), goods.getExpiry_date());        //should be put in another method

        if (days_until_expiration > 0 && days_until_expiration <= 3) { // Considered close to expiration if less than or equal to 3 days left
            selling_price *= (1 - goods.getCategory().getDefaultOverchargePercent() / 100);

        }

        selling_price = Math.round(selling_price * 100.0) / 100.0; //should be put in another method and used in shop too!!!

        return selling_price;
    }
}

