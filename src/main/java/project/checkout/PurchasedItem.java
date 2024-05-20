package project.checkout;

import project.inventory.Goods;

import java.io.Serializable;
import java.math.BigDecimal;

public class PurchasedItem implements Serializable {
    private Goods goods;
    private int quantity;
    private BigDecimal totalPrice;

    public PurchasedItem(Goods goods, int quantity, BigDecimal totalPrice) {
        if (goods == null) {
            throw new IllegalArgumentException("Goods cannot be null");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        if (totalPrice == null || totalPrice.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Total price must be greater than zero");
        }
        this.goods = goods;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public Goods getGoods() {
        return goods;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "PurchasedItem{" +
                "goods=" + goods +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                '}';
    }
}