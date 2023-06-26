package budget;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);

        ManageFiles.createFile("./purchases.txt");

        boolean terminate = false;
        while (!terminate) {
            PrintData.printMenu();
            int action = Integer.parseInt(scanner.nextLine());
            switch (action) {
                case 1 -> ProcessInput.addIncome();
                case 2 -> ProcessInput.addExpense();
                case 3 -> PrintData.printExpenses();
                case 4 -> PrintData.printBalance();
                case 5 -> {
                    ManageFiles.appendBalanceToFile("./purchases.txt");
                    ManageFiles.appendExpensesToFile("./purchases.txt");
                    ManageFiles.appendIncomesToFile("./purchases.txt");
                }
                case 6 -> {
                    ManageFiles.loadFromFile("./purchases.txt");
                }
                case 0 -> terminate = true;
            }
        }
        
        scanner.close();
        PrintData.bye();
    }
}