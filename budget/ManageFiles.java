package budget;

import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class ManageFiles extends ProcessInput {

    public static void createFile(String path) {
        File file = new File(path);

        try {
            file.createNewFile();
            file.deleteOnExit();
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        }
    }

    public static void appendBalanceToFile(String path) {
        File file = new File(path);

        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write("balance;;" + balance + "\n");
        } catch (IOException e) {
            System.out.println("Error writing balance to file: " + e.getMessage());
        }
    }

    public static void appendExpensesToFile(String path) {
        File file = new File(path);

        try (FileWriter writer = new FileWriter(file, true)) {
            for (Expense expense : expenses) {
                writer.write(expense.toFileString());
            }
        } catch (IOException e) {
            System.out.println("Error writing expenses to file: " + e.getMessage());
        }
    }

    public static void appendIncomesToFile(String path) {
        File file = new File(path);

        try (FileWriter writer = new FileWriter(file, true)) {
            for (String income : incomes) {
                writer.write("incomes;;" + income + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error writing incomes to file: " + e.getMessage());
        }
    }

    public static void loadFromFile(String path) {
        File file = new File(path);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] split = line.split(";;");
                String type = split[0];
                switch (type) {
                    case "balance" -> balance = Double.parseDouble(split[1]);
                    case "expenses" -> ProcessInput.addExpense(Expense.fromFileString(line));
                    case "incomes" -> ProcessInput.addIncome(split[1]);
                }
            }
            System.out.println("\nPurchases were loaded!");
        } catch (Exception e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
}
