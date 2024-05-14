//The receipt has: id, cashier that creates it, date and time, list of goods with quantity and price,
// total value of all the sold goods, that the client has to pay.
//It is necessary to keep the total number of the created receipts and the total value of all the sold goods.
// When a receipt is created it has to be saved in a file. The name of the file has to be the id of the receipt.
// The information in the files have to be read.

package project.checkout;

import project.cashier.Cashier;
import project.customer.AddingToCart;
import project.inventory.Goods;

import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private long id_receipt;
    private Cashier cashier; //the cashier that creates it;
    private LocalDateTime date_and_time_of_creation;

    private AddingToCart addingToCart;

    private List<PurchasedItem> purchasedItems = new ArrayList<>();
    private double totalValue = 0.0;

    public void setCashier(Cashier cashier) {
        this.cashier = cashier;
    }

    public void addItem(Goods goods, int quantity, double totalPrice) {
        PurchasedItem item = new PurchasedItem(goods, quantity, totalPrice);
        purchasedItems.add(item);
        totalValue += totalPrice;
    }

    public void calculateTotalValue() {
        totalValue = purchasedItems.stream()
                .mapToDouble(PurchasedItem::getTotalPrice)
                .sum();
    }

    public void setDateTime(LocalDateTime now) {
        this.date_and_time_of_creation = now;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "id_receipt=" + id_receipt +
                ", cashier=" + cashier +
                ", date_and_time_of_creation=" + date_and_time_of_creation +
                ", addingToCart=" + addingToCart +
                ", purchasedItems=" + purchasedItems +
                ", totalValue=" + totalValue +
                '}';
    }


    //when the receipt is created it need to be stored in a file!

}

