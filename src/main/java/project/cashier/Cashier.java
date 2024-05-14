//Cashiers work at the shop. They have name, id and monthly payment (salary).
//Every cashier work at a cash-desk in the shop. Cashiers mark the goods that clients want to buy.
//If the client has enough money to buy the goods, cashiers give them a receipt.

package project.cashier;

public class Cashier extends Salary{
    private String name_of_cashier;
    private long id_of_cashier;
    //private double salary_of_cashier_per_hour;
    //private int hour_worked;

    public Cashier(String name_of_cashier, long id_of_cashier) {
        this.name_of_cashier = name_of_cashier;
        this.id_of_cashier = id_of_cashier;
        //this.salary_of_cashier_per_hour = salary_of_cashier_per_hour;
        //this.hour_worked = hour_worked;
    }

    public String getName_of_cashier() {
        return name_of_cashier;
    }

    public long getId_of_cashier() {
        return id_of_cashier;
    }

    @Override
    public String toString() {
        return "Cashier{" +
                "name_of_cashier='" + name_of_cashier + '\'' +
                ", id_of_cashier=" + id_of_cashier +
                '}';
    }

    public char[] getName() {
        return name_of_cashier.toCharArray();
    }


    //    public double calculateMonthlySalary(){
//        double salary = 0.0;
//        if(getHour_worked() > 0){
//            salary = getHour_worked()*getSalary_of_cashier_per_hour();
//            return salary;
//        }
//        else {
//            System.out.println("Cashier has not worked any hours this month.");
//            return 0;
//        }
}

