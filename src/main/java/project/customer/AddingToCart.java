package project.customer;

import project.inventory.CanBeSold;
import project.inventory.Goods;
import project.inventory.GoodsQuantity;

import java.util.HashMap;
import java.util.Map;

public class AddingToCart extends GoodsQuantity{
    private Customer customer;
    private Map<Goods, Integer> shopping_cart;

    public AddingToCart(Customer customer) {
        this.customer = customer;
        this.shopping_cart = new HashMap<>();
    }

    public void addGoodsToCart(Goods goods, int desired_quantity){
        CanBeSold canBeSold = new GoodsQuantity();
        if (canBeSold.canBeSold(desired_quantity, goods.getQuantity())) {
            shopping_cart.put(goods, desired_quantity);
            goods.setQuantity(goods.getQuantity() - desired_quantity);
        }
        else{
            System.out.println("Not enough quantity");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Shopping Cart: \n");
        for (Map.Entry<Goods, Integer> entry : shopping_cart.entrySet()) {
            sb.append("Goods Name: ").append(entry.getKey().getName())
                    .append(", Quantity: ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }
}