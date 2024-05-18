package project;

import project.cashier.Cashier;
import project.cashier.CashierManager;
import project.cashier.ICashierManager;
import project.checkout.*;
import project.customer.AddingToCart;
import project.customer.Customer;
import project.inventory.*;
import project.shop.Shop;
import project.shop.ShopCosts;
import project.shop.ShopIncome;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        CreatingLists lists = getCreatingLists();

        SellingPriceCalculation sellingPriceCalculator = new GoodsSellingPriceCalculator();

        //creating the goods
        CreatingGoods goods = getCreatingGoods(sellingPriceCalculator);

        //printing the goods
        PrintGoods(goods);

        //printing the selling price of these goods
        PrintSellingPriceForGoods(goods);

        CreatingAndPrintingCashiers cashiers = getCreatingAndPrintingCashiers();

        //adding the cashiers to the shop
        AddingCashiersToShop(lists, cashiers);

        //printing their salaries
        PrintCashiersSalary(cashiers);

        CreatingCustomers customers = getCreatingCustomers(lists);

        CreatingCartsAndAddingGoodsToCards carts = getCreatingCartsAndAddingGoodsToCards(customers, goods);

        ICashierManager cashierManager = new CashierManager();
        IInventoryManager inventoryManager = new InventoryManager();
        IReceiptManager receiptManager = new ReceiptManager();

        // Add cashiers, goods, and receipts to their respective managers
        cashierManager.addCashier(cashiers.cashier1());
        cashierManager.addCashier(cashiers.cashier2());
        inventoryManager.addGoods(goods.goods1());
        inventoryManager.addGoods(goods.goods2());
        inventoryManager.addGoods(goods.goods3());

        // Process the purchase at the cash desk
        CashDesk cashDesk = new CashDesk(receiptManager.getReceipts());

        // Get the items from the customer's cart
        GetItemsFromCart itemsCart = getGetItemsFromCart(carts);

        // Use randomCashier for the purchase
        Cashier randomCashier = RandomizeCashier(lists);

        Receipt receipt = cashDesk.processPurchase(randomCashier, customers.customer(), itemsCart.purchaseMap());
        Receipt receipt2 = cashDesk.processPurchase(randomCashier, customers.customer(), itemsCart.purchaseMap2());

        receiptManager.addReceipt(receipt);
        receiptManager.addReceipt(receipt2);

        ShopIncome shopIncome = new ShopIncome(receiptManager.getReceipts());
        ShopCosts shopCosts = new ShopCosts(cashierManager.getCashiers(), inventoryManager.getInventory());

        Shop shop = new Shop("Lidl", cashierManager, inventoryManager, receiptManager, shopCosts, shopIncome);
        System.out.println(shop);
    }

    private static void CreatingAndPrintingReceipts(CashDesk cashDesk, Cashier randomCashier, CreatingCustomers customers, GetItemsFromCart itemsCart) {
        Receipt receipt = cashDesk.processPurchase(randomCashier, customers.customer(), itemsCart.purchaseMap());
        Receipt receipt2 = cashDesk.processPurchase(randomCashier, customers.customer(), itemsCart.purchaseMap2());

        ReceiptFileHandler fileHandler = new ReceiptFileHandler();

        // Save the receipt to a file
        String filename = receipt.getId() + ".dat";
        String filename2 = receipt2.getId() + ".dat";
        fileHandler.saveToFile(receipt);
        fileHandler.saveToFile(receipt2);

        // Read the receipt from the file
        Receipt readReceipt = fileHandler.readFromFile(filename);
        Receipt readReceipt2 = fileHandler.readFromFile(filename2);

        System.out.println(readReceipt);
        System.out.println(readReceipt2);
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
        System.out.println("Cashier 1's monthly salary: " + cashiers.cashier1().calculatingSalary(BigDecimal.valueOf(7.50), BigDecimal.valueOf(170)));
        System.out.println("Cashier 2's monthly salary: " + cashiers.cashier2().calculatingSalary(BigDecimal.valueOf(8.50), BigDecimal.valueOf(160)));
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