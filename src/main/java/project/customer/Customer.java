package project.customer;

import project.inventory.Goods;

import java.util.List;

public class Customer {

    private long id;
    private List<Goods> goods;
    private double funds;

    public Customer(long id, List<Goods> goods, double funds) {
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

    public double getFunds() {
        return funds;
    }
}
