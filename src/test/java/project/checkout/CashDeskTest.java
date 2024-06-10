package project.checkout;

import org.junit.jupiter.api.Test;
import project.cashier.Cashier;
import project.customer.Customer;
import project.inventory.Category;
import project.inventory.Goods;
import project.inventory.GoodsSellingPriceCalculator;
import project.inventory.SellingPriceCalculation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CashDeskTest {

    //EXPECTED TO FAIL BECAUSE OVERCHARGE CALCULATOR IS NULL
    @Test
    void testProcessPurchase() {
        List<Goods> goodsList = new ArrayList<>();
        CashDesk cashDesk = new CashDesk(new ArrayList<>());
        Cashier cashier = new Cashier("John Doe", 1234);
        Customer customer = new Customer(453, goodsList, BigDecimal.valueOf(100));
        SellingPriceCalculation sellingPriceCalculation = new GoodsSellingPriceCalculator();
        Goods goods = new Goods(1L, "Apple", BigDecimal.valueOf(50), Category.FOOD, LocalDate.now().plusDays(5), 10, sellingPriceCalculation);
        LinkedHashMap<Goods, Integer> purchaseMap = new LinkedHashMap<>();
        purchaseMap.put(goods, 2);

        Receipt receipt = cashDesk.processPurchase(cashier, customer, purchaseMap);

        assertNotNull(receipt);
        assertEquals(1, cashDesk.getReceipts().size());
        assertEquals(receipt, cashDesk.getReceipts().get(0));
        assertEquals(BigDecimal.valueOf(100), receipt.getTotalValue());
    }
}