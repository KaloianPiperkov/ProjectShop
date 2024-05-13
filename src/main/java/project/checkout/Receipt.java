//The receipt has: id, cashier that creates it, date and time, list of goods with quantity and price,
// total value of all the sold goods, that the client has to pay.
//It is necessary to keep the total number of the created receipts and the total value of all the sold goods.
// When a receipt is created it has to be saved in a file. The name of the file has to be the id of the receipt.
// The information in the files have to be read.

package project.checkout;

import project.cashier.Cashier;
import project.inventory.Goods;

import java.time.chrono.ChronoLocalDateTime;
import java.util.List;

public class Receipt {
    private long id_receipt;
    private Cashier cashier; //the cashier that creates it;
    private ChronoLocalDateTime date_and_time_of_creation;      //LocalDateTime??
    private List<Goods> goods_bought; //with quantity and price
    private double total_value;

    //when the receipt is created it need to be stored in a file!

}

