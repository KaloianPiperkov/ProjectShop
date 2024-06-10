package project.inventory;

//class that implements the interface CanBeSold
public class GoodsQuantity implements CanBeSold{

    @Override
    public boolean canBeSold(int desired_quantity, int available_quantity) {
        if (desired_quantity < 0) {
            throw new IllegalArgumentException("Desired quantity cannot be negative");
        }
        if (available_quantity < 0) {
            throw new IllegalArgumentException("Available quantity cannot be negative");
        }
        return desired_quantity > 0 && desired_quantity <= available_quantity;
    }
}