package org.shev4ik.interview.sql.level1_basics

object Sql001_SelectBasics {

  // Schema:
  // CREATE TABLE employees (
  //   id SERIAL PRIMARY KEY,
  //   name TEXT NOT NULL,
  //   dept_id INT REFERENCES departments(id),
  //   salary DECIMAL(10,2),
  //   hire_date DATE,
  //   city TEXT,
  //   age INT
  // );
  //
  // CREATE TABLE departments (
  //   id SERIAL PRIMARY KEY,
  //   name TEXT NOT NULL,
  //   manager_id INT
  // );
  //
  // Sample data - employees:
  // | id | name          | dept_id | salary   | hire_date  | city       | age |
  // |----|---------------|---------|----------|------------|------------|-----|
  // | 1  | Alice Johnson | 1       | 85000.00 | 2020-03-15 | New York   | 32  |
  // | 2  | Bob Smith     | 2       | 72000.00 | 2019-07-22 | Chicago    | 28  |
  // | 3  | Carol White   | 1       | 95000.00 | 2018-01-10 | New York   | 45  |
  // | 4  | Dave Brown    | 3       | 62000.00 | 2021-11-05 | San Diego  | 25  |
  // | 5  | Eve Davis     | 2       | 78000.00 | 2020-06-18 | Chicago    | 35  |
  // | 6  | Frank Miller  | NULL    | 55000.00 | 2022-02-28 | New York   | 23  |
  //
  // Sample data - departments:
  // | id | name        | manager_id |
  // |----|-------------|------------|
  // | 1  | Engineering | 3          |
  // | 2  | Marketing   | 5          |
  // | 3  | Sales       | 4          |

  // Exercise 1: SELECT all columns from employees
  // TODO: Write a SQL query that returns all columns and all rows from the employees table
  // Expected: all 6 rows with all columns
  val exercise1: String = ???

  // Exercise 2: SELECT specific columns
  // TODO: Write a SQL query that returns only the name and salary columns from employees
  // Expected: 6 rows with just name and salary
  val exercise2: String = ???

  // Exercise 3: WHERE clause with comparison
  // TODO: Write a SQL query that returns name and salary for employees with salary > 75000
  // Expected: Alice (85000), Carol (95000), Eve (78000)
  val exercise3: String = ???

  // Exercise 4: WHERE with AND / OR
  // TODO: Write a SQL query that returns employees who live in 'New York' AND have salary > 80000,
  //       OR employees who live in 'Chicago'
  // Expected: Alice (NY, 85000), Bob (Chicago), Carol (NY, 95000), Eve (Chicago)
  val exercise4: String = ???

  // Exercise 5: IN operator
  // TODO: Write a SQL query that returns employees whose city is in ('New York', 'San Diego')
  // Expected: Alice, Carol, Dave, Frank
  val exercise5: String = ???

  // Exercise 6: BETWEEN operator
  // TODO: Write a SQL query that returns employees with salary between 60000 and 80000 (inclusive)
  // Expected: Bob (72000), Dave (62000), Eve (78000)
  val exercise6: String = ???

  // Exercise 7: LIKE pattern matching
  // TODO: Write a SQL query that returns employees whose name starts with a letter before 'D'
  //       Use LIKE with pattern matching. Find names starting with 'A', 'B', or 'C'.
  // Expected: Alice Johnson, Bob Smith, Carol White
  val exercise7: String = ???

  // Exercise 8: ORDER BY with multiple columns
  // TODO: Write a SQL query that returns all employees ordered by city ASC, then salary DESC
  // Expected: Chicago (Eve 78000, Bob 72000), New York (Carol 95000, Alice 85000, Frank 55000), San Diego (Dave 62000)
  val exercise8: String = ???

  def main(args: Array[String]): Unit = {
    println(s"Exercise 1 (SELECT all):        $exercise1")
    println(s"Exercise 2 (SELECT columns):    $exercise2")
    println(s"Exercise 3 (WHERE):             $exercise3")
    println(s"Exercise 4 (AND/OR):            $exercise4")
    println(s"Exercise 5 (IN):                $exercise5")
    println(s"Exercise 6 (BETWEEN):           $exercise6")
    println(s"Exercise 7 (LIKE):              $exercise7")
    println(s"Exercise 8 (ORDER BY):          $exercise8")
    println("All Sql001_SelectBasics exercises defined!")
  }
}
