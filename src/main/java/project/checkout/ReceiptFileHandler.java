package project.checkout;

import java.io.*;

public class ReceiptFileHandler {

    public void saveToFile(Receipt receipt, String shopName) {
        if (receipt == null) {
            throw new IllegalArgumentException("Receipt cannot be null");
        }
        if (shopName == null || shopName.trim().isEmpty()) {
            throw new IllegalArgumentException("Shop name cannot be null or empty");
        }

        // Create the directory for this shop's receipts (if it doesn't exist)
        File directory = new File(shopName + " receipts");
        if (!directory.exists()) {
            directory.mkdir();
        }

        // Create the file in the directory with the receipt's ID as the filename
        File file = new File(directory, receipt.getId() + ".dat");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(receipt.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}