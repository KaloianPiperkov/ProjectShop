package project.customer;

import project.inventory.Goods;
import project.shop.Shop;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class Customer implements Serializable {

    private long id;
    private List<Goods> goods;
    private BigDecimal funds;
    private Shop shop;

    public Customer(long id, List<Goods> goods, BigDecimal funds, Shop shop) {
        this.id = id;
        this.goods = goods;
        this.funds = funds;
        this.shop = shop;
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
