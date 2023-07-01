package budget;

import budget.actions.AccountManager;
import budget.actions.ConsoleInterface;
import budget.model.Account;
import budget.model.AccountContext;
import budget.utils.ManageFiles;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        File file = ManageFiles.createFile("./purchases.txt");
        Account account = new Account();

        AccountContext context = new AccountContext();
        context.setScanner(scanner);
        context.setAccount(account);
        context.setFile(file);

        boolean terminate = false;
        while (!terminate) {
            ConsoleInterface.printMenu();
            int action = Integer.parseInt(scanner.nextLine());
            switch (action) {
                case 1 -> {
                    context.setStrategy("Console");
                    AccountManager.addIncome(context);
                }
                case 2 -> {
                    context.setStrategy("Console");
                    AccountManager.addExpense(context);
                }
                case 3 -> ConsoleInterface.printExpenses(context);
                case 4 -> ConsoleInterface.printBalance(account);
                case 5 -> {
                    context.setStrategy("File");
                    ManageFiles.appendBalanceToFile(context);
                    ManageFiles.appendExpensesToFile(context);
                    ManageFiles.appendIncomesToFile(context);
                }
                case 6 -> {
                    ManageFiles.loadFromFile(context);
                }
                case 7 -> {
                    // FIXME
                    //  (Implement sorting methods and call them based on console input)
                    // AccountManager.sortExpenses(context);
                    ConsoleInterface.printSortedExpenses(context);
                }
                case 0 -> terminate = true;
                default -> {
                    System.out.println("\nInvalid action.");
                    terminate = true;
                }
            }
        }
        
        scanner.close();
        ConsoleInterface.printBye();
    }
}