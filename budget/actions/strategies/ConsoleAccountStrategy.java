package budget.actions.strategies;

import budget.actions.ConsoleInterface;
import budget.model.Account;
import budget.model.AccountContext;
import budget.model.Expense;

import java.util.Scanner;

public class ConsoleAccountStrategy implements AccountStrategy {

    public void addExpense(AccountContext context) {
        Scanner scanner = context.getScanner();
        Account account = context.getAccount();

        boolean keepAdding = true;
        while (keepAdding) {
            ConsoleInterface.printAddExpensesMenu();
            int action = Integer.parseInt(scanner.nextLine());
            String category = switch (action) {
                case 1 -> "Food";
                case 2 -> "Clothes";
                case 3 -> "Entertainment";
                case 4 -> "Other";
                default -> "Reset";
            };
            if (category.equals("Reset")) keepAdding = false;
            else {
                System.out.println("\nEnter purchase name:");
                String name = scanner.nextLine();
                System.out.println("Enter its price:");
                double price = Double.parseDouble(scanner.nextLine());

                Expense expense = new Expense(name, category, price);
                context.getAccount().expenses.add(expense);

                account.balance -= price;
                if (account.balance < 0) account.balance = 0;

                System.out.println("Purchase was added!");
            }
        }
    }

    public void addIncome(AccountContext context) {
        System.out.println("\nEnter income:");
        String amount = context.getScanner().nextLine();
        context.getAccount().incomes.add(amount);
        context.getAccount().balance += Double.parseDouble(amount);
        System.out.println("Income was added!");
    }
}
