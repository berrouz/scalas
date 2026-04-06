package org.shev4ik.interview.sql.level1_basics

object Sql004_Subqueries {

  // Schema:
  // CREATE TABLE employees (
  //   id SERIAL PRIMARY KEY,
  //   name TEXT NOT NULL,
  //   dept_id INT,
  //   salary DECIMAL(10,2),
  //   hire_date DATE
  // );
  //
  // CREATE TABLE departments (
  //   id SERIAL PRIMARY KEY,
  //   name TEXT NOT NULL,
  //   budget DECIMAL(12,2)
  // );
  //
  // CREATE TABLE sales (
  //   id SERIAL PRIMARY KEY,
  //   employee_id INT REFERENCES employees(id),
  //   amount DECIMAL(10,2),
  //   sale_date DATE
  // );
  //
  // Sample data - employees:
  // | id | name          | dept_id | salary   | hire_date  |
  // |----|---------------|---------|----------|------------|
  // | 1  | Alice Johnson | 1       | 95000.00 | 2019-03-15 |
  // | 2  | Bob Smith     | 1       | 82000.00 | 2020-07-22 |
  // | 3  | Carol White   | 2       | 88000.00 | 2018-01-10 |
  // | 4  | Dave Brown    | 2       | 72000.00 | 2021-11-05 |
  // | 5  | Eve Davis     | 3       | 65000.00 | 2022-02-28 |
  //
  // Sample data - departments:
  // | id | name        | budget      |
  // |----|-------------|-------------|
  // | 1  | Engineering | 500000.00   |
  // | 2  | Marketing   | 300000.00   |
  // | 3  | Sales       | 200000.00   |
  //
  // Sample data - sales:
  // | id | employee_id | amount   | sale_date  |
  // |----|-------------|----------|------------|
  // | 1  | 1           | 15000.00 | 2024-01-15 |
  // | 2  | 3           | 22000.00 | 2024-01-20 |
  // | 3  | 5           | 8000.00  | 2024-02-10 |
  // | 4  | 1           | 18000.00 | 2024-02-15 |
  // | 5  | 5           | 12000.00 | 2024-03-01 |

  // Exercise 1: Scalar subquery in SELECT
  // TODO: Write a SQL query that returns each employee's name, salary,
  //       and the overall average salary as a third column (using a scalar subquery)
  // Expected: All 5 employees, each with avg_salary = 80400.00
  val exercise1: String = ???

  // Exercise 2: Subquery in WHERE
  // TODO: Write a SQL query that returns employees whose salary is above the average salary.
  //       Use a subquery in the WHERE clause.
  // Expected: Alice (95000), Carol (88000), Bob (82000)
  val exercise2: String = ???

  // Exercise 3: Subquery in FROM (derived table)
  // TODO: Write a SQL query that uses a subquery in FROM to first compute total sales
  //       per employee, then join that result with the employees table.
  //       Return employee name and their total sales amount.
  // Expected: Alice (33000), Carol (22000), Eve (20000)
  val exercise3: String = ???

  // Exercise 4: Correlated subquery
  // TODO: Write a SQL query that returns employees who earn more than the average
  //       salary of their own department. Use a correlated subquery.
  // Expected: Alice (95000 > avg of dept 1 = 88500), Carol (88000 > avg of dept 2 = 80000)
  val exercise4: String = ???

  // Exercise 5: EXISTS
  // TODO: Write a SQL query that returns employees who have made at least one sale.
  //       Use EXISTS with a correlated subquery.
  // Expected: Alice, Carol, Eve
  val exercise5: String = ???

  // Exercise 6: NOT EXISTS
  // TODO: Write a SQL query that returns departments that have no employees with salary > 90000.
  //       Use NOT EXISTS.
  // Expected: Marketing, Sales
  val exercise6: String = ???

  def main(args: Array[String]): Unit = {
    println(s"Exercise 1 (Scalar subquery):    $exercise1")
    println(s"Exercise 2 (Subquery in WHERE):  $exercise2")
    println(s"Exercise 3 (Subquery in FROM):   $exercise3")
    println(s"Exercise 4 (Correlated):         $exercise4")
    println(s"Exercise 5 (EXISTS):             $exercise5")
    println(s"Exercise 6 (NOT EXISTS):         $exercise6")
    println("All Sql004_Subqueries exercises defined!")
  }
}
