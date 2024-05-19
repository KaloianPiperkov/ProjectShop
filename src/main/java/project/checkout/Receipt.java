//The receipt has: id, cashier that creates it, date and time, list of goods with quantity and price,
// total value of all the sold goods, that the client has to pay.
//It is necessary to keep the total number of the created receipts and the total value of all the sold goods.
// When a receipt is created it has to be saved in a file. The name of the file has to be the id of the receipt.
// The information in the files have to be read.

package project.checkout;

import project.cashier.Cashier;
import project.customer.AddingToCart;
import project.inventory.Goods;
import project.shop.Shop;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Receipt implements Serializable {

    private static final long serialVersionUID = 1L; // Serial version UID for version control
    private static long nextId = 1; // Static variable to generate unique receipt IDs
    private long id_receipt;
    private Cashier cashier; //the cashier that creates it;
    private LocalDateTime date_and_time_of_creation;
    //private AddingToCart addingToCart;
    private List<PurchasedItem> purchasedItems = new ArrayList<>();
    private BigDecimal totalValue = BigDecimal.ZERO;
    private Shop shopName;
    public Receipt() {
        this.id_receipt = nextId++;
        this.date_and_time_of_creation = LocalDateTime.now();
        calculateTotalValue();
    }

    public void setCashier(Cashier cashier) {
        this.cashier = cashier;
    }
    public void setDateTime(LocalDateTime now) {
        this.date_and_time_of_creation = now;
    }
    public void setShop(Shop shop) {
        this.shopName = shop;
    }
    public long getId() {
        return id_receipt;
    }

    public void addItem(Goods goods, int quantity, BigDecimal totalPrice) {
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
        sb.append("Shop Name: ").append(shopName.getShop_name()).append("\n")
                .append("Receipt ID: ").append(id_receipt).append("\n")
                .append("Cashier: ").append(cashier.getName()).append("\n") // assuming you have a getName method in Cashier
                .append("Date of Creation: ").append(date_and_time_of_creation).append("\n")
                .append("Purchased Items: \n");

        for (PurchasedItem item : purchasedItems) {
            sb.append("Goods Name: ").append(item.getGoods().getName()) // assuming you have a getName method in Goods
                    .append(", Quantity: ").append(item.getQuantity()).append("\n");
        }

        sb.append("Total Value: ").append(totalValue).append("\n");

        return sb.toString();
    }


}

