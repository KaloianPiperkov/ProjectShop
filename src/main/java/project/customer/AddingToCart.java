package project.customer;
import project.inventory.CanBeSold;
import project.inventory.Goods;
import project.inventory.GoodsQuantity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AddingToCart extends GoodsQuantity implements Serializable {
    private Customer customer;
    private Map<Goods, Integer> shopping_cart;

    public AddingToCart(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null");
        }
        this.customer = customer;
        this.shopping_cart = new LinkedHashMap<>();
    }

    public Map<Goods, Integer> getShoppingCart() {
        return shopping_cart;
    }

    //method that adds multiple goods to the cart of the customer
    //checking if the desired quantity of the good is available before adding it
    public void addMultipleGoodsToCart(List<Goods> goodsList, List<Integer> quantities, AddingToCart cart) {
        for (int i = 0; i < goodsList.size(); i++) {
            cart.addGoodsToCart(goodsList.get(i), quantities.get(i));
        }
    }

    //method that adds a single item to the cart
    //checking if the desired quantity is available
    public void addGoodsToCart(Goods goods, int desired_quantity) {
        if (goods == null) {
            throw new IllegalArgumentException("Goods cannot be null");
        }

        if (desired_quantity <= 0) {
            throw new IllegalArgumentException("Desired quantity must be greater than zero");
        }

        CanBeSold canBeSold = new GoodsQuantity();
        if (canBeSold.canBeSold(desired_quantity, goods.getQuantity())) {
            checkCustomerFunds(goods,desired_quantity);
            shopping_cart.put(goods, desired_quantity);
            goods.setQuantity(goods.getQuantity() - desired_quantity);
        } else {
            throw new InsufficientQuantityException("Not enough quantity");
        }
    }

    //method that checks if the customer has enough funds to buy
    private void checkCustomerFunds(Goods goods, int desired_quantity){
        if(customer.getFunds().compareTo(goods.calculateSellingPrice().multiply(new BigDecimal(desired_quantity))) < 0) {
            throw new InsufficientFundsException("Not enough funds");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Customer ").append(customer.getId()).append(" Shopping Cart: \n");
        for (Map.Entry<Goods, Integer> entry : shopping_cart.entrySet()) {
            sb.append("Goods Name: ").append(entry.getKey().getName())
                    .append(", Quantity: ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }
}


class InsufficientQuantityException extends RuntimeException {
    public InsufficientQuantityException(String message) {
        super(message);
    }
}

