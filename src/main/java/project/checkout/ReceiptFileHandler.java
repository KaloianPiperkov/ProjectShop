// ReceiptFileHandler.java
package project.checkout;

import java.io.*;

public class ReceiptFileHandler {

    public void saveToFile(Receipt receipt, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(receipt.toString());
        } catch (IOException e) {
            e.printStackTrace();
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
