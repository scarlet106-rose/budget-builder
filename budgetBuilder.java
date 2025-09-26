import java.util.ArrayList;
import java.util.Scanner;

public class budgetBuilder {
    public static void main(String[] args) {
        ArrayList<expenses> e = new ArrayList<>();
        double income = 0;
        //double budgetAmount = 0;
        Scanner scnr = new Scanner(System.in);

        System.out.println("Please Enter Income: ");
        income = scnr.nextDouble();
        budget b = new budget(income);


        System.out.println("Please Enter any expenses you have (Type 'done' when finished)");
        while (true) {
            System.out.println("Category: ");
            String category = scnr.next();

            if (category.equalsIgnoreCase("done")) {
                break;
            }

            System.out.println("Amount");
            double amount = scnr.nextDouble();

            b.addExpense(category, amount);
        }

        scnr.close();
        b.summary();

    }
}
