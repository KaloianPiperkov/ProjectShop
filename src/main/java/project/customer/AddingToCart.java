package project.customer;

import project.inventory.CanBeSold;
import project.inventory.Goods;
import project.inventory.GoodsQuantity;

import java.util.List;

public class AddingToCart extends GoodsQuantity{
    private Customer customer;
    private List<Goods> shopping_cart;

    public AddingToCart(Customer customer, List<Goods> shopping_cart) {
        this.customer = customer;
        this.shopping_cart = shopping_cart;
    }

    public void addGoodsToCart(Goods goods, int desired_quantity){
        CanBeSold canBeSold = new GoodsQuantity();
        if (canBeSold.canBeSold(desired_quantity, goods.getQuantity())) {
            shopping_cart.add(goods);
            goods.setQuantity(goods.getQuantity() - desired_quantity);
        }
        else{
            System.out.println("Not enough quantity");
        }
    }

    @Override
    public String toString() {
        return "AddingToCart{" +
                "shopping_cart=" + shopping_cart +
                "} " + super.toString();
    }
}

