package org.shev4ik.interview.sql.level2_intermediate

object Sql005_WindowFunctions {

  // Schema:
  // CREATE TABLE employees (
  //   id SERIAL PRIMARY KEY,
  //   name TEXT NOT NULL,
  //   dept_id INT,
  //   salary DECIMAL(10,2),
  //   hire_date DATE
  // );
  //
  // Sample data - employees:
  // | id | name          | dept_id | salary   | hire_date  |
  // |----|---------------|---------|----------|------------|
  // | 1  | Alice Johnson | 1       | 95000.00 | 2019-03-15 |
  // | 2  | Bob Smith     | 1       | 82000.00 | 2020-07-22 |
  // | 3  | Carol White   | 2       | 88000.00 | 2018-01-10 |
  // | 4  | Dave Brown    | 2       | 88000.00 | 2021-11-05 |
  // | 5  | Eve Davis     | 1       | 95000.00 | 2022-02-28 |
  // | 6  | Frank Miller  | 2       | 72000.00 | 2020-06-18 |
  // | 7  | Grace Lee     | 3       | 65000.00 | 2023-01-10 |
  // | 8  | Henry Wilson  | 3       | 78000.00 | 2019-09-01 |

  // Exercise 1: ROW_NUMBER
  // TODO: Write a SQL query that assigns a row number to each employee within their department,
  //       ordered by salary DESC. Return name, dept_id, salary, row_num.
  // Expected: Within dept 1: Alice(1), Eve(2), Bob(3); dept 2: Carol(1), Dave(2), Frank(3); etc.
  val exercise1: String = ???

  // Exercise 2: RANK
  // TODO: Write a SQL query that ranks employees within their department by salary DESC.
  //       Ties should receive the same rank, with gaps after ties.
  //       Return name, dept_id, salary, rank.
  // Expected: Dept 1: Alice(1), Eve(1), Bob(3); Dept 2: Carol(1), Dave(1), Frank(3)
  val exercise2: String = ???

  // Exercise 3: DENSE_RANK
  // TODO: Write a SQL query that dense-ranks employees within their department by salary DESC.
  //       Ties get same rank, no gaps after ties.
  //       Return name, dept_id, salary, dense_rank.
  // Expected: Dept 1: Alice(1), Eve(1), Bob(2); Dept 2: Carol(1), Dave(1), Frank(2)
  val exercise3: String = ???

  // Exercise 4: NTILE
  // TODO: Write a SQL query that divides all employees into 3 roughly equal groups (tiles)
  //       ordered by salary DESC. Return name, salary, tile_number.
  // Expected: Tile 1 (top 3): Alice, Eve, Carol/Dave; Tile 2 (mid 3); Tile 3 (bottom 2)
  val exercise4: String = ???

  // Exercise 5: LAG
  // TODO: Write a SQL query that for each employee (ordered by hire_date),
  //       shows their name, hire_date, salary, and the salary of the previously hired employee.
  //       Use LAG(salary, 1) OVER (ORDER BY hire_date).
  // Expected: Carol(NULL prev), Alice(88000 prev), Henry(95000 prev), ...
  val exercise5: String = ???

  // Exercise 6: LEAD
  // TODO: Write a SQL query that for each employee (ordered by hire_date),
  //       shows their name, hire_date, salary, and the salary of the next hired employee.
  //       Use LEAD(salary, 1) OVER (ORDER BY hire_date).
  // Expected: ..., Grace(NULL next since she's last)
  val exercise6: String = ???

  // Exercise 7: FIRST_VALUE
  // TODO: Write a SQL query that shows each employee's name, dept_id, salary,
  //       and the name of the highest-paid employee in their department.
  //       Use FIRST_VALUE(name) OVER (PARTITION BY dept_id ORDER BY salary DESC).
  // Expected: Everyone in dept 1 sees 'Alice Johnson' (or 'Eve Davis'), dept 2 sees 'Carol White'
  val exercise7: String = ???

  // Exercise 8: LAST_VALUE
  // TODO: Write a SQL query that shows each employee's name, dept_id, salary,
  //       and the name of the lowest-paid employee in their department.
  //       Use LAST_VALUE with the correct frame clause:
  //       ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING
  // Expected: Dept 1 sees 'Bob Smith', dept 2 sees 'Frank Miller', dept 3 sees 'Grace Lee'
  val exercise8: String = ???

  def main(args: Array[String]): Unit = {
    println(s"Exercise 1 (ROW_NUMBER):    $exercise1")
    println(s"Exercise 2 (RANK):          $exercise2")
    println(s"Exercise 3 (DENSE_RANK):    $exercise3")
    println(s"Exercise 4 (NTILE):         $exercise4")
    println(s"Exercise 5 (LAG):           $exercise5")
    println(s"Exercise 6 (LEAD):          $exercise6")
    println(s"Exercise 7 (FIRST_VALUE):   $exercise7")
    println(s"Exercise 8 (LAST_VALUE):    $exercise8")
    println("All Sql005_WindowFunctions exercises defined!")
  }
}
