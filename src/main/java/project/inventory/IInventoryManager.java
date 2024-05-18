package project.inventory;

import java.util.List;

public interface IInventoryManager {
    List<Goods> getInventory();
    void addGoods(Goods goods);
}
