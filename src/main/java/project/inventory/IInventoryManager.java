package project.inventory;

import java.util.List;

//interface that defines method for managing the inventory
public interface IInventoryManager {
    List<Goods> getInventory();
    void addGoods(Goods goods);
    void addMultipleGoods(List<Goods> multipleGoods);
}
