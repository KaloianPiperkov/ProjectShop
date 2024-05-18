package project.shop;

import project.checkout.Receipt;

import java.math.BigDecimal;
import java.util.List;

public class ShopIncome implements CalculatingTotalIncome{

    private List<Receipt> receipts;
    private BigDecimal total_income;


    public ShopIncome(List<Receipt> receipts){
        this.receipts = receipts;
    }

    @Override
    public BigDecimal calculateTotalIncome() {
        total_income = BigDecimal.ZERO; // Reset totalIncome to zero

        for (Receipt receipt : receipts) {
            total_income = total_income.add(receipt.calculateTotalValue());
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
