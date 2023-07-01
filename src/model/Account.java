package budget.model;

import java.util.ArrayList;
import java.util.List;

public class Account {

    public List<Expense> expenses = new ArrayList<>();

    public List<String> incomes = new ArrayList<>();

    public double balance;
}
