package project.inventory;

//interface that defines a method for checking if a certain amount of goods can be sold
public interface CanBeSold {
    boolean canBeSold(int desired_quantity, int available_quantity);
}
