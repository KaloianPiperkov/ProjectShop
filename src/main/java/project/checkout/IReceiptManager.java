package project.checkout;

import project.inventory.Goods;

import java.util.List;

public interface IReceiptManager {
    List<Goods> getInventory();
    void addGoods(Goods goods);

    List<Receipt> getReceipts();

    void addReceipt(Receipt receipt);
}
