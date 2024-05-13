package project.inventory;

public class GoodsQuantity implements CanBeSold{

    @Override
    public boolean canBeSold(int desired_quantity, int available_quantity) {
        return desired_quantity > 0 && desired_quantity <= available_quantity;
    }
}
