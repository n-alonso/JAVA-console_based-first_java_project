package budget.model;

import java.io.File;
import java.util.Scanner;

public class AccountContext {

    private File file;

    private Scanner scanner;

    private String strategy;

    private Account account;

    private Expense expense;

    private String income;

    public File getFile() { return this.file; }

    public void setFile(File file) { this.file = file; }

    public Scanner getScanner() {
        return this.scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getStrategy() {
        return this.strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    public Account getAccount() {
        return this.account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Expense getExpense() { return this.expense; }

    public void setExpense(Expense expense) { this.expense = expense; }

    public String getIncome() { return this.income; }

    public void setIncome(String income) { this.income = income; }
}
