package budget.model;

public class Expense {
    final private String description;

    final private String category;

    final private double price;

    public Expense(String description, String category, double price) {
        this.description = description;
        this.category = category;
        this.price = price;
    }

    @Override
    public String toString() {
        return description + " $" + String.format("%.2f", price);
    }

    public String toFileString() {
        return "expenses;;" + description + ";;" + category + ";;" + price + "\n";
    }

    public static Expense fromFileString(String line) {
        String[] split = line.split(";;");
        return new Expense(split[1], split[2], Double.parseDouble(split[3]));
    }

    public String getDescription() { return this.description; }

    public String getCategory() { return this.category; }

    public double getPrice() { return this.price; }
}
