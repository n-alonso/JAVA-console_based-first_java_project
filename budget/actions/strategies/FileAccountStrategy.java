package budget.actions.strategies;

import budget.model.AccountContext;
import budget.model.Expense;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileAccountStrategy implements AccountStrategy {

    public void addExpense(AccountContext context) {
        File file = context.getFile();
        try (FileWriter writer = new FileWriter(file, true)) {
            for (Expense expense : context.getAccount().expenses) {
                writer.write(expense.toFileString());
            }
        } catch (IOException e) {
            System.out.println("Error writing expenses to file: " + e.getMessage());
        }
    }

    public void addIncome(AccountContext context) {
        File file = context.getFile();
        try (FileWriter writer = new FileWriter(file, true)) {
            for (String income : context.getAccount().incomes) {
                writer.write("incomes;;" + income + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error writing incomes to file: " + e.getMessage());
        }
    }
}
