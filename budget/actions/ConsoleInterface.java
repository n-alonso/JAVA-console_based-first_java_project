package budget.actions;

import budget.model.Account;
import budget.model.AccountContext;
import budget.model.Expense;
import budget.utils.ListSorter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConsoleInterface {

    public static void printMenu() {
        String menu = """
                \nChoose your action:
                1) Add income
                2) Add purchase
                3) Show list of purchases
                4) Balance
                5) Save
                6) Load
                7) Analyze (Sort)
                0) Exit""";
        System.out.println(menu);
    }

    public static void printAddExpensesMenu() {
        String expensesMenu = """
                \nChoose the type of purchase
                1) Food
                2) Clothes
                3) Entertainment
                4) Other
                5) Back""";
        System.out.println(expensesMenu);
    }

    public static void printShowExpensesMenu() {
        String expensesMenu = """
                \nChoose the type of purchases
                1) Food
                2) Clothes
                3) Entertainment
                4) Other
                5) All
                6) Back""";
        System.out.println(expensesMenu);
    }

    public static void printSortExpensesMenu() {
        String expensesMenu = """
                \nChoose the type of purchases
                1) Food
                2) Clothes
                3) Entertainment
                4) Other""";
        System.out.println(expensesMenu);
    }

    public static void printSortingMenu() {
        String sortingMenu = """
                \nHow do you want to sort?
                1) Sort all purchases
                2) Sort by type
                3) Sort certain type
                4) Back""";
        System.out.println(sortingMenu);
    }

    public static void printBye() {
        System.out.println("\nBye!");
    }

    public static void printExpenses(AccountContext context) {
        boolean keepPrinting = true;
        while (keepPrinting) {
            if (context.getAccount().expenses.isEmpty()) {
                System.out.println("\nThe purchase list if empty");
                keepPrinting = false;
            } else {
                printShowExpensesMenu();
                int category = Integer.parseInt(context.getScanner().nextLine());
                switch (category) {
                    case 1, 2, 3, 4 -> printExpensesByCategory(category, context.getAccount());
                    case 5 -> printAllExpenses(context.getAccount());
                    default -> keepPrinting = false;
                }
            }
        }
    }

    private static void printAllExpenses(Account account) {
        System.out.println("\nAll:");

        double expensesSum = 0.0;
        for (Expense expense : account.expenses) {
            System.out.println(expense.toString());
            expensesSum += expense.getPrice();
        }
        System.out.println("Total sum: $" + String.format("%.2f", expensesSum));
    }

    private static void printExpensesByCategory(int choice, Account account) {
        System.out.println();

        String category = switch (choice) {
            case 1 -> "Food";
            case 2 -> "Clothes";
            case 3 -> "Entertainment";
            default -> "Other";
        };
        System.out.println(category + ":");

        double expensesSum = 0.0;
        for (Expense expense : account.expenses) {
            if (category.equals(expense.getCategory())) {
                System.out.println(expense.toString());
                expensesSum += expense.getPrice();
            }
        }

        System.out.println("Total sum: $" + String.format("%.2f", expensesSum));
    }

    public static void printSortedExpenses(AccountContext context) {
        boolean terminate = false;
        while (!terminate) {
            printSortingMenu();
            int choice = Integer.parseInt(context.getScanner().nextLine());
            switch (choice) {
                case 1 -> {
                    List<Expense> sortedExpenses = ListSorter.bubbleSortDesc(context.getAccount().expenses);
                    if (sortedExpenses.isEmpty()) System.out.println("\nThe purchase list is empty!");
                    else {
                        System.out.println();
                        for (Expense expense : sortedExpenses) {
                            System.out.println(expense.toString());
                        }
                    }
                }
                case 2 -> {
                    Map<String, Double> categories = new HashMap<>();
                    categories.put("Food", 0.0);
                    categories.put("Entertainment", 0.0);
                    categories.put("Clothes", 0.0);
                    categories.put("Other", 0.0);
                    for (Expense expense : context.getAccount().expenses) {
                        String category = expense.getCategory();
                        categories.put(category, categories.get(category) + expense.getPrice());
                    }
                    var sortedCategories = ListSorter.bubbleSortDesc(categories);
                    if (sortedCategories.isEmpty()) System.out.println("\nThe purchase list is empty!");
                    else {
                        System.out.println("\nTypes:");
                        for (var entry : sortedCategories) {
                            System.out.println(entry.getKey() + " - $" + String.format("%.2f", entry.getValue()));
                        }
                    }
                }
                case 3 -> {
                    printSortExpensesMenu();
                    String category = switch (Integer.parseInt(context.getScanner().nextLine())) {
                        case 1 -> "Food";
                        case 2 -> "Clothes";
                        case 3 -> "Entertainment";
                        default -> "Other";
                    };

                    List<Expense> temp = new ArrayList<>();
                    for (Expense expense : context.getAccount().expenses) {
                        if (expense.getCategory().equals(category)) {
                            temp.add(expense);
                        }
                    }

                    List<Expense> sortedExpenses = ListSorter.bubbleSortDesc(temp);
                    if (sortedExpenses.isEmpty()) System.out.println("\nThe purchase list is empty!");
                    else {
                        System.out.println();
                        for (Expense expense : sortedExpenses) {
                            System.out.println(expense.toString());
                        }
                    }
                }
                default -> terminate = true;
            }
        }
    }

    public static void printBalance(Account account) {
        System.out.println("\nBalance: $" + String.format("%.2f", account.balance));
    }
}