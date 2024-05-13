package project;


import project.cashier.Cashier;
import project.customer.Customer;
import project.inventory.*;
import project.shop.Shop;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        List<Cashier> cashiers = new ArrayList<>();
        List<Goods> inventory = new ArrayList<>();
        List<Receipt> receipts = new ArrayList<>();

        Shop shop = new Shop("Lidl", cashiers, inventory, receipts, 0,0);

        //creating the goods
        Goods goods1 = new Goods(1000, "apples", 10, Category.FOOD, LocalDate.of(2024, 4, 7), 50);
        Goods goods2 = new Goods(1001, "strawberries", 13, Category.FOOD, LocalDate.of(2024, 6, 30), 150);
        Goods goods3 = new Goods(1002, "toilet paper", 6, Category.NON_FOOD, LocalDate.of(2030, 6, 15), 200);

        //adding the goods to the array list
        inventory.add(goods1);
        inventory.add(goods2);
        inventory.add(goods3);

        //printing the goods
        System.out.println(goods1);
        System.out.println(goods2);
        System.out.println(goods3);

        //printing the selling price of these goods
        System.out.println("Selling price for apples: " + goods1.calculatingSellingPrice()); //almost expired
        System.out.println("Selling price for strawberries: " + goods2.calculatingSellingPrice()); //not expired
        System.out.println("Selling price for toilet paper: " + goods3.calculatingSellingPrice()); //not expired


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

        CashDesk cashDesk = new CashDesk(cashier1);
        Customer customer = new Customer(0001, inventory, 120.32);
        Receipt receipt = new Receipt();

        System.out.println(inventory);

    }
}