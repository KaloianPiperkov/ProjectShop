package project.checkout;

import project.inventory.Goods;

import java.util.List;

//interface that defines the methods that a receipt manager should implement
public interface IReceiptManager {
    List<Goods> getInventory();
    //void addGoods(Goods goods) throws IllegalArgumentException;

    List<Receipt> getReceipts();

    void addReceipt(Receipt receipt) throws IllegalArgumentException;
}