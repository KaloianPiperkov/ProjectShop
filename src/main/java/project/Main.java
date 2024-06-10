package project;

import project.cashier.Cashier;
import project.checkout.*;
import project.customer.AddingToCart;
import project.customer.Customer;
import project.inventory.*;
import project.shop.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        OverchargeCalculator overchargeCalculator = new OverchargeCalculator();

        ShopFactory shopFactory = new ShopFactory();

        Shop shop1 = shopFactory.createShop("Lidl", BigDecimal.valueOf(8.5), BigDecimal.valueOf(4.0));

        GoodsSellingPriceCalculator goodsSellingPriceCalculator = new GoodsSellingPriceCalculator(overchargeCalculator, shop1, 3);

        Goods apples = new Goods(1000, "apples", BigDecimal.valueOf(0.18), Category.FOOD, LocalDate.of(2024, 9, 7), 50, goodsSellingPriceCalculator);
        Goods strawberries = new Goods(1001, "strawberries", BigDecimal.valueOf(0.62), Category.FOOD, LocalDate.of(2024, 9, 30), 150, goodsSellingPriceCalculator);
        Goods toiletPaper = new Goods(1002, "toilet paper", BigDecimal.valueOf(0.70), Category.NON_FOOD, LocalDate.of(2030, 9, 15), 200, goodsSellingPriceCalculator);
        Goods lutenica = new Goods(1003, "lutenica", BigDecimal.valueOf(1.50), Category.FOOD, LocalDate.of(2024, 9, 22), 45, goodsSellingPriceCalculator);
        Goods bananas = new Goods(1004, "bananas", BigDecimal.valueOf(0.28), Category.FOOD, LocalDate.of(2024, 9, 10), 97, goodsSellingPriceCalculator);
        Goods toothpaste = new Goods(1005, "toothpaste", BigDecimal.valueOf(2.30), Category.NON_FOOD, LocalDate.of(2030, 12, 10), 30, goodsSellingPriceCalculator);
        Goods tomatoes = new Goods(1006, "tomatoes", BigDecimal.valueOf(0.57), Category.FOOD, LocalDate.of(2024, 9, 23), 77, goodsSellingPriceCalculator);
        Goods cigarettes = new Goods(1007, "cigarettes", BigDecimal.valueOf(4.00), Category.NON_FOOD, LocalDate.of(2025, 12, 31), 45, goodsSellingPriceCalculator);
        Goods cereal = new Goods(1008, "cereal", BigDecimal.valueOf(1.14), Category.FOOD, LocalDate.of(2025, 2, 6), 82, goodsSellingPriceCalculator);
        Goods tools = new Goods(1009, "tools", BigDecimal.valueOf(20.80), Category.NON_FOOD, LocalDate.of(2040, 11, 25), 25, goodsSellingPriceCalculator);
        Goods sheets = new Goods(1010, "sheets", BigDecimal.valueOf(35.60), Category.NON_FOOD, LocalDate.of(2035, 9, 30), 20, goodsSellingPriceCalculator);
        Goods pasta = new Goods(1011, "pasta", BigDecimal.valueOf(1.50), Category.FOOD, LocalDate.of(2026, 6, 15), 65, goodsSellingPriceCalculator);

        shop1.addGoodsToShop(shop1,Arrays.asList(apples,strawberries,toiletPaper,lutenica,bananas,toothpaste,tomatoes,cigarettes,cereal,tools,sheets,pasta));

        CashDesk cashDesk = new CashDesk(new ArrayList<>());
        shop1.addCashDesk(cashDesk);

        Customer customer = new Customer(1, new ArrayList<>(), BigDecimal.valueOf(100.00));
        Customer customer1 = new Customer(2, new ArrayList<>(), BigDecimal.valueOf(300.0));
        shop1.addCustomer(customer);
        shop1.addCustomer(customer1);

        AddingToCart cart = new AddingToCart(customer);
        AddingToCart cart1 = new AddingToCart(customer1);

        List<Goods> customerCart = Arrays.asList(apples, strawberries, toiletPaper, sheets);
        List<Integer> quantities = Arrays.asList(1, 2, 3, 1);

        List<Goods> customerCart1 = Arrays.asList(bananas, pasta, cigarettes, tomatoes, lutenica);
        List<Integer> quantities1 = Arrays.asList(5, 1, 20, 3, 1);

        cart.addMultipleGoodsToCart(customerCart, quantities, cart);
        cart1.addMultipleGoodsToCart(customerCart1, quantities1, cart1);

        Cashier cashier = new Cashier("John Doe", 1);
        Cashier cashier1 = new Cashier("Alex Martin", 2);
        shop1.addCashier(cashier);
        shop1.addCashier(cashier1);

        BigDecimal salary = cashier.calculatingSalary(BigDecimal.valueOf(7.50), BigDecimal.valueOf(100));
        BigDecimal salary1 = cashier1.calculatingSalary(BigDecimal.valueOf(7.50), BigDecimal.valueOf(100));

        cashier.setSalary(salary);
        cashier1.setSalary(salary1);

        //Processing of the purchases
        LinkedHashMap<Goods, Integer> purchaseMap = (LinkedHashMap<Goods, Integer>) cart.getShoppingCart();
        LinkedHashMap<Goods, Integer> purchaseMap1 = (LinkedHashMap<Goods, Integer>) cart1.getShoppingCart();
        Receipt receipt = cashDesk.processPurchase(cashier, customer, purchaseMap);
        Receipt receipt1 = cashDesk.processPurchase(cashier1, customer1, purchaseMap1);

        receipt.setShop(shop1);
        receipt1.setShop(shop1);

        //Saving the receipts to files
        ReceiptFileHandler fileHandler = new ReceiptFileHandler();
        ReceiptFileHandler fileHandler1 = new ReceiptFileHandler();
        fileHandler.saveToFile(receipt, shop1.getShopName());
        fileHandler1.saveToFile(receipt1, shop1.getShopName());

        System.out.println(receipt);
        System.out.println(receipt1);

        List<Shop> shops = new ArrayList<>();
        shops.add(shop1);

        //-------------------SHOP2-----------------------------------------------------------------------

        Shop shop2 = shopFactory.createShop("Kaufland", BigDecimal.valueOf(10.5), BigDecimal.valueOf(6.0));

        GoodsSellingPriceCalculator goodsSellingPriceCalculator1 = new GoodsSellingPriceCalculator(overchargeCalculator, shop2, 3);

        Goods milk = new Goods(2000, "milk", BigDecimal.valueOf(1.20), Category.NON_FOOD, LocalDate.of(2024, 9, 20), 120, goodsSellingPriceCalculator1);
        Goods bread = new Goods(2001, "bread", BigDecimal.valueOf(0.95), Category.FOOD, LocalDate.of(2024, 9, 25), 130, goodsSellingPriceCalculator1);
        Goods shampoo = new Goods(2002, "shampoo", BigDecimal.valueOf(3.50), Category.NON_FOOD, LocalDate.of(2030, 8, 15), 90, goodsSellingPriceCalculator1);
        Goods cheese = new Goods(2003, "cheese", BigDecimal.valueOf(2.50), Category.FOOD, LocalDate.of(2024, 9, 10), 75, goodsSellingPriceCalculator1);
        Goods oranges = new Goods(2004, "oranges", BigDecimal.valueOf(0.50), Category.FOOD, LocalDate.of(2024, 9, 5), 85, goodsSellingPriceCalculator1);
        Goods detergent = new Goods(2005, "detergent", BigDecimal.valueOf(4.30), Category.NON_FOOD, LocalDate.of(2031, 3, 20), 60, goodsSellingPriceCalculator1);
        Goods carrots = new Goods(2006, "carrots", BigDecimal.valueOf(0.40), Category.FOOD, LocalDate.of(2024, 10, 30), 110, goodsSellingPriceCalculator1);
        Goods batteries = new Goods(2007, "batteries", BigDecimal.valueOf(2.00), Category.NON_FOOD, LocalDate.of(2029, 12, 31), 50, goodsSellingPriceCalculator1);
        Goods rice = new Goods(2008, "rice", BigDecimal.valueOf(1.10), Category.FOOD, LocalDate.of(2025, 1, 10), 100, goodsSellingPriceCalculator1);
        Goods drill = new Goods(2009, "drill", BigDecimal.valueOf(45.00), Category.NON_FOOD, LocalDate.of(2045, 10, 1), 20, goodsSellingPriceCalculator1);
        Goods towels = new Goods(2010, "towels", BigDecimal.valueOf(15.00), Category.NON_FOOD, LocalDate.of(2037, 10, 15), 30, goodsSellingPriceCalculator1);
        Goods coffee = new Goods(2011, "coffee", BigDecimal.valueOf(5.00), Category.NON_FOOD, LocalDate.of(2025, 12, 20), 140, goodsSellingPriceCalculator1);

        shop2.addGoodsToShop(shop2,Arrays.asList(milk,bread,shampoo,cheese,oranges,detergent,carrots,batteries,rice,drill,towels,coffee));

        CashDesk cashDesk1 = new CashDesk(new ArrayList<>());
        shop1.addCashDesk(cashDesk1);

        Customer customer2 = new Customer(1, new ArrayList<>(), BigDecimal.valueOf(100.00));
        Customer customer3 = new Customer(2, new ArrayList<>(), BigDecimal.valueOf(9990.0));

        shop1.addCustomer(customer2);
        shop1.addCustomer(customer3);

        AddingToCart cart2 = new AddingToCart(customer2);
        AddingToCart cart3 = new AddingToCart(customer3);

        List<Goods> customerCart2 = Arrays.asList(apples, strawberries, toiletPaper, sheets);
        List<Integer> quantities2 = Arrays.asList(1, 2, 3, 1);

        List<Goods> customerCart3 = Arrays.asList(bananas, pasta, cigarettes, tomatoes, lutenica);
        List<Integer> quantities3 = Arrays.asList(5, 1, 20, 3, 15);

        cart.addMultipleGoodsToCart(customerCart2, quantities2, cart2);
        cart1.addMultipleGoodsToCart(customerCart3, quantities3, cart3);

        Cashier cashier2 = new Cashier("John Doe", 1);
        Cashier cashier3 = new Cashier("Alex Martin", 2);

        shop2.addCashier(cashier2);
        shop2.addCashier(cashier3);

        BigDecimal salary2 = cashier.calculatingSalary(BigDecimal.valueOf(7.50), BigDecimal.valueOf(100));
        BigDecimal salary3 = cashier1.calculatingSalary(BigDecimal.valueOf(7.50), BigDecimal.valueOf(100));

        cashier.setSalary(salary2);
        cashier1.setSalary(salary3);

        LinkedHashMap<Goods, Integer> purchaseMap2 = (LinkedHashMap<Goods, Integer>) cart2.getShoppingCart();
        LinkedHashMap<Goods, Integer> purchaseMap3 = (LinkedHashMap<Goods, Integer>) cart3.getShoppingCart();

        Receipt receipt2 = cashDesk.processPurchase(cashier2, customer2, purchaseMap2);
        Receipt receipt3 = cashDesk.processPurchase(cashier3, customer3, purchaseMap3);

        receipt2.setShop(shop2);
        receipt3.setShop(shop2);

        ReceiptFileHandler fileHandler2 = new ReceiptFileHandler();
        ReceiptFileHandler fileHandler3 = new ReceiptFileHandler();

        fileHandler2.saveToFile(receipt2, shop2.getShopName());
        fileHandler3.saveToFile(receipt3, shop2.getShopName());

        System.out.println(receipt2);
        System.out.println(receipt3);

        shops.add(shop2);
    }
}