package project.inventory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class InventoryManager implements IInventoryManager, Serializable {
    private List<Goods> inventory;

    public InventoryManager() {
        this.inventory = new ArrayList<>();
    }

    @Override
    public List<Goods> getInventory() {
        return inventory;
    }

    @Override
    public void addGoods(Goods goods) {
        inventory.add(goods);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("InventoryManager{\n");
        for (Goods goods : inventory) {
            sb.append("\t").append(goods).append("\n");
        }
        sb.append("}");
        return sb.toString();
    }
}
