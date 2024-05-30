package project.checkout;

import project.cashier.Cashier;
import project.customer.Customer;
import project.customer.InsufficientFundsException;
import project.inventory.Goods;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CashDesk {
    private List<Receipt> receipts;

    public CashDesk(List<Receipt> receipts) {
        if (receipts == null) {
            throw new IllegalArgumentException("Receipts list cannot be null");
        }
        this.receipts = receipts;
    }

    public Receipt processPurchase(Cashier cashier, Customer customer, LinkedHashMap<Goods, Integer> purchaseMap) {

        if (cashier == null) {
            throw new IllegalArgumentException("Cashier cannot be null");
        }
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null");
        }
        if (purchaseMap == null) {
            throw new IllegalArgumentException("Purchase map cannot be null");
        }

        Receipt receipt = new Receipt();

        BigDecimal totalCost = receipt.getTotalValue();
        if(customer.getFunds().compareTo(totalCost) < 0){
            throw new InsufficientFundsException("Customer does not have enough money to make the purchase");
        }


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

    public List<Receipt> getReceipts() {
        return receipts;
    }
}