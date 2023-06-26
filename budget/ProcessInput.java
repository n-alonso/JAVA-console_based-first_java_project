package budget;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ProcessInput {
    static List<Expense> expenses = new ArrayList<>();

    static List<String> incomes = new ArrayList<>();

    static double balance;

    public static void addExpense() {
        Scanner scanner = new Scanner(System.in);

        boolean keepAdding = true;
        while (keepAdding) {
            PrintData.printAddExpensesMenu();
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
                expenses.add(expense);

                balance -= price;
                if (balance < 0) balance = 0;

                System.out.println("Purchase was added!");
            }
        }

        scanner.close();
    }

    public static void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public static void addIncome() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nEnter income:");
        String amount = scanner.nextLine();
        incomes.add(amount);
        balance += Double.parseDouble(amount);
        System.out.println("Income was added!");
    }

    public static void addIncome(String income) {
        incomes.add(income);
    }
}