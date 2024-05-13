package project.inventory;

public interface CanBeSold {
    boolean canBeSold(int desired_quantity, int available_quantity);
}
