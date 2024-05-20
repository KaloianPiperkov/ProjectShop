package project.shop;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ProfitCalculatorTest {

    @Test
    void testCalculateProfit() {
        ProfitCalculator profitCalculator = new ProfitCalculator(BigDecimal.valueOf(100), BigDecimal.valueOf(50));
        assertEquals(BigDecimal.valueOf(50), profitCalculator.calculateProfit());
    }

    @Test
    void testCalculateProfitZeroIncome() {
        ProfitCalculator profitCalculator = new ProfitCalculator(BigDecimal.ZERO, BigDecimal.valueOf(50));
        assertEquals(BigDecimal.valueOf(-50), profitCalculator.calculateProfit());
    }

    @Test
    void testCalculateProfitZeroCosts() {
        ProfitCalculator profitCalculator = new ProfitCalculator(BigDecimal.valueOf(100), BigDecimal.ZERO);
        assertEquals(BigDecimal.valueOf(100), profitCalculator.calculateProfit());
    }

    @Test
    void testCalculateProfitEqualIncomeAndCosts() {
        ProfitCalculator profitCalculator = new ProfitCalculator(BigDecimal.valueOf(100), BigDecimal.valueOf(100));
        assertEquals(BigDecimal.ZERO, profitCalculator.calculateProfit());
    }
}