package project.customer;

import project.inventory.Goods;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class Customer implements Serializable {

    private long id;
    private List<Goods> goods;
    private BigDecimal funds;

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



}
