# Budget Manager

This is a budget management system, implemented in Java.  
The system allows you to manage expenses, incomes and accounts, and supports operations like adding incomes or purchases, viewing balance, and sorting or viewing purchases.  
It also provides the ability to load and save account data to a file.

## Table of Contents

- [Getting Started](#getting-started)
- [Usage](#usage)
- [Project Structure](#project-structure)
- [Contributing](#contributing)

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

- Java 11 or higher
- A Java IDE such as IntelliJ IDEA, Eclipse or similar

### Installing

1. Clone the repository

```
git clone https://github.com/<username>/budget-manager.git
```

2. Open the project in your favorite IDE.

3. Run the main method from the `Main` class.

## Usage

The system provides a console interface to perform various operations, offering a main menu where you can choose the operation you want to perform. 

- Add income
- Add a purchase
- Show list of purchases
- Check balance
- Save data
- Load data
- Analyze (Sort)
- Exit

The "Add a purchase" option leads to a submenu for choosing the type of purchase: Food, Clothes, Entertainment, Other, or Back.

## Project Structure

The project is divided into the following packages:

- `budget.model`: Contains data model classes (`Account`, `Expense`, `AccountContext`).
- `budget.actions`: Contains main actions and interfaces for the budget manager. 
- `budget.utils`: Contains utility classes for managing files and sorting.
- `budget.actions.strategies`: Contains the strategy pattern related classes for adding expenses and incomes.
