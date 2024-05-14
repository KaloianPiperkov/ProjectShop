package project;


import project.cashier.Cashier;
import project.checkout.CashDesk;
import project.checkout.Receipt;
import project.customer.AddingToCart;
import project.customer.Customer;
import project.inventory.*;
import project.shop.Shop;

import java.time.LocalDate;
import java.util.*;


public class Main {
    public static void main(String[] args) {

        List<Cashier> cashiers = new ArrayList<>();
        List<Goods> inventory = new ArrayList<>();
        List<Receipt> receipts = new ArrayList<>();

        Shop shop = new Shop("Lidl", cashiers, inventory, receipts, 0,0);

        SellingPriceCalculation sellingPriceCalculator = new GoodsSellingPriceCalculator();

        //creating the goods
        Goods goods1 = new Goods(1000, "apples", 10, Category.FOOD, LocalDate.of(2024, 4, 7), 50,sellingPriceCalculator);
        Goods goods2 = new Goods(1001, "strawberries", 13, Category.FOOD, LocalDate.of(2024, 6, 30), 150, sellingPriceCalculator);
        Goods goods3 = new Goods(1002, "toilet paper", 6, Category.NON_FOOD, LocalDate.of(2030, 6, 15), 200, sellingPriceCalculator);

//        //adding the goods to the array list
//        inventory.add(goods1);
//        inventory.add(goods2);
//        inventory.add(goods3);

        //printing the goods
        System.out.println(goods1);
        System.out.println(goods2);
        System.out.println(goods3);

        //printing the selling price of these goods
        System.out.println("Selling price for 1 apple: " + goods1.calculateSellingPrice()); //almost expired
        System.out.println("Selling price for 1 strawberries: " + goods2.calculateSellingPrice()); //not expired
        System.out.println("Selling price for 1 toilet paper: " + goods3.calculateSellingPrice()); //not expired


        Cashier cashier1 = new Cashier("Maria", 345);
        Cashier cashier2 = new Cashier("Alex", 346);

        System.out.println(cashier1);
        System.out.println(cashier2);

        //adding the cashiers to the shop
        cashiers.add(cashier1);
        cashiers.add(cashier2);
        //printing their salaries

        System.out.println("Cashier 1's monthly salary: " +cashier1.calculatingSalary(7.50, 170));
        System.out.println("Cashier 2's monthly salary: " +cashier2.calculatingSalary(8.50, 178));


        Customer customer = new Customer(0001, inventory, 120.32);
        AddingToCart cart = new AddingToCart(customer);
        cart.addGoodsToCart(goods2, 5);
        cart.addGoodsToCart(goods3, 5);
        System.out.println(cart);

        CashDesk cashDesk = new CashDesk(receipts);

        // Get the items from the customer's cart
        Map<Goods, Integer> purchaseMap = cart.getShoppingCart(); // assuming you have a getShoppingCart method in AddingToCart

// Process the purchase at the cash desk
        Random random = new Random();
        int randomIndex = random.nextInt(cashiers.size());
        Cashier randomCashier = cashiers.get(randomIndex);

// Use randomCashier for the purchase
        Receipt receipt = cashDesk.processPurchase(randomCashier, customer, purchaseMap);

// Print the receipt
        System.out.println(receipt);


    }
}