package project.customer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;

public class CustomerGenerator {
    private final Random random = new Random();

    public Customer generateCustomer() {
        int id = random.nextInt(1000);
        BigDecimal budget = BigDecimal.valueOf(random.nextInt(200));
        return new Customer(id, new ArrayList<>(), budget);
    }
}
