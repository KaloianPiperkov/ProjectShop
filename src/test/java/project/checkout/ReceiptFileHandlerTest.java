package project.checkout;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import project.cashier.Cashier;
import project.cashier.CashierManager;
import project.inventory.Goods;
import project.inventory.InventoryManager;
import project.shop.Shop;
import project.shop.ShopCosts;
import project.shop.ShopIncome;

import java.io.File;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReceiptFileHandlerTest {

    @TempDir
    Path tempDir;

    //EXPECTED TO FAAIL BECAUSE CASHIER MANAGER IS NULL
    @Test
    void testSaveToFile() throws Exception {
        // Create a Shop object
        CashierManager cashierManager = new CashierManager();
        InventoryManager inventoryManager = new InventoryManager();
        ReceiptManager receiptManager = new ReceiptManager();
        List<Cashier> cashiers = cashierManager.getCashiers();
        List<Goods> goodsList = new ArrayList<>();
        List<Receipt> receipts = receiptManager.getReceipts();
        ShopCosts shopCosts = new ShopCosts(cashiers, goodsList);
        ShopIncome shopIncome = new ShopIncome(receipts);

        Shop shop = new Shop("Test Shop", cashierManager, inventoryManager, receiptManager, shopCosts, shopIncome, BigDecimal.valueOf(2.5), BigDecimal.valueOf(3.5));

        // Create a Receipt object and set the Shop object
        Receipt receipt = new Receipt();
        receipt.setShop(shop);

        // Save the Receipt object to a file
        ReceiptFileHandler receiptFileHandler = new ReceiptFileHandler();
        receiptFileHandler.saveToFile(receipt, shop.getShop_name());

        // Check if the file exists
        File file = tempDir.resolve(shop.getShop_name() + " receipts").resolve(receipt.getId() + ".dat").toFile();
        assertTrue(file.exists());
    }
}
