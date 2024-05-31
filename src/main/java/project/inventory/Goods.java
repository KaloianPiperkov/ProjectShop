//Food and non-food goods have different % overcharge, that is determined in the shop. If the expiry date is close,
//i.e. there are less than a given number of days to it, the selling price of the goods is decreased by given %.
//The number of the days to the expiration date and the decreasing % are different in each shop.
//Goods which expiry date is passes cannot be sold.
//Goods can be sold only if there is enough quantity of it in the shop.
// If the quantity is not enough, an appropriate exception has to be thrown.
// This exception has to show the quantity needed to sell the goods.


package project.inventory;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;


public class Goods extends GoodsSellingPriceCalculator implements Serializable {

    private long goods_id;
    private String goods_name;
    private BigDecimal goods_delivery_price;
    private Category category;
    private LocalDate goods_expiry_date;
    private int goods_quantity;
    private SellingPriceCalculation sellingPriceCalculator;



    public Goods(long goods_id, String goods_name, BigDecimal goods_delivery_price, Category category, LocalDate goods_expiry_date, int goods_quantity, SellingPriceCalculation sellingPriceCalculator) {
        if (goods_name == null || goods_name.isEmpty()) {
            throw new IllegalArgumentException("Goods name cannot be null or empty");
        }
        if (goods_delivery_price == null || goods_delivery_price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Goods delivery price cannot be null or negative");
        }
        if (category == null) {
            throw new IllegalArgumentException("Category cannot be null");
        }
        if (goods_expiry_date == null || goods_expiry_date.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Goods expiry date cannot be null or in the past");
        }
        if (goods_quantity < 0) {
            throw new IllegalArgumentException("Goods quantity cannot be negative");
        }
        this.goods_id = goods_id;
        this.goods_name = goods_name;
        this.goods_delivery_price = goods_delivery_price;
        this.category = category;
        this.goods_expiry_date = goods_expiry_date;
        this.goods_quantity = goods_quantity;
        this.sellingPriceCalculator = sellingPriceCalculator;
    }

    public long getId() {
        return goods_id;
    }

    public String getName() {
        return goods_name;
    }

    public BigDecimal getDelivery_price() {
        return goods_delivery_price;
    }

    public Category getCategory() {
        return category;
    }

    public LocalDate getExpiry_date() {
        return goods_expiry_date;
    }

    public int getQuantity() {
        return goods_quantity;
    }

    public BigDecimal calculateSellingPrice() {
        return sellingPriceCalculator.calculateSellingPrice(this);
    }

    public void setQuantity(int goods_quantity) {
        if (goods_quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        this.goods_quantity = goods_quantity;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goods_id=" + goods_id +
                ", goods_name='" + goods_name + '\'' +
                ", goods_delivery_price=" + goods_delivery_price +
                ", category=" + category +
                ", goods_expiry_date=" + goods_expiry_date +
                ", goods_quantity=" + goods_quantity +
                '}';
    }
}