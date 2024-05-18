package project.shop;

import java.math.BigDecimal;

public class ProfitCalculator implements CalculatingProfit {
    private BigDecimal totalIncome;
    private BigDecimal totalCosts;

    public ProfitCalculator(BigDecimal totalIncome, BigDecimal totalCosts) {
        this.totalIncome = totalIncome;
        this.totalCosts = totalCosts;
    }

    @Override
    public BigDecimal calculateProfit() {
        return totalIncome.subtract(totalCosts);
    }
}