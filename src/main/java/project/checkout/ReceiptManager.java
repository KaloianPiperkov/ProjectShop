package project.checkout;

import project.inventory.Goods;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ReceiptManager implements IReceiptManager, Serializable {
    private List<Receipt> receipts;

    public ReceiptManager() {
        this.receipts = new ArrayList<>();
    }

    @Override
    public List<Goods> getInventory() {
        return List.of();
    }

    @Override
    public void addGoods(Goods goods) {

    }

    @Override
    public List<Receipt> getReceipts() {
        return receipts;
    }

    @Override
    public void addReceipt(Receipt receipt) {
        receipts.add(receipt);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ReceiptManager{\n");
        for (Receipt receipt : receipts) {
            sb.append("\t").append(receipt).append("\n");
        }
        sb.append("}");
        return sb.toString();
    }
}
