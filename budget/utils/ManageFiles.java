package budget.utils;

import budget.actions.AccountManager;
import budget.model.AccountContext;
import budget.model.Expense;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ManageFiles {

    public static File createFile(String path) {
        File file = new File(path);

        try {
            file.createNewFile();
            file.deleteOnExit();
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        }

        return file;
    }

    public static void appendBalanceToFile(AccountContext context) {
        try (FileWriter writer = new FileWriter(context.getFile(), true)) {
            writer.write("balance;;" + context.getAccount().balance + "\n");
        } catch (IOException e) {
            System.out.println("Error writing balance to file: " + e.getMessage());
        }
    }

    public static void appendExpensesToFile(AccountContext context) {
        AccountManager.addExpense(context);
    }

    public static void appendIncomesToFile(AccountContext context) {
        AccountManager.addIncome(context);
    }

    public static void loadFromFile(AccountContext context) {
        try (Scanner scanner = new Scanner(context.getFile())) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] split = line.split(";;");
                String type = split[0];
                switch (type) {
                    case "balance" -> context.getAccount().balance = Double.parseDouble(split[1]);
                    case "expenses" -> {
                        String description = split[1];
                        String category = split[2];
                        double price = Double.parseDouble(split[3]);
                        Expense expense = new Expense(description, category, price);
                        context.getAccount().expenses.add(expense);
                    }
                    case "incomes" -> {
                        String income = split[1];
                        context.getAccount().incomes.add(income);
                    }
                }
            }
            System.out.println("\nPurchases were loaded!");
        } catch (Exception e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
}
