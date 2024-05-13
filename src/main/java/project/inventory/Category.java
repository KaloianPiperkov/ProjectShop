package project.inventory;

public enum Category {
    FOOD(12.5), NON_FOOD(9.0);

    private final double defaultOverchargePercent;

    Category(double defaultOverchargePercent) {
        this.defaultOverchargePercent = defaultOverchargePercent;
    }

    public double getDefaultOverchargePercent() {
        return defaultOverchargePercent;
    }

}
