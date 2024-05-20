package project.shop;

import project.checkout.Receipt;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class ShopIncome implements CalculatingTotalIncome, Serializable {

    private List<Receipt> receipts;
    private BigDecimal total_income;


    public ShopIncome(List<Receipt> receipts){
        if (receipts == null) {
            throw new IllegalArgumentException("Receipts list cannot be null");
        }
        this.receipts = receipts;
        this.total_income = calculateTotalIncome();
    }

    @Override
    public BigDecimal calculateTotalIncome() {
        total_income = BigDecimal.ZERO; // Reset totalIncome to zero

//        if (receipts == null || receipts.isEmpty()) {
//            System.out.println("No receipts to calculate income from.");
//            return total_income;
//        }

        for (Receipt receipt : receipts) {
            BigDecimal receiptTotalValue = receipt.calculateTotalValue();
            //System.out.println("Receipt total value: " + receiptTotalValue); // Print the total value of each receipt
            if (receiptTotalValue != null) {
                total_income = total_income.add(receiptTotalValue);
            } else {
                throw new IllegalArgumentException("Receipt total value cannot be null");
            }
        }
        return total_income;
    }
    @Override
    public String toString() {
        return "ShopIncome{" +
                "total_income=" + total_income +
                '}';
    }
}
