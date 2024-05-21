package project;

import project.cashier.Cashier;
import project.cashier.CashierManager;
import project.cashier.ICashierManager;
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

        //SHOP1
//        System.out.println("\n");
//        System.out.println("--Information about the shop1 before adding cashiers, inventory and creating receipts---");

        ICashierManager cashierManager1 = new CashierManager();
        IInventoryManager inventoryManager1 = new InventoryManager();
        IReceiptManager receiptManager1 = new ReceiptManager();
        ShopIncome shopIncome1 = new ShopIncome(receiptManager1.getReceipts());
        ShopCosts shopCosts1 = new ShopCosts(cashierManager1.getCashiers(), inventoryManager1.getInventory());

        Shop shop = new Shop("Lidl", cashierManager1, inventoryManager1, receiptManager1, shopCosts1, shopIncome1, BigDecimal.valueOf(8.5), BigDecimal.valueOf(4.0));
        List<Shop> shops = new ArrayList<>();
        shops.add(shop);

        System.out.println("-----SHOP 1-----");
        System.out.println(shop);

        CreatingLists lists1 = getCreatingLists();
        OverchargeCalculator overchargeCalculator = new OverchargeCalculator();
        CashDesk cashDesk1 = new CashDesk(lists1.receipts());

        System.out.println("\n");
        System.out.println("-----CASHIERS IN SHOP 1-----");
        CreatingAndPrintingCashiersShop1 cashiers = getCreatingAndPrintingCashiersShop1();
        //adding the cashiers to the shop
        AddingCashiersToShop1(lists1, cashiers);
        //printing their salaries
        PrintCashiersSalary(cashiers);
        Cashier randomCashier = RandomizeCashier(lists1);

        System.out.println("\n");

        // Add cashiers, goods, and receipts to their respective managers
        cashierManager1.addCashier(cashiers.cashier1());
        cashierManager1.addCashier(cashiers.cashier2());

        SellingPriceCalculation sellingPriceCalculator = new GoodsSellingPriceCalculator(overchargeCalculator, shop);
        CreatingGoods goods = getCreatingGoods(sellingPriceCalculator);

        inventoryManager1.addGoods(goods.goods1());
        inventoryManager1.addGoods(goods.goods2());
        inventoryManager1.addGoods(goods.goods3());
        inventoryManager1.addGoods(goods.goods4());
        inventoryManager1.addGoods(goods.goods5());
        inventoryManager1.addGoods(goods.goods6());
        inventoryManager1.addGoods(goods.goods7());
        inventoryManager1.addGoods(goods.goods8());
        inventoryManager1.addGoods(goods.goods9());
        inventoryManager1.addGoods(goods.goods10());
        inventoryManager1.addGoods(goods.goods11());
        inventoryManager1.addGoods(goods.goods12());

        System.out.println("\n");

        CreatingCustomers customers = getCreatingCustomers(lists1);

        // Process the purchase at the cash desk
        CreatingCartsAndAddingGoodsToCards carts = getCreatingCartsAndAddingGoodsToCards(customers, goods);

        GetItemsFromCart itemsCart = getGetItemsFromCart(carts);
        //System.out.println("---Printing itemsCart of customer in shop1: " + itemsCart);

        CreatingAndPrintingReceipts(cashDesk1, randomCashier, customers, itemsCart, receiptManager1, shop);

        System.out.println("\n");
        System.out.println("-----PRICE PER ITEM WITH OVERCHARGE PERCENTAGE IN SHOP 1-----");

        //printing the selling price of these goods
        PrintSellingPriceForGoods(goods);

        System.out.println("\n");

        System.out.println("-----SHOP 1 COSTS: " + shopCosts1.calculateTotalCost() + " -----");
        System.out.println("-----SHOP 1 INCOME: " + shopIncome1.calculateTotalIncome() + "-----");

        BigDecimal totalIncome = shopIncome1.calculateTotalIncome();
        BigDecimal totalCosts = shopCosts1.calculateTotalCost();
        ProfitCalculator profitCalculator = new ProfitCalculator(totalIncome, totalCosts);
        BigDecimal profit = profitCalculator.calculateProfit();
        System.out.println("-----SHOP 1 PROFIT: " + profit + "-----");

        System.out.println("\n");
        System.out.println("-----INVENTORY AFTER PURCHASES IN SHOP 1-----");
        System.out.println(inventoryManager1);


        //-----------------SHOP2--------------------------

        ICashierManager cashierManager2 = new CashierManager();
        IInventoryManager inventoryManager2 = new InventoryManager();
        IReceiptManager receiptManager2 = new ReceiptManager();
        ShopIncome shopIncome2 = new ShopIncome(receiptManager1.getReceipts());
        ShopCosts shopCosts2 = new ShopCosts(cashierManager1.getCashiers(), inventoryManager1.getInventory());

        //Creating shop2
        Shop shop2 = new Shop("Kaufland", cashierManager2, inventoryManager2, receiptManager2, shopCosts2, shopIncome2, BigDecimal.valueOf(10.5), BigDecimal.valueOf(6.0));
        shops.add(shop2);
        System.out.println("\n");
        System.out.println("-----SHOP 2-----");
        System.out.println(shop2);

        CreatingLists lists2 = getCreatingLists();
        CashDesk cashDesk2 = new CashDesk(lists2.receipts());
        System.out.println("\n");
        System.out.println("-----CASHIERS IN SHOP 2-----");

        //Adding new cashiers to shop2
        CreatingAndPrintingCashiersShop2 cashiers2 = getCreatingAndPrintingCashiersShop2();
        AddingCashiersToShop2(lists2, cashiers2);
        PrintCashiersSalaryShop2(cashiers2);
        Cashier randomCashier2 = RandomizeCashier(lists2);

        cashierManager2.addCashier(cashiers2.cashier1());
        cashierManager2.addCashier(cashiers2.cashier2());

        SellingPriceCalculation sellingPriceCalculator2 = new GoodsSellingPriceCalculator(overchargeCalculator, shop2);
        CreatingGoods2 goods2 = getCreatingGoodsForShop2(sellingPriceCalculator2);

        inventoryManager2.addGoods(goods2.goods1());
        inventoryManager2.addGoods(goods2.goods2());
        inventoryManager2.addGoods(goods2.goods3());
        inventoryManager2.addGoods(goods2.goods4());
        inventoryManager2.addGoods(goods2.goods5());
        inventoryManager2.addGoods(goods2.goods6());
        inventoryManager2.addGoods(goods2.goods7());
        inventoryManager2.addGoods(goods2.goods8());
        inventoryManager2.addGoods(goods2.goods9());
        inventoryManager2.addGoods(goods2.goods10());
        inventoryManager2.addGoods(goods2.goods11());
        inventoryManager2.addGoods(goods2.goods12());

        System.out.println("\n");

        CreatingCustomers2 customers2 = getCreatingCustomers2(lists2);

        CreatingCartsAndAddingGoodsToCarts2 carts2 = getCreatingCartsAndAddingGoodsToCarts2(customers2, goods2);

        GetItemsFromCart2 itemsCart2 = getGetItemsFromCart2(carts2);

        CreatingAndPrintingReceiptsShop2(cashDesk2, randomCashier2, customers2, itemsCart2, receiptManager2, shop2);

        System.out.println("-----PRICE PER ITEM WITH OVERCHARGE PERCENTAGE IN SHOP 2-----");
        PrintSellingPriceForGoods2(goods2);

        System.out.println("\n");

        System.out.println("-----SHOP 2 COSTS: " + shopCosts2.calculateTotalCost() + "-----");
        System.out.println("-----SHOP 2 INCOME: " + shopIncome2.calculateTotalIncome() + "-----");

        BigDecimal totalIncome2 = shopIncome2.calculateTotalIncome();
        BigDecimal totalCost2 = shopCosts2.calculateTotalCost();
        ProfitCalculator profitCalculator2 = new ProfitCalculator(totalIncome2, totalCost2);
        BigDecimal profit2 = profitCalculator2.calculateProfit();
        System.out.println("-----SHOP 2 PROFIT: " + profit2 + "-----");

        System.out.println("\n");
        System.out.println("-----INVENTORY AFTER PURCHASES IN SHOP 2-----");
        System.out.println(inventoryManager2);
    }

    private static void CreatingAndPrintingReceipts(CashDesk cashDesk, Cashier randomCashier, CreatingCustomers customers, GetItemsFromCart itemsCart, IReceiptManager receiptManager, Shop shop) {
        Receipt receipt = cashDesk.processPurchase(randomCashier, customers.customer(), itemsCart.purchaseMap());
        receipt.setShop(shop);
        Receipt receipt2 = cashDesk.processPurchase(randomCashier, customers.customer2(), itemsCart.purchaseMap2());
        receipt2.setShop(shop);
        Receipt receipt3 = cashDesk.processPurchase(randomCashier, customers.customer3(), itemsCart.purchaseMap3());
        receipt3.setShop(shop);
        Receipt receipt4 = cashDesk.processPurchase(randomCashier, customers.customer4(), itemsCart.purchaseMap4());
        receipt4.setShop(shop);
        Receipt receipt5 = cashDesk.processPurchase(randomCashier, customers.customer5(), itemsCart.purchaseMap5());
        receipt5.setShop(shop);

        // Add the receipts to the receiptManager
        receiptManager.addReceipt(receipt);
        receiptManager.addReceipt(receipt2);
        receiptManager.addReceipt(receipt3);
        receiptManager.addReceipt(receipt4);
        receiptManager.addReceipt(receipt5);

        ReceiptFileHandler fileHandler = new ReceiptFileHandler();

        fileHandler.saveToFile(receipt,shop.getShop_name());
        fileHandler.saveToFile(receipt2, shop.getShop_name());
        fileHandler.saveToFile(receipt3, shop.getShop_name());
        fileHandler.saveToFile(receipt4, shop.getShop_name());
        fileHandler.saveToFile(receipt5, shop.getShop_name());
    }

    private static Cashier RandomizeCashier(CreatingLists lists) {
        Random random = new Random();
        int randomIndex = random.nextInt(lists.cashiers().size());
        Cashier randomCashier = lists.cashiers().get(randomIndex);
        return randomCashier;
    }

    private static GetItemsFromCart getGetItemsFromCart(CreatingCartsAndAddingGoodsToCards carts) {
        Map<Goods, Integer> purchaseMap = carts.cart().getShoppingCart();       // assuming you have a getShoppingCart method in AddingToCart
        Map<Goods, Integer> purchaseMap2 = carts.cart2().getShoppingCart();     // assuming you have a getShoppingCart method in AddingToCart
        Map<Goods, Integer> purchaseMap3 = carts.cart3().getShoppingCart();     // assuming you have a getShoppingCart method in AddingToCart
        Map<Goods, Integer> purchaseMap4 = carts.cart4().getShoppingCart();     // assuming you have a getShoppingCart method in AddingToCart
        Map<Goods, Integer> purchaseMap5 = carts.cart5().getShoppingCart();     // assuming you have a getShoppingCart method in AddingToCart
        GetItemsFromCart itemsCart = new GetItemsFromCart(purchaseMap, purchaseMap2, purchaseMap3, purchaseMap4, purchaseMap5);
        return itemsCart;
    }

    private record GetItemsFromCart(Map<Goods, Integer> purchaseMap, Map<Goods, Integer> purchaseMap2, Map<Goods, Integer> purchaseMap3, Map<Goods, Integer> purchaseMap4, Map<Goods, Integer> purchaseMap5) {
    }

    private static CreatingCartsAndAddingGoodsToCards getCreatingCartsAndAddingGoodsToCards(CreatingCustomers customers, CreatingGoods goods) {
        AddingToCart cart = new AddingToCart(customers.customer());
        cart.addGoodsToCart(goods.goods2(), 1);
        cart.addGoodsToCart(goods.goods3(), 1);
        cart.addGoodsToCart(goods.goods10(), 1);
        cart.addGoodsToCart(goods.goods6(), 1);
        System.out.println("---CARTS IN SHOP 1---");
        System.out.println(cart);

        AddingToCart cart2 = new AddingToCart(customers.customer2());
        cart2.addGoodsToCart(goods.goods1(), 1);
        cart2.addGoodsToCart(goods.goods2(), 1);
        System.out.println(cart2);

        AddingToCart cart3 = new AddingToCart(customers.customer3());
        cart3.addGoodsToCart(goods.goods9(), 1);

        System.out.println(cart3);

        AddingToCart cart4 = new AddingToCart(customers.customer4());
        cart4.addGoodsToCart(goods.goods8(), 1);
        cart4.addGoodsToCart(goods.goods4(), 1);
        cart4.addGoodsToCart(goods.goods5(), 1);
        cart4.addGoodsToCart(goods.goods9(), 1);
        System.out.println(cart4);

        AddingToCart cart5 = new AddingToCart(customers.customer5());
        cart5.addGoodsToCart(goods.goods3(), 1);
        cart5.addGoodsToCart(goods.goods11(), 1);
        cart5.addGoodsToCart(goods.goods12(), 1);
        System.out.println(cart5);

        CreatingCartsAndAddingGoodsToCards carts = new CreatingCartsAndAddingGoodsToCards(cart, cart2, cart3, cart4, cart5);
        return carts;
    }

    private record CreatingCartsAndAddingGoodsToCards(AddingToCart cart, AddingToCart cart2, AddingToCart cart3, AddingToCart cart4, AddingToCart cart5) {
    }

    private static CreatingCustomers getCreatingCustomers(CreatingLists lists) {
        Customer customer = new Customer(0001, lists.inventory(), BigDecimal.valueOf(120.32));
        Customer customer2 = new Customer(0002, lists.inventory(), BigDecimal.valueOf(35.96));
        Customer customer3 = new Customer(0003, lists.inventory(), BigDecimal.valueOf(99990.01));
        Customer customer4 = new Customer(0004, lists.inventory(), BigDecimal.valueOf(4327.05));
        Customer customer5 = new Customer(0005, lists.inventory(), BigDecimal.valueOf(360.36));
        CreatingCustomers customers = new CreatingCustomers(customer, customer2, customer3, customer4, customer5);
        return customers;
    }

    private record CreatingCustomers(Customer customer, Customer customer2, Customer customer3, Customer customer4, Customer customer5) {
    }

    private static void PrintCashiersSalary(CreatingAndPrintingCashiersShop1 cashiers) {
        BigDecimal salary1 = cashiers.cashier1().calculatingSalary(BigDecimal.valueOf(7.50), BigDecimal.valueOf(100));
        BigDecimal salary2 = cashiers.cashier2().calculatingSalary(BigDecimal.valueOf(8.50), BigDecimal.valueOf(120));

        cashiers.cashier1().setSalary(salary1);
        cashiers.cashier2().setSalary(salary2);

        System.out.println("Cashier 1's monthly salary: " + salary1);
        System.out.println("Cashier 2's monthly salary: " + salary2);
    }

    private static void AddingCashiersToShop1(CreatingLists lists, CreatingAndPrintingCashiersShop1 cashiers) {
        lists.cashiers().add(cashiers.cashier1());
        lists.cashiers().add(cashiers.cashier2());
    }

    private static CreatingAndPrintingCashiersShop1 getCreatingAndPrintingCashiersShop1() {

        Cashier cashier1 = new Cashier("Maria", 345);
        Cashier cashier2 = new Cashier("Alex", 346);
        System.out.println(cashier1);
        System.out.println(cashier2);
        CreatingAndPrintingCashiersShop1 cashiers = new CreatingAndPrintingCashiersShop1(cashier1, cashier2);

        return cashiers;
    }

    private record CreatingAndPrintingCashiersShop1(Cashier cashier1, Cashier cashier2) {
    }

    private static void PrintSellingPriceForGoods(CreatingGoods goods) {
        System.out.println("Selling price for 1 apple: " + goods.goods1().calculateSellingPrice());
        System.out.println("Selling price for 1 strawberries: " + goods.goods2().calculateSellingPrice()); //not expired
        System.out.println("Selling price for 1 toilet paper: " + goods.goods3().calculateSellingPrice()); //not expired
        System.out.println("Selling price for 1 lutenica: " + goods.goods4().calculateSellingPrice()); //not expired
        System.out.println("Selling price for 1 banana: " + goods.goods5().calculateSellingPrice()); //not expired
        System.out.println("Selling price for 1 toothpaste: " + goods.goods6().calculateSellingPrice()); //not expired
        System.out.println("Selling price for 1 tomato: " + goods.goods7().calculateSellingPrice()); //not expired
        System.out.println("Selling price for 1 cigarette: " + goods.goods8().calculateSellingPrice()); //not expired
        System.out.println("Selling price for 1 cereal: " + goods.goods9().calculateSellingPrice()); //not expired
        System.out.println("Selling price for 1 tools: " + goods.goods10().calculateSellingPrice()); //not expired
        System.out.println("Selling price for 1 sheets: " + goods.goods11().calculateSellingPrice()); //not expired
        System.out.println("Selling price for 1 pasta: " + goods.goods12().calculateSellingPrice()); //not expired
    }

    private static CreatingGoods getCreatingGoods(SellingPriceCalculation sellingPriceCalculator) {
        Goods goods1 = new Goods(1000, "apples", BigDecimal.valueOf(0.18), Category.FOOD, LocalDate.of(2024, 6, 7), 50, sellingPriceCalculator);
        Goods goods2 = new Goods(1001, "strawberries", BigDecimal.valueOf(0.62), Category.FOOD, LocalDate.of(2024, 6, 30), 150, sellingPriceCalculator);
        Goods goods3 = new Goods(1002, "toilet paper", BigDecimal.valueOf(0.70), Category.NON_FOOD, LocalDate.of(2030, 6, 15), 200, sellingPriceCalculator);
        Goods goods4 = new Goods(1003, "lutenica", BigDecimal.valueOf(1.50), Category.FOOD, LocalDate.of(2024, 6, 22), 45, sellingPriceCalculator);
        Goods goods5 = new Goods(1004, "bananas", BigDecimal.valueOf(0.28), Category.FOOD, LocalDate.of(2024, 6, 10), 97, sellingPriceCalculator);
        Goods goods6 = new Goods(1005, "toothpaste", BigDecimal.valueOf(2.30), Category.NON_FOOD, LocalDate.of(2030, 12, 10), 30, sellingPriceCalculator);
        Goods goods7 = new Goods(1006, "tomatoes", BigDecimal.valueOf(0.57), Category.FOOD, LocalDate.of(2024, 6, 23), 77, sellingPriceCalculator);
        Goods goods8 = new Goods(1007, "cigarettes", BigDecimal.valueOf(4.00), Category.NON_FOOD, LocalDate.of(2025, 12, 31),45 , sellingPriceCalculator);
        Goods goods9 = new Goods(1008, "cereal", BigDecimal.valueOf(1.14), Category.FOOD, LocalDate.of(2025, 2, 6), 82, sellingPriceCalculator);
        Goods goods10 = new Goods(1009, "tools", BigDecimal.valueOf(20.80), Category.NON_FOOD, LocalDate.of(2040, 11, 25), 25, sellingPriceCalculator);
        Goods goods11 = new Goods(1010, "sheets", BigDecimal.valueOf(35.60), Category.NON_FOOD, LocalDate.of(2035, 9, 30), 20, sellingPriceCalculator);
        Goods goods12 = new Goods(1011, "pasta", BigDecimal.valueOf(1.50), Category.FOOD, LocalDate.of(2026, 6, 15), 65, sellingPriceCalculator);

        CreatingGoods goods = new CreatingGoods(goods1, goods2, goods3, goods4, goods5, goods6, goods7, goods8, goods9, goods10, goods11,goods12);
        return goods;
    }

    private record CreatingGoods(Goods goods1, Goods goods2, Goods goods3, Goods goods4, Goods goods5, Goods goods6,Goods goods7,
                                 Goods goods8, Goods goods9,Goods goods10, Goods goods11, Goods goods12) {
    }

    private static CreatingLists getCreatingLists() {
        List<Cashier> cashiers = new ArrayList<>();
        List<Goods> inventory = new ArrayList<>();
        List<Receipt> receipts = new ArrayList<>();
        CreatingLists lists = new CreatingLists(cashiers, inventory, receipts);
        return lists;
    }

    private record CreatingLists(List<Cashier> cashiers, List<Goods> inventory, List<Receipt> receipts) {
    }
    //--------------------------Shop2------------------------
    private static CreatingAndPrintingCashiersShop2 getCreatingAndPrintingCashiersShop2() {
        Cashier cashier1 = new Cashier("John", 347);
        Cashier cashier2 = new Cashier("Jane", 348);

        System.out.println(cashier1);
        System.out.println(cashier2);
        CreatingAndPrintingCashiersShop2 cashiers = new CreatingAndPrintingCashiersShop2(cashier1, cashier2);
        return cashiers;
    }

    private record CreatingAndPrintingCashiersShop2(Cashier cashier1, Cashier cashier2) {
    }

    private static void AddingCashiersToShop2(CreatingLists lists, CreatingAndPrintingCashiersShop2 cashiers) {
        lists.cashiers().add(cashiers.cashier1());
        lists.cashiers().add(cashiers.cashier2());
    }

    private static void PrintCashiersSalaryShop2(CreatingAndPrintingCashiersShop2 cashiers) {
        BigDecimal salary1 = cashiers.cashier1().calculatingSalary(BigDecimal.valueOf(7.50), BigDecimal.valueOf(100));
        BigDecimal salary2 = cashiers.cashier2().calculatingSalary(BigDecimal.valueOf(8.50), BigDecimal.valueOf(120));

        cashiers.cashier1().setSalary(salary1);
        cashiers.cashier2().setSalary(salary2);

        System.out.println("Cashier 1's monthly salary: " + salary1);
        System.out.println("Cashier 2's monthly salary: " + salary2);
    }

    private static CreatingGoods2 getCreatingGoodsForShop2(SellingPriceCalculation sellingPriceCalculator) {
        Goods goods1 = new Goods(2000, "milk", BigDecimal.valueOf(1.20), Category.NON_FOOD, LocalDate.of(2024, 6, 20), 120, sellingPriceCalculator);
        Goods goods2 = new Goods(2001, "bread", BigDecimal.valueOf(0.95), Category.FOOD, LocalDate.of(2024, 6, 25), 130, sellingPriceCalculator);
        Goods goods3 = new Goods(2002, "shampoo", BigDecimal.valueOf(3.50), Category.NON_FOOD, LocalDate.of(2030, 8, 15), 90, sellingPriceCalculator);
        Goods goods4 = new Goods(2003, "cheese", BigDecimal.valueOf(2.50), Category.FOOD, LocalDate.of(2024, 7, 10), 75, sellingPriceCalculator);
        Goods goods5 = new Goods(2004, "oranges", BigDecimal.valueOf(0.50), Category.FOOD, LocalDate.of(2024, 6, 5), 85, sellingPriceCalculator);
        Goods goods6 = new Goods(2005, "detergent", BigDecimal.valueOf(4.30), Category.NON_FOOD, LocalDate.of(2031, 3, 20), 60, sellingPriceCalculator);
        Goods goods7 = new Goods(2006, "carrots", BigDecimal.valueOf(0.40), Category.FOOD, LocalDate.of(2024, 6, 30), 110, sellingPriceCalculator);
        Goods goods8 = new Goods(2007, "batteries", BigDecimal.valueOf(2.00), Category.NON_FOOD, LocalDate.of(2029, 12, 31), 50, sellingPriceCalculator);
        Goods goods9 = new Goods(2008, "rice", BigDecimal.valueOf(1.10), Category.FOOD, LocalDate.of(2025, 1, 10), 100, sellingPriceCalculator);
        Goods goods10 = new Goods(2009, "drill", BigDecimal.valueOf(45.00), Category.NON_FOOD, LocalDate.of(2045, 10, 1), 20, sellingPriceCalculator);
        Goods goods11 = new Goods(2010, "towels", BigDecimal.valueOf(15.00), Category.NON_FOOD, LocalDate.of(2037, 7, 15), 30, sellingPriceCalculator);
        Goods goods12 = new Goods(2011, "coffee", BigDecimal.valueOf(5.00), Category.NON_FOOD, LocalDate.of(2025, 12, 20), 140, sellingPriceCalculator);

        CreatingGoods2 goods = new CreatingGoods2(goods1, goods2, goods3, goods4, goods5, goods6, goods7, goods8, goods9, goods10, goods11, goods12);
        return goods;


    }

    private record CreatingGoods2(Goods goods1, Goods goods2, Goods goods3, Goods goods4, Goods goods5, Goods goods6,Goods goods7,
                                  Goods goods8, Goods goods9,Goods goods10, Goods goods11, Goods goods12) {
    }

    private static void PrintSellingPriceForGoods2(CreatingGoods2 goods2){
        System.out.println("Selling price for one milk: " + goods2.goods1().calculateSellingPrice());
        System.out.println("Selling price for one bread: " + goods2.goods2().calculateSellingPrice());
        System.out.println("Selling price for one shampoo: " + goods2.goods3().calculateSellingPrice());
        System.out.println("Selling price for one cheese: " + goods2.goods4().calculateSellingPrice());
        System.out.println("Selling price for one orange: " + goods2.goods5().calculateSellingPrice());
        System.out.println("Selling price for one detergent: " + goods2.goods6().calculateSellingPrice());
        System.out.println("Selling price for one carrot: " + goods2.goods7().calculateSellingPrice());
        System.out.println("Selling price for one battery: " + goods2.goods8().calculateSellingPrice());
        System.out.println("Selling price for one rice: " + goods2.goods9().calculateSellingPrice());
        System.out.println("Selling price for one drill: " + goods2.goods10().calculateSellingPrice());
        System.out.println("Selling price for one towel: " + goods2.goods11().calculateSellingPrice());
        System.out.println("Selling price for one coffee: " + goods2.goods12().calculateSellingPrice());
    }

    private static void CreatingAndPrintingReceiptsShop2(CashDesk cashDesk, Cashier randomCashier, CreatingCustomers2 customers, GetItemsFromCart2 itemsCart, IReceiptManager receiptManager,Shop shop2) {
        Receipt receipt = cashDesk.processPurchase(randomCashier, customers.customer(), itemsCart.purchaseMap());
        receipt.setShop(shop2);
        Receipt receipt2 = cashDesk.processPurchase(randomCashier, customers.customer2(), itemsCart.purchaseMap2());
        receipt2.setShop(shop2);
        Receipt receipt3 = cashDesk.processPurchase(randomCashier, customers.customer3(), itemsCart.purchaseMap3());
        receipt3.setShop(shop2);
        Receipt receipt4 = cashDesk.processPurchase(randomCashier, customers.customer4(), itemsCart.purchaseMap4());
        receipt4.setShop(shop2);
        Receipt receipt5 = cashDesk.processPurchase(randomCashier, customers.customer4(), itemsCart.purchaseMap5());
        receipt5.setShop(shop2);

        // Add the receipts to the receiptManager
        receiptManager.addReceipt(receipt);
        receiptManager.addReceipt(receipt2);
        receiptManager.addReceipt(receipt3);
        receiptManager.addReceipt(receipt4);
        receiptManager.addReceipt(receipt5);

        ReceiptFileHandler fileHandler = new ReceiptFileHandler();

        // Save the receipt to a file
        fileHandler.saveToFile(receipt,shop2.getShop_name());
        fileHandler.saveToFile(receipt2,shop2.getShop_name());
        fileHandler.saveToFile(receipt3,shop2.getShop_name());
        fileHandler.saveToFile(receipt4,shop2.getShop_name());
        fileHandler.saveToFile(receipt5,shop2.getShop_name());
    }

    private static CreatingCustomers2 getCreatingCustomers2(CreatingLists lists) {
        Customer customer1 = new Customer(0001, lists.inventory(), BigDecimal.valueOf(200.32));
        Customer customer2 = new Customer(0002, lists.inventory(), BigDecimal.valueOf(50.96));
        Customer customer3 = new Customer(0003, lists.inventory(), BigDecimal.valueOf(99990.06));
        Customer customer4 = new Customer(0004, lists.inventory(), BigDecimal.valueOf(99990.99));
        Customer customer5 = new Customer(0005, lists.inventory(), BigDecimal.valueOf(89.46));
        CreatingCustomers2 customers2 = new CreatingCustomers2(customer1, customer2, customer3, customer4,customer5);
        return customers2;
    }
    private record CreatingCustomers2 (Customer customer, Customer customer2, Customer customer3, Customer customer4, Customer customer5){

    }
    private static CreatingCartsAndAddingGoodsToCarts2 getCreatingCartsAndAddingGoodsToCarts2(CreatingCustomers2 customers2, CreatingGoods2 goods2){
        AddingToCart cart = new AddingToCart(customers2.customer());
        cart.addGoodsToCart(goods2.goods1(),1);
        cart.addGoodsToCart(goods2.goods2(),1);
        System.out.println("-------CARTS IN SHOP 2-------");
        System.out.println(cart);

        AddingToCart cart2 = new AddingToCart(customers2.customer2());
        cart2.addGoodsToCart(goods2.goods2(),1);
        cart2.addGoodsToCart(goods2.goods3(),1);
        System.out.println(cart2);

        AddingToCart cart3 = new AddingToCart(customers2.customer3());
        cart3.addGoodsToCart(goods2.goods6(),1);
        System.out.println(cart3);

        AddingToCart cart4 = new AddingToCart(customers2.customer4());
        cart4.addGoodsToCart(goods2.goods1(),1);
        cart4.addGoodsToCart(goods2.goods9(),1);
        cart4.addGoodsToCart(goods2.goods3(),1);
        cart4.addGoodsToCart(goods2.goods7(),1);
        cart4.addGoodsToCart(goods2.goods12(),1);
        System.out.println(cart4);

        AddingToCart cart5 = new AddingToCart(customers2.customer5());
        cart5.addGoodsToCart(goods2.goods2(),1);
        cart5.addGoodsToCart(goods2.goods1(),1);
        cart5.addGoodsToCart(goods2.goods8(),1);
        cart5.addGoodsToCart(goods2.goods6(),1);
        System.out.println(cart5);

        CreatingCartsAndAddingGoodsToCarts2 carts = new CreatingCartsAndAddingGoodsToCarts2(cart, cart2,cart3,cart4,cart5);
        return carts;

    }
    private record CreatingCartsAndAddingGoodsToCarts2(AddingToCart cart, AddingToCart cart2, AddingToCart cart3, AddingToCart cart4, AddingToCart cart5){

    }

    private static GetItemsFromCart2 getGetItemsFromCart2(CreatingCartsAndAddingGoodsToCarts2 carts){
        Map<Goods, Integer> purchaseMap = carts.cart().getShoppingCart();
        Map<Goods, Integer> purchaseMap2 = carts.cart2().getShoppingCart();
        Map<Goods, Integer> purchaseMap3 = carts.cart3().getShoppingCart();
        Map<Goods, Integer> purchaseMap4 = carts.cart4().getShoppingCart();
        Map<Goods, Integer> purchaseMap5 = carts.cart5().getShoppingCart();
        GetItemsFromCart2 itemsFromCart2 = new GetItemsFromCart2(purchaseMap, purchaseMap2, purchaseMap3, purchaseMap4, purchaseMap5);
        return itemsFromCart2;
    }
    private record GetItemsFromCart2(Map<Goods, Integer> purchaseMap, Map<Goods, Integer> purchaseMap2, Map<Goods, Integer> purchaseMap3, Map<Goods, Integer> purchaseMap4,Map<Goods, Integer> purchaseMap5 ){

    }
}