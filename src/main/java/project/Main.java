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
        System.out.println("\n");
        System.out.println("--Information about the shop1 before adding cashiers, inventory and creating receipts---");

        ICashierManager cashierManager1 = new CashierManager();
        IInventoryManager inventoryManager1 = new InventoryManager();
        IReceiptManager receiptManager1 = new ReceiptManager();

        ShopIncome shopIncome1 = new ShopIncome(receiptManager1.getReceipts());
        ShopCosts shopCosts1 = new ShopCosts(cashierManager1.getCashiers(), inventoryManager1.getInventory());

        Shop shop = new Shop("Lidl", cashierManager1, inventoryManager1, receiptManager1, shopCosts1, shopIncome1, BigDecimal.valueOf(8.5), BigDecimal.valueOf(4.0));

        List<Shop> shops = new ArrayList<>();
        shops.add(shop);

        System.out.println(shop);

        CreatingLists lists1 = getCreatingLists();

        OverchargeCalculator overchargeCalculator = new OverchargeCalculator();

        CashDesk cashDesk1 = new CashDesk(lists1.receipts());
        System.out.println("\n");
        System.out.println("---Information about the cashiers in shop1---");
        CreatingAndPrintingCashiersShop1 cashiers = getCreatingAndPrintingCashiersShop1();
        //adding the cashiers to the shop
        AddingCashiersToShop1(lists1, cashiers);
        //printing their salaries
        PrintCashiersSalary(cashiers);
        Cashier randomCashier = RandomizeCashier(lists1);

        System.out.println("\n");

        CreatingCustomers customers = getCreatingCustomers(lists1);

        // Add cashiers, goods, and receipts to their respective managers
        cashierManager1.addCashier(cashiers.cashier1());
        cashierManager1.addCashier(cashiers.cashier2());

        SellingPriceCalculation sellingPriceCalculator = new GoodsSellingPriceCalculator(overchargeCalculator,shop);

        CreatingGoods goods = getCreatingGoods(sellingPriceCalculator);


        inventoryManager1.addGoods(goods.goods1());
        inventoryManager1.addGoods(goods.goods2());
        inventoryManager1.addGoods(goods.goods3());

        System.out.println("\n");
        System.out.println("---Printing the goods added to the shop1---");
        //printing the goods
        PrintGoods(goods);
        // Process the purchase at the cash desk

        CreatingCartsAndAddingGoodsToCards carts = getCreatingCartsAndAddingGoodsToCards(customers, goods);
        GetItemsFromCart itemsCart = getGetItemsFromCart(carts);
        System.out.println("---Printing itemsCart of customer in shop1: " + itemsCart);


        System.out.println("\n");
        System.out.println("---Printing the price per one item for shop1---");
        //printing the selling price of these goods
        PrintSellingPriceForGoods(goods);


        CreatingAndPrintingReceipts(cashDesk1,randomCashier,customers, itemsCart, receiptManager1);

        System.out.println("\n");

        System.out.println("---Shop1 cost: " + shopCosts1.calculateTotalCost() + " -----");
        System.out.println("---Shop1 income: " + shopIncome1.calculateTotalIncome() + "-----");

        BigDecimal totalIncome = shopIncome1.calculateTotalIncome();
        BigDecimal totalCosts = shopCosts1.calculateTotalCost();
        ProfitCalculator profitCalculator = new ProfitCalculator(totalIncome,totalCosts);
        BigDecimal profit = profitCalculator.calculateProfit();
        System.out.println("---Shop1 Profit: " + profit + "-----");

        System.out.println("\n");
        System.out.println("----Information about the shop1 after purchases have been made----");
        System.out.println(shop);

        System.out.println("\n");
        System.out.println("Checking what is inside the inventoryManager1 after purchases: ");
        System.out.println(inventoryManager1);



        //-----------------SHOP2--------------------------

        System.out.println("---Information about shop2---");
        ICashierManager cashierManager2 = new CashierManager();
        IInventoryManager inventoryManager2 = new InventoryManager();
        IReceiptManager receiptManager2 = new ReceiptManager();


        ShopIncome shopIncome2 = new ShopIncome(receiptManager1.getReceipts());
        ShopCosts shopCosts2 = new ShopCosts(cashierManager1.getCashiers(), inventoryManager1.getInventory());

        //Creating shop2
        Shop shop2 = new Shop("Kaufland", cashierManager2, inventoryManager2, receiptManager2, shopCosts2, shopIncome2, BigDecimal.valueOf(10.5), BigDecimal.valueOf(6.0));
        shops.add(shop2);
        System.out.println("\n");
        
        CreatingLists lists2 = getCreatingLists();
        CashDesk cashDesk2 = new CashDesk(lists2.receipts());
        System.out.println("\n");
        System.out.println("---Information about the cashiers in shop2---");
    
        //Adding new cashiers to shop2
        CreatingAndPrintingCashiersShop2 cashiers2 = getCreatingAndPrintingCashiersShop2();
        AddingCashiersToShop2(lists2, cashiers2);
        PrintCashiersSalaryShop2(cashiers2);
        Cashier randomCashier2 = RandomizeCashier(lists2);

        cashierManager2.addCashier(cashiers2.cashier1());
        cashierManager2.addCashier(cashiers2.cashier2());


        System.out.println(shop2);

        SellingPriceCalculation sellingPriceCalculator2 = new GoodsSellingPriceCalculator(overchargeCalculator,shop2);
        CreatingGoods2 goods2 = getCreatingGoodsForShop2(sellingPriceCalculator2);

        inventoryManager2.addGoods(goods2.goods1());
        inventoryManager2.addGoods(goods2.goods2());
        inventoryManager2.addGoods(goods2.goods3());

        PrintGoods2(goods2);

        System.out.println("\n");
        System.out.println("---Printing the price per one item for shop2---");
        PrintSellingPriceForGoods2(goods2);

        CreatingCustomers2 customers2 = getCreatingCustomers2(lists2);

        CreatingCartsAndAddingGoodsToCarts2 carts2 = getCreatingCartsAndAddingGoodsToCarts2(customers2, goods2);
        GetItemsFromCart2 itemsCart2 = getGetItemsFromCart2(carts2);
        CreatingAndPrintingReceiptsShop2(cashDesk2,randomCashier2,customers2, itemsCart2, receiptManager2);

        System.out.println("----Shop2 cost: " + shopCosts2.calculateTotalCost() + "-----");
        System.out.println("----Shop2 income: " + shopIncome2.calculateTotalIncome() + "-----");

        BigDecimal totalIncome2 = shopIncome2.calculateTotalIncome();
        BigDecimal totalCost2 = shopCosts2.calculateTotalCost();

        ProfitCalculator profitCalculator2 = new ProfitCalculator(totalIncome2, totalCost2);

        BigDecimal profit2 = profitCalculator2.calculateProfit();
        System.out.println("----Shop2 profit: " + profit2 + "---------");

        System.out.println(shop2);
    }
    private static void CreatingAndPrintingReceipts(CashDesk cashDesk, Cashier randomCashier, CreatingCustomers customers, GetItemsFromCart itemsCart, IReceiptManager receiptManager) {
        Receipt receipt = cashDesk.processPurchase(randomCashier, customers.customer(), itemsCart.purchaseMap());
        Receipt receipt2 = cashDesk.processPurchase(randomCashier, customers.customer(), itemsCart.purchaseMap2());

        // Add the receipts to the receiptManager
        receiptManager.addReceipt(receipt);
        receiptManager.addReceipt(receipt2);

        ReceiptFileHandler fileHandler = new ReceiptFileHandler();

        // Save the receipt to a file
        String filename = receipt.getId() + ".dat";
        String filename2 = receipt2.getId() + ".dat";
        fileHandler.saveToFile(receipt,filename);
        fileHandler.saveToFile(receipt2,filename2);
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
        GetItemsFromCart itemsCart = new GetItemsFromCart(purchaseMap, purchaseMap2);
        return itemsCart;
    }

    private record GetItemsFromCart(Map<Goods, Integer> purchaseMap, Map<Goods, Integer> purchaseMap2) {
    }

    private static CreatingCartsAndAddingGoodsToCards getCreatingCartsAndAddingGoodsToCards(CreatingCustomers customers, CreatingGoods goods) {
        AddingToCart cart = new AddingToCart(customers.customer());
        cart.addGoodsToCart(goods.goods2(), 5);
        cart.addGoodsToCart(goods.goods3(), 5);
        System.out.println("---CARTS---");
        System.out.println(cart);

        AddingToCart cart2 = new AddingToCart(customers.customer2());
        cart2.addGoodsToCart(goods.goods1(), 6);
        cart2.addGoodsToCart(goods.goods2(), 3);
        System.out.println(cart2);
        CreatingCartsAndAddingGoodsToCards carts = new CreatingCartsAndAddingGoodsToCards(cart, cart2);
        return carts;
    }

    private record CreatingCartsAndAddingGoodsToCards(AddingToCart cart, AddingToCart cart2) {
    }

    private static CreatingCustomers getCreatingCustomers(CreatingLists lists) {
        Customer customer = new Customer(0001, lists.inventory(), BigDecimal.valueOf(120.32));
        Customer customer2 = new Customer(0002, lists.inventory(), BigDecimal.valueOf(35.96));
        CreatingCustomers customers = new CreatingCustomers(customer, customer2);
        return customers;
    }

    private record CreatingCustomers(Customer customer, Customer customer2) {
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
        System.out.println("Selling price for 1 apple: " + goods.goods1().calculateSellingPrice()); //almost expired
        System.out.println("Selling price for 1 strawberries: " + goods.goods2().calculateSellingPrice()); //not expired
        System.out.println("Selling price for 1 toilet paper: " + goods.goods3().calculateSellingPrice()); //not expired
    }

    private static void PrintGoods(CreatingGoods goods) {
        System.out.println(goods.goods1());
        System.out.println(goods.goods2());
        System.out.println(goods.goods3());
    }

    private static CreatingGoods getCreatingGoods(SellingPriceCalculation sellingPriceCalculator) {
        Goods goods1 = new Goods(1000, "apples", BigDecimal.valueOf(0.18), Category.FOOD, LocalDate.of(2024, 4, 7), 50, sellingPriceCalculator);
        Goods goods2 = new Goods(1001, "strawberries", BigDecimal.valueOf(0.62), Category.FOOD, LocalDate.of(2024, 6, 30), 150, sellingPriceCalculator);
        Goods goods3 = new Goods(1002, "toilet paper", BigDecimal.valueOf(0.70), Category.NON_FOOD, LocalDate.of(2030, 6, 15), 200, sellingPriceCalculator);
        CreatingGoods goods = new CreatingGoods(goods1, goods2, goods3);
        return goods;
    }

    private record CreatingGoods(Goods goods1, Goods goods2, Goods goods3) {
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

    private static void AddingGoodsToShop2(CreatingLists lists, CreatingGoods goods) {
        lists.inventory().add(goods.goods1());
        lists.inventory().add(goods.goods2());
        lists.inventory().add(goods.goods3());
    }
    private static CreatingGoods2 getCreatingGoodsForShop2(SellingPriceCalculation sellingPriceCalculator) {
        Goods goods1 = new Goods(1000, "oranges", BigDecimal.valueOf(0.27), Category.FOOD, LocalDate.of(2024, 5, 7), 50, sellingPriceCalculator);
        Goods goods2 = new Goods(1001, "cheese", BigDecimal.valueOf(2.30), Category.FOOD, LocalDate.of(2024, 7, 30), 150, sellingPriceCalculator);
        Goods goods3 = new Goods(1002, "chairs", BigDecimal.valueOf(15.80), Category.NON_FOOD, LocalDate.of(2030, 7, 15), 200, sellingPriceCalculator);
        CreatingGoods2 goods = new CreatingGoods2(goods1, goods2, goods3);
        return goods;
    }

    private record CreatingGoods2(Goods goods1, Goods goods2, Goods goods3){

    }
    private static void PrintGoods2(CreatingGoods2 goods2){
        System.out.println(goods2.goods1());
        System.out.println(goods2.goods2());
        System.out.println(goods2.goods3());
    }

    private static void PrintSellingPriceForGoods2(CreatingGoods2 goods2){
        System.out.println("Selling price for one orange: " + goods2.goods1().calculateSellingPrice());
        System.out.println("Selling price for one cheese: " + goods2.goods2().calculateSellingPrice());
        System.out.println("Selling price for one chair: " + goods2.goods3().calculateSellingPrice());
    }

    private static void CreatingAndPrintingReceiptsShop2(CashDesk cashDesk, Cashier randomCashier, CreatingCustomers2 customers, GetItemsFromCart2 itemsCart, IReceiptManager receiptManager) {
        Receipt receipt = cashDesk.processPurchase(randomCashier, customers.customer(), itemsCart.purchaseMap());
        Receipt receipt2 = cashDesk.processPurchase(randomCashier, customers.customer2(), itemsCart.purchaseMap2());

        // Add the receipts to the receiptManager
        receiptManager.addReceipt(receipt);
        receiptManager.addReceipt(receipt2);

        ReceiptFileHandler fileHandler = new ReceiptFileHandler();

        // Save the receipt to a file
        String filename = receipt.getId() + ".dat";
        String filename2 = receipt2.getId() + ".dat";
        fileHandler.saveToFile(receipt,filename);
        fileHandler.saveToFile(receipt2,filename2);
    }

    private static CreatingCustomers2 getCreatingCustomers2(CreatingLists lists) {
        Customer customer1 = new Customer(0003, lists.inventory(), BigDecimal.valueOf(200.32));
        Customer customer2 = new Customer(0004, lists.inventory(), BigDecimal.valueOf(50.96));
        CreatingCustomers2 customers2 = new CreatingCustomers2(customer1, customer2);
        return customers2;
    }
    private record CreatingCustomers2 (Customer customer, Customer customer2){

    }
    private static CreatingCartsAndAddingGoodsToCarts2 getCreatingCartsAndAddingGoodsToCarts2(CreatingCustomers2 customers2, CreatingGoods2 goods2){
        AddingToCart cart2 = new AddingToCart(customers2.customer());
        cart2.addGoodsToCart(goods2.goods1(),10);
        cart2.addGoodsToCart(goods2.goods2(),1);
        System.out.println("-------Carts2-------");
        System.out.println(cart2);

        AddingToCart cart3 = new AddingToCart(customers2.customer2());
        cart3.addGoodsToCart(goods2.goods2(),15);
        cart3.addGoodsToCart(goods2.goods3(),5);
        System.out.println(cart3);
        CreatingCartsAndAddingGoodsToCarts2 carts = new CreatingCartsAndAddingGoodsToCarts2(cart2,cart3);
        return carts;

    }
    private record CreatingCartsAndAddingGoodsToCarts2(AddingToCart cart2, AddingToCart cart3){

    }

    private static GetItemsFromCart2 getGetItemsFromCart2(CreatingCartsAndAddingGoodsToCarts2 carts){
        Map<Goods, Integer> purchaseMap = carts.cart2().getShoppingCart();
        Map<Goods, Integer> purchaseMap2 = carts.cart3().getShoppingCart();
        GetItemsFromCart2 itemsFromCart2 = new GetItemsFromCart2(purchaseMap, purchaseMap2);
        return itemsFromCart2;
    }
    private record GetItemsFromCart2(Map<Goods, Integer> purchaseMap, Map<Goods, Integer> purchaseMap2){

    }
}