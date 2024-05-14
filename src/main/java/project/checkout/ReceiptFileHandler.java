// ReceiptFileHandler.java
package project.checkout;

import java.io.*;

public class ReceiptFileHandler {

    public void saveToFile(Receipt receipt) {
        String filename = receipt.getId() + ".dat"; // Use .dat extension for serialized files
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(receipt);                          // Write the Receipt object to the file
            System.out.println("Receipt saved to file: " + filename);
        } catch (IOException e) {
            System.out.println("Error occurred while saving receipt to file: " + e.getMessage());
        }
    }

    public Receipt readFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (Receipt) ois.readObject(); // Read the Receipt object from the file
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error occurred while reading receipt from file: " + e.getMessage());
            return null;
        }
    }
}