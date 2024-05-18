package project.shop;

import project.cashier.Cashier;
import project.checkout.CashDesk;
import project.checkout.Receipt;
import project.customer.Customer;
import project.customer.CustomerGenerator;
import project.inventory.Goods;
import project.inventory.GoodsGenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ShoppingSimulator {
    private final CustomerGenerator customerGenerator;
    private final GoodsGenerator goodsGenerator;
    private final CashDesk cashDesk;
    private final Cashier randomCashier;
    private final Random random;

    public ShoppingSimulator(CustomerGenerator customerGenerator, GoodsGenerator goodsGenerator, CashDesk cashDesk, Cashier randomCashier, Random random) {
        this.customerGenerator = customerGenerator;
        this.goodsGenerator = goodsGenerator;
        this.cashDesk = cashDesk;
        this.randomCashier = randomCashier;
        this.random = random;
    }

    public void simulateShopping() {
        Customer customer = customerGenerator.generateCustomer();
        Goods goods = goodsGenerator.generateGoods();
        Map<Goods, Integer> purchaseMap = new HashMap<>();
        purchaseMap.put(goods, random.nextInt(10));
        Receipt receipt = cashDesk.processPurchase(randomCashier, customer, purchaseMap);
        // Save the receipt, print it, or do whatever you want with it
    }
}
