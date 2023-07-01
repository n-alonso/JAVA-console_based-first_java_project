package budget.actions.strategies;

import budget.model.AccountContext;

public interface AccountStrategy {
    void addExpense(AccountContext context);

    void addIncome(AccountContext context);
}