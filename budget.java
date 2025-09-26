import java.util.ArrayList;

public class budget {
    
    private double income;
    private ArrayList<expenses> e = new ArrayList<>();

    public budget(double income) {
        this.income = income;
    }

    public void addExpense(String category, double amount) {
        e.add(new expenses(category, amount));
    }
    
    public double getTotalExpenses() {
        double total = 0;
        for (expenses expense : e) {
            total += expense.getAmount();
        }
        return total;
    }

    public double totalRemainingIncome() {
        return income - getTotalExpenses();
    }

    public void getPercentages() {
        for (expenses expense : e) {
            double percentage = (expense.getAmount() / income) * 100;
            System.out.printf("%.2f%% of income goes to %s%n", percentage, expense.getCategory());
        }
    }

    public void summary() {
        System.out.println("Total expenses for this pay period have added up to " + getTotalExpenses() + ". Total remaining income is " + totalRemainingIncome() + ".");
        getPercentages();
        if(overLimit()) {
            System.out.println("WARNING!! : You are over budget!!");
        }
    }

    public boolean overLimit() {
        if (income < getTotalExpenses()) {
            return true;
        }
        return false;
    }

}
