package project.checkout;

import project.cashier.Cashier;
import project.inventory.Goods;
import project.shop.Shop;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Receipt implements Serializable {

    private static final long serialVersionUID = 1L;
    private static long nextId = 1;
    private long id_receipt;
    private Cashier cashier;
    private LocalDateTime date_and_time_of_creation;
    private List<PurchasedItem> purchasedItems = new ArrayList<>();
    private BigDecimal totalValue = BigDecimal.ZERO;
    private Shop shopName;

    public Receipt() {
        this.id_receipt = nextId++;
        this.date_and_time_of_creation = LocalDateTime.now();
        calculateTotalValue();
    }

    public void setCashier(Cashier cashier) {
        if (cashier == null) {
            throw new IllegalArgumentException("Cashier cannot be null");
        }
        this.cashier = cashier;
    }

    public void setDateTime(LocalDateTime now) {
        if (now == null) {
            throw new IllegalArgumentException("Date and time cannot be null");
        }
        this.date_and_time_of_creation = now;
    }

    public void setShop(Shop shop) {
        if (shop == null) {
            throw new IllegalArgumentException("Shop cannot be null");
        }
        this.shopName = shop;
    }

    public long getId() {
        return id_receipt;
    }

    public void addItem(Goods goods, int quantity, BigDecimal totalPrice) {
        if (goods == null) {
            throw new IllegalArgumentException("Goods cannot be null");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        if (totalPrice == null || totalPrice.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Total price must be greater than zero");
        }
        PurchasedItem item = new PurchasedItem(goods, quantity, totalPrice);
        purchasedItems.add(item);
        totalValue = totalValue.add(totalPrice);
    }

    public BigDecimal calculateTotalValue() {
        totalValue = purchasedItems.stream()
                .map(PurchasedItem::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return totalValue;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Shop Name: ").append(shopName.getShopName()).append("\n")
                .append("Receipt ID: ").append(id_receipt).append("\n")
                .append("Cashier: ").append(cashier.getName()).append("\n")
                .append("Date of Creation: ").append(date_and_time_of_creation).append("\n")
                .append("Purchased Items: \n");

        for (PurchasedItem item : purchasedItems) {
            sb.append("Goods Name: ").append(item.getGoods().getName())
                    .append(", Quantity: ").append(item.getQuantity()).append("\n")
                    .append("Total Price For Good: ").append(item.getGoods().calculateSellingPrice()
                            .multiply(BigDecimal.valueOf(item.getQuantity()))).append("\n");
        }

        sb.append("Total Value: ").append(totalValue).append("\n");

        return sb.toString();
    }


    public BigDecimal getTotalValue() {
        return totalValue;
    }
}