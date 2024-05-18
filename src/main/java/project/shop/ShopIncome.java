package project.shop;

import project.checkout.Receipt;

import java.math.BigDecimal;
import java.util.List;

public class ShopIncome implements CalculatingTotalIncome{

    private List<Receipt> receipts;
    private BigDecimal total_income;


    public ShopIncome(List<Receipt> receipts){
        this.receipts = receipts;
        this.total_income = calculateTotalIncome();
    }

    @Override
    public BigDecimal calculateTotalIncome() {
        total_income = BigDecimal.ZERO; // Reset totalIncome to zero

        if (receipts == null || receipts.isEmpty()) {
            System.out.println("No receipts to calculate income from.");
            return total_income;
        }

        for (Receipt receipt : receipts) {
            BigDecimal receiptTotalValue = receipt.calculateTotalValue();
            //System.out.println("Receipt total value: " + receiptTotalValue); // Print the total value of each receipt
            if (receiptTotalValue != null) {
                total_income = total_income.add(receiptTotalValue);
            } else {
                System.out.println("Receipt total value is null.");
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
