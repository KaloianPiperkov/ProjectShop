package project.inventory;

import project.cashier.Cashier;

import java.util.ArrayList;
import java.util.List;

public class CashDesk {
    private Cashier cashier;
    private List<Goods> purchase_list;

    public CashDesk(Cashier cashier){
        this.cashier = cashier;
        this.purchase_list = new ArrayList<>();
    }

    //marking goods for the purchase
    public void addGoodsToList(Goods goods){
        purchase_list.add(goods);
    }

    //method to generate receipt for the client
            //probably here we can also see if the customer has enough money for the purchase
            //before giving the receipt??
            //here we check for quantity of the goods

    //method to update inventory with sold goods


}
