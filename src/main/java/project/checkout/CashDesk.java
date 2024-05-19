package project.checkout;

import project.cashier.Cashier;
import project.customer.AddingToCart;
import project.customer.Customer;
import project.inventory.Goods;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CashDesk {
    private List<Receipt> receipts;

    public CashDesk(List<Receipt> receipts) {
        this.receipts = receipts;
    }

    public Receipt processPurchase(Cashier cashier, Customer customer, Map<Goods, Integer> purchaseMap) {

        // Create a new receipt
        Receipt receipt = new Receipt();

        // Set cashier
        receipt.setCashier(cashier);

        // Set date and time
        receipt.setDateTime(LocalDateTime.now());

        // Populate the purchase list
        for (Map.Entry<Goods, Integer> entry : purchaseMap.entrySet()) {
            Goods goods = entry.getKey();
            int quantity = entry.getValue();
            BigDecimal totalPrice = goods.calculateSellingPrice().multiply(BigDecimal.valueOf(quantity));

            // Add the purchased item to the receipt
            receipt.addItem(goods, quantity, totalPrice);

        }

        // Calculate total value of the receipt
        receipt.calculateTotalValue();

        // Add the receipt to the list of receipts
        receipts.add(receipt);

        return receipt;
    }
}


