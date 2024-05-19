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

        System.out.println("\n");
        System.out.println("--Information about the shop before adding cashiers, inventory and creating receipts---");
        ICashierManager cashierManager = new CashierManager();
        IInventoryManager inventoryManager = new InventoryManager();
        IReceiptManager receiptManager = new ReceiptManager();

        ShopIncome shopIncome = new ShopIncome(receiptManager.getReceipts());
        ShopCosts shopCosts = new ShopCosts(cashierManager.getCashiers(), inventoryManager.getInventory());

        Shop shop = new Shop("Lidl", cashierManager, inventoryManager, receiptManager, shopCosts, shopIncome, BigDecimal.valueOf(8.5), BigDecimal.valueOf(4.0));
        Shop shop2 = new Shop("Kaufland", cashierManager, inventoryManager, receiptManager, shopCosts, shopIncome, BigDecimal.valueOf(10.5), BigDecimal.valueOf(6.0));
        List<Shop> shops = new ArrayList<>();
        shops.add(shop);
        shops.add(shop2);
        System.out.println(shop);


        CreatingLists lists = getCreatingLists();

        OverchargeCalculator overchargeCalculator = new OverchargeCalculator();

        CashDesk cashDesk = new CashDesk(lists.receipts());
        System.out.println("\n");
        System.out.println("---Information about the cashiers---");
        CreatingAndPrintingCashiers cashiers = getCreatingAndPrintingCashiers();
        //adding the cashiers to the shop
        AddingCashiersToShop(lists, cashiers);
        //printing their salaries
        PrintCashiersSalary(cashiers);
        Cashier randomCashier = RandomizeCashier(lists);

        System.out.println("\n");

        CreatingCustomers customers = getCreatingCustomers(lists);

        // Add cashiers, goods, and receipts to their respective managers
        cashierManager.addCashier(cashiers.cashier1());
        cashierManager.addCashier(cashiers.cashier2());

        SellingPriceCalculation sellingPriceCalculator = new GoodsSellingPriceCalculator(overchargeCalculator,shop);
        SellingPriceCalculation sellingPriceCalculator2 = new GoodsSellingPriceCalculator(overchargeCalculator,shop2);

        CreatingGoods goods = getCreatingGoods(sellingPriceCalculator);
        CreatingGoods goods2 = getCreatingGoods(sellingPriceCalculator2);

        CreatingCartsAndAddingGoodsToCards carts = getCreatingCartsAndAddingGoodsToCards(customers, goods);
        inventoryManager.addGoods(goods.goods1());
        inventoryManager.addGoods(goods.goods2());
        inventoryManager.addGoods(goods.goods3());

        // Process the purchase at the cash desk
        GetItemsFromCart itemsCart = getGetItemsFromCart(carts);

        System.out.println("---Printing the goods added to the shop---");
        //printing the goods
        PrintGoods(goods);

        System.out.println("\n");
        System.out.println("---Printing the price per one item---");
        //printing the selling price of these goods
        PrintSellingPriceForGoods(goods);
        PrintSellingPriceForGoods(goods2);
        CreatingAndPrintingReceipts(cashDesk,randomCashier,customers, itemsCart, receiptManager);

        System.out.println("\n");

        System.out.println("---Shop's cost: " + shopCosts.calculateTotalCost() + " -----");
        System.out.println("---Shop's income: " + shopIncome.calculateTotalIncome() + "-----");

        BigDecimal totalIncome = shopIncome.calculateTotalIncome();
        BigDecimal totalCosts = shopCosts.calculateTotalCost();
        ProfitCalculator profitCalculator = new ProfitCalculator(totalIncome,totalCosts);
        BigDecimal profit = profitCalculator.calculateProfit();
        System.out.println("---Shop's Profit: " + profit + "-----");

        System.out.println("\n");
        System.out.println("----Information about the shop after purchases have been made----");
        System.out.println(shop);

        System.out.println("\n");
        System.out.println("Checking what is inside the inventoryManager: ");
        System.out.println(inventoryManager);
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
        Map<Goods, Integer> purchaseMap = carts.cart().getShoppingCart(); // assuming you have a getShoppingCart method in AddingToCart
        Map<Goods, Integer> purchaseMap2 = carts.cart2().getShoppingCart(); // assuming you have a getShoppingCart method in AddingToCart
        GetItemsFromCart itemsCart = new GetItemsFromCart(purchaseMap, purchaseMap2);
        return itemsCart;
    }

    private record GetItemsFromCart(Map<Goods, Integer> purchaseMap, Map<Goods, Integer> purchaseMap2) {
    }

    private static CreatingCartsAndAddingGoodsToCards getCreatingCartsAndAddingGoodsToCards(CreatingCustomers customers, CreatingGoods goods) {
        AddingToCart cart = new AddingToCart(customers.customer());
        cart.addGoodsToCart(goods.goods2(), 5);
        cart.addGoodsToCart(goods.goods3(), 5);
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
        Customer customer2 = new Customer(0002, lists.inventory(), BigDecimal.valueOf(120.30));
        CreatingCustomers customers = new CreatingCustomers(customer, customer2);
        return customers;
    }

    private record CreatingCustomers(Customer customer, Customer customer2) {
    }

    private static void PrintCashiersSalary(CreatingAndPrintingCashiers cashiers) {
        BigDecimal salary1 = cashiers.cashier1().calculatingSalary(BigDecimal.valueOf(7.50), BigDecimal.valueOf(170));
        BigDecimal salary2 = cashiers.cashier2().calculatingSalary(BigDecimal.valueOf(8.50), BigDecimal.valueOf(160));

        cashiers.cashier1().setSalary(salary1);
        cashiers.cashier2().setSalary(salary2);

        System.out.println("Cashier 1's monthly salary: " + salary1);
        System.out.println("Cashier 2's monthly salary: " + salary2);
    }

    private static void AddingCashiersToShop(CreatingLists lists, CreatingAndPrintingCashiers cashiers) {
        lists.cashiers().add(cashiers.cashier1());
        lists.cashiers().add(cashiers.cashier2());
    }

    private static CreatingAndPrintingCashiers getCreatingAndPrintingCashiers() {
        Cashier cashier1 = new Cashier("Maria", 345);
        Cashier cashier2 = new Cashier("Alex", 346);

        System.out.println(cashier1);
        System.out.println(cashier2);
        CreatingAndPrintingCashiers cashiers = new CreatingAndPrintingCashiers(cashier1, cashier2);
        return cashiers;
    }

    private record CreatingAndPrintingCashiers(Cashier cashier1, Cashier cashier2) {
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
        Goods goods1 = new Goods(1000, "apples", BigDecimal.valueOf(10.35), Category.FOOD, LocalDate.of(2024, 4, 7), 50, sellingPriceCalculator);
        Goods goods2 = new Goods(1001, "strawberries", BigDecimal.valueOf(13.5), Category.FOOD, LocalDate.of(2024, 6, 30), 150, sellingPriceCalculator);
        Goods goods3 = new Goods(1002, "toilet paper", BigDecimal.valueOf(6.03), Category.NON_FOOD, LocalDate.of(2030, 6, 15), 200, sellingPriceCalculator);
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
}