package project.checkout;

import project.inventory.Goods;

import java.io.Serializable;

public class PurchasedItem implements Serializable {
    private Goods goods;
    private int quantity;
    private double totalPrice;

    public PurchasedItem(Goods goods, int quantity, double totalPrice) {
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

    public double getTotalPrice() {
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
