package project.inventory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Random;

public class GoodsGenerator {
    private final Random random = new Random();
    private final SellingPriceCalculation sellingPriceCalculator;

    public GoodsGenerator(SellingPriceCalculation sellingPriceCalculator) {
        this.sellingPriceCalculator = sellingPriceCalculator;
    }

    public Goods generateGoods() {
        int id = random.nextInt(1000);
        String name = "goods" + id;
        BigDecimal purchasePrice = BigDecimal.valueOf(random.nextInt(50));
        Category category = Category.values()[random.nextInt(Category.values().length)];
        LocalDate expirationDate = LocalDate.now().plusDays(random.nextInt(365));
        int quantity = random.nextInt(200);
        return new Goods(id, name, purchasePrice, category, expirationDate, quantity, sellingPriceCalculator);
    }
}
