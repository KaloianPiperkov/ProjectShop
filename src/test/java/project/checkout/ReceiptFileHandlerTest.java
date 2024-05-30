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
import static org.mockito.Mockito.*;

class ReceiptFileHandlerTest {

    @TempDir
    Path tempDir;

    @Test
    void testSaveToFile() throws Exception {
        // Create mock objects
        CashierManager cashierManager = mock(CashierManager.class);
        InventoryManager inventoryManager = mock(InventoryManager.class);
        ReceiptManager receiptManager = mock(ReceiptManager.class);
        ShopCosts shopCosts = mock(ShopCosts.class);
        ShopIncome shopIncome = mock(ShopIncome.class);

        Cashier cashier = mock(Cashier.class); // Create a mock Cashier object
        when(cashier.getName()).thenReturn("John Doe".toCharArray()); // Specify a return value for the getName() method
        when(cashier.getSalary()).thenReturn(BigDecimal.valueOf(5000)); // Specify a return value for the getSalary() method

        List<Cashier> cashiers = new ArrayList<>();
        cashiers.add(cashier); // Add the mock Cashier object to the list

        List<Goods> goodsList = new ArrayList<>();
        List<Receipt> receipts = new ArrayList<>();

        // When getCashiers, getGoodsList, and getReceipts methods are called on the mock objects, return the lists
        when(cashierManager.getCashiers()).thenReturn(cashiers);
        when(inventoryManager.getGoodsList()).thenReturn(goodsList);
        when(receiptManager.getReceipts()).thenReturn(receipts);

        Shop shop = new Shop("Test Shop", cashierManager, inventoryManager, receiptManager, shopCosts, shopIncome, BigDecimal.valueOf(2.5), BigDecimal.valueOf(3.5));

        // Create a Receipt object and set the Shop object
        Receipt receipt = new Receipt();
        receipt.setShop(shop);

        // Save the Receipt object to a file
        ReceiptFileHandler receiptFileHandler = new ReceiptFileHandler();
        receiptFileHandler.saveToFile(receipt, shop.getShopName());

        // Check if the file exists
        File file = tempDir.resolve(shop.getShopName() + " receipts").resolve(receipt.getId() + ".dat").toFile();
        assertTrue(file.exists());
    }
}