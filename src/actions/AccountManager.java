package budget.actions;

import budget.actions.strategies.AccountStrategy;
import budget.actions.strategies.ConsoleAccountStrategy;
import budget.actions.strategies.FileAccountStrategy;
import budget.model.AccountContext;

import java.util.Map;

public class AccountManager {
    final static private Map<String, AccountStrategy> strategiesMap = Map.of(
            "Console", new ConsoleAccountStrategy(),
            "File", new FileAccountStrategy()
    );

    public static void addExpense(AccountContext context) {
        AccountStrategy strategy = strategiesMap.get(context.getStrategy());
        strategy.addExpense(context);
    }

    public static void addIncome(AccountContext context) {
        AccountStrategy strategy = strategiesMap.get(context.getStrategy());
        strategy.addIncome(context);
    }
}