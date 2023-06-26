package budget;

public class Expense {
    String name;

    String category;
    double price;

    public Expense(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " $" + String.format("%.2f", price);
    }

    public String toFileString() {
        return "expenses;;" + name + ";;" + category + ";;" + price + "\n";
    }

    public static Expense fromFileString(String line) {
        String[] split = line.split(";;");
        return new Expense(split[1], split[2], Double.parseDouble(split[3]));
    }
}
