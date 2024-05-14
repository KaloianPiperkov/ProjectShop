package project.shop;

import project.checkout.Receipt;

import java.util.List;

public class ShopIncome implements CalculatingTotalIncome{

    private List<Receipt> receipts;
    private double total_income;


    public ShopIncome(List<Receipt> receipts){
        this.receipts = receipts;
    }

    @Override
    public double calculateTotalIncome() {

        for (Receipt receipt : receipts ){
            total_income += receipt.calculateTotalValue();

            //total_income - total_costs
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
