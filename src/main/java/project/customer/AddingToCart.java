package project.customer;

import project.inventory.CanBeSold;
import project.inventory.Goods;

public class AddingToCart{
    private Customer customer;


    public AddingToCart(Customer customer) {
        this.customer = customer;
    }

    public void addGoodsToCart(Goods goods, int quantity){
        if (goods.getQuantity() >= quantity){
            for (int i = 0; i < quantity; i++){
                customer.getGoods().add(goods);
            }

            //else{
                //throw exception
            //}
        }
    }

}
