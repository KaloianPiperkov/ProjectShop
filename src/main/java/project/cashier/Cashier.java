package project.cashier;

import project.checkout.CashDesk;
import project.shop.Shop;

import java.io.Serializable;
import java.math.BigDecimal;

public class Cashier extends Salary implements Serializable {
    private String name_of_cashier;
    private long id_of_cashier;
    private BigDecimal salary;
    private Shop shop;

    public Cashier(String name_of_cashier, long id_of_cashier) {
        if (name_of_cashier == null || name_of_cashier.isEmpty()) {
            throw new IllegalArgumentException("Name of cashier cannot be null or empty");
        }
        if (id_of_cashier < 0) {
            throw new IllegalArgumentException("ID of cashier cannot be negative");
        }
        this.name_of_cashier = name_of_cashier;
        this.id_of_cashier = id_of_cashier;
    }

    public void setSalary(BigDecimal salary){
        if (salary == null || salary.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Salary cannot be null or negative");
        }
        this.salary = salary;
    }

    public long getId_of_cashier() {
        return id_of_cashier;
    }

    public BigDecimal getSalary(){return salary;}

    public char[] getName() {
        return name_of_cashier.toCharArray();
    }


    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    @Override
    public String toString() {
        return "Cashier{" +
                "name_of_cashier='" + name_of_cashier + '\'' +
                ", id_of_cashier=" + id_of_cashier +
                '}';
    }
}