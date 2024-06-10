package project.customer;

import project.inventory.Goods;
import project.shop.Shop;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

//class that represents a customer in the shop
public class Customer implements Serializable {

    private long id;
    private List<Goods> goods;
    private BigDecimal funds;
    private Shop shop;

    public Customer(long id, List<Goods> goods, BigDecimal funds) {
        this.id = id;
        this.goods = goods;
        this.funds = funds;

    }

    public long getId() {
        return id;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public BigDecimal getFunds() {
        return funds;
    }

    public Shop getShop(){
        return shop;
    }

    public void setShop(Shop shop){
        this.shop = shop;
    }

}
