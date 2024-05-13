package project.inventory;

public class GoodsQuantity implements CanBeSold{
    @Override
    public boolean canBeSold(int desired_quantity) {
        return desired_quantity > 0;
    }
}
