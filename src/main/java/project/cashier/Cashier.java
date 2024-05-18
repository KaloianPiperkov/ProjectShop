//Cashiers work at the shop. They have name, id and monthly payment (salary).
//Every cashier work at a cash-desk in the shop. Cashiers mark the goods that clients want to buy.
//If the client has enough money to buy the goods, cashiers give them a receipt.

package project.cashier;

import java.io.Serializable;
import java.math.BigDecimal;

public class Cashier extends Salary implements Serializable {
    private String name_of_cashier;
    private long id_of_cashier;
    private BigDecimal salary;

    public Cashier(String name_of_cashier, long id_of_cashier) {
        this.name_of_cashier = name_of_cashier;
        this.id_of_cashier = id_of_cashier;
    }

    public void setSalary(BigDecimal salary){
        this.salary = salary;
    }
    public String getName_of_cashier() {
        return name_of_cashier;
    }

    public long getId_of_cashier() {
        return id_of_cashier;
    }
    public BigDecimal getSalary(){return salary;}

    @Override
    public String toString() {
        return "Cashier{" +
                "name_of_cashier='" + name_of_cashier + '\'' +
                ", id_of_cashier=" + id_of_cashier +
                '}';
    }

    public char[] getName() {
        return name_of_cashier.toCharArray();
    }

}


