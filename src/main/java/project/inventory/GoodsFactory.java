package project.inventory;

import java.math.BigDecimal;
import java.time.LocalDate;

public class GoodsFactory {
        public static Goods createGoods(long goods_id, String goods_name, BigDecimal goods_delivery_price, Category category, LocalDate goods_expiry_date, int goods_quantity, SellingPriceCalculation sellingPriceCalculator) {
            return new Goods(goods_id, goods_name, goods_delivery_price, category, goods_expiry_date, goods_quantity, sellingPriceCalculator);
        }
    }

