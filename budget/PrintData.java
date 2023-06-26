package budget;

import java.util.Scanner;

// FIXME
// Print doubles with 2 decimal digits

class PrintData extends ProcessInput {

    public static void printMenu() {
        String menu = """
                \nChoose your action:
                1) Add income
                2) Add purchase
                3) Show list of purchases
                4) Balance
                5) Save
                6) Load
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

    public static void printExpenses() {
        Scanner scanner = new Scanner(System.in);

        boolean keepPrinting = true;
        while (keepPrinting) {
            if (expenses.isEmpty()) {
                System.out.println("\nThe purchase list if empty");
            } else {
                printShowExpensesMenu();
                int category = Integer.parseInt(scanner.nextLine());
                switch (category) {
                    case 1, 2, 3, 4 -> printExpensesByCategory(category);
                    case 5 -> printAllExpenses();
                    case 6 -> keepPrinting = false;
                }
            }
        }

        scanner.close();
    }

    private static void printAllExpenses() {
        System.out.println("\nAll:");

        double expensesSum = 0.0;
        for (Expense expense : expenses) {
            System.out.println(expense.toString());
            expensesSum += expense.price;
        }
        System.out.println("Total sum: $" + String.format("%.2f", expensesSum));
    }

    private static void printExpensesByCategory(int choice) {
        System.out.println();

        String category = switch (choice) {
            case 1 -> "Food";
            case 2 -> "Clothes";
            case 3 -> "Entertainment";
            default -> "Other";
        };
        System.out.println(category + ":");

        double expensesSum = 0.0;
        for (Expense expense : expenses) {
            if (category.equals(expense.category)) {
                System.out.println(expense.toString());
                expensesSum += expense.price;
            }
        }

        System.out.println("Total sum: $" + String.format("%.2f", expensesSum));
    }

    public static void printBalance() {
        System.out.println("\nBalance: $" + String.format("%.2f", balance));
    }

    public static void bye() {
        System.out.println("\nBye!");
    }
}