# Shop Management System

## Overview

This project implements a Shop Management System to handle various operations in a shop, including delivery and sale of goods, cashier management, receipt generation, and profit calculation. 
The system includes exception handling and unit tests to ensure robustness and reliability.

## Features

- **Goods Management**
  - Different types of goods (food and non-food) are defined by ID, name, delivery price, category, and expiry date.
  - Selling price calculation based on overcharge percentage and proximity to the expiry date.
  - Automatic exclusion of expired goods from sale.
  - Exception handling for insufficient quantity of goods, showing the needed quantity.
  
- **Cashier Management**
  - Cashiers are identified by name, ID, and monthly salary.
  - Each cashier works at a specific cash desk in the shop.
  - Cashiers handle sales transactions and generate receipts for clients.

- **Receipt Generation**
  - Receipts include ID, cashier details, date and time, list of goods with quantity and price, and the total value.
  - Automatic saving of receipts to files named after the receipt ID.
  - Tracking of total number of receipts and the total value of sold goods.
  - Capability to read and retrieve information from receipt files.

- **Financial Management**
  - Calculation of costs for cashier salaries and delivered goods.
  - Calculation of income from sold goods.
  - Profit calculation as the difference between income and costs.

- **Exception Handling**
  - Custom exceptions for handling insufficient quantity of goods.

- **Intergation Testing**
  - Comprehensive integration tests to ensure the correctness of the system.

## Requirements

- Java Development Kit (JDK)
- Any Java IDE (Eclipse, IntelliJ IDEA, etc.)

## Usage

1. **Adding Goods**
   - Define goods with ID, name, delivery price, category, and expiry date.
   - Set overcharge percentages for food and non-food goods.
   - Specify the number of days to expiry and the corresponding price reduction percentage.

2. **Cashier Operations**
   - Add cashiers with name, ID, and salary.
   - Assign cashiers to specific cash desks.

3. **Handling Sales**
   - Cashiers process sales and generate receipts.
   - Check for sufficient quantity of goods before completing the sale.
   - Receipts are automatically saved to files.

4. **Financial Calculations**
   - Calculate and display costs, income, and profit for the shop.

## Contributors

- [Maria Kalendarova](https://github.com/mariakalendarova)
- [Kaloian Piperkov](https://github.com/KaloianPiperkov)
