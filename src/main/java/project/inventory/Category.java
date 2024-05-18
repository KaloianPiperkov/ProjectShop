package project.inventory;

import java.math.BigDecimal;

public enum Category {
    FOOD(new BigDecimal("12.5")), NON_FOOD(new BigDecimal("9.0"));

    private final BigDecimal defaultOverchargePercent;

    Category(BigDecimal defaultOverchargePercent) {
        this.defaultOverchargePercent = defaultOverchargePercent;
    }

    public BigDecimal getDefaultOverchargePercent() {
        return defaultOverchargePercent;
    }

}
