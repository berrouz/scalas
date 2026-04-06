package org.shev4ik.interview.sql.level1_basics

object Sql003_JoinsBasic {

  // Schema:
  // CREATE TABLE employees (
  //   id SERIAL PRIMARY KEY,
  //   name TEXT NOT NULL,
  //   dept_id INT,
  //   manager_id INT,
  //   salary DECIMAL(10,2)
  // );
  //
  // CREATE TABLE departments (
  //   id SERIAL PRIMARY KEY,
  //   name TEXT NOT NULL,
  //   location TEXT
  // );
  //
  // CREATE TABLE projects (
  //   id SERIAL PRIMARY KEY,
  //   name TEXT NOT NULL,
  //   dept_id INT REFERENCES departments(id),
  //   budget DECIMAL(12,2)
  // );
  //
  // Sample data - employees:
  // | id | name          | dept_id | manager_id | salary   |
  // |----|---------------|---------|------------|----------|
  // | 1  | Alice Johnson | 1       | NULL       | 95000.00 |
  // | 2  | Bob Smith     | 1       | 1          | 82000.00 |
  // | 3  | Carol White   | 2       | NULL       | 88000.00 |
  // | 4  | Dave Brown    | 2       | 3          | 72000.00 |
  // | 5  | Eve Davis     | NULL    | NULL       | 65000.00 |
  //
  // Sample data - departments:
  // | id | name        | location  |
  // |----|-------------|-----------|
  // | 1  | Engineering | Floor 3   |
  // | 2  | Marketing   | Floor 2   |
  // | 3  | Sales       | Floor 1   |
  //
  // Sample data - projects:
  // | id | name         | dept_id | budget     |
  // |----|--------------|---------|------------|
  // | 1  | Project Alpha| 1       | 500000.00  |
  // | 2  | Project Beta | 1       | 300000.00  |
  // | 3  | Project Gamma| 2       | 200000.00  |

  // Exercise 1: INNER JOIN
  // TODO: Write a SQL query that returns employee name and department name
  //       for all employees that belong to a department
  // Expected: Alice/Engineering, Bob/Engineering, Carol/Marketing, Dave/Marketing (Eve excluded - NULL dept_id)
  val exercise1: String = ???

  // Exercise 2: LEFT JOIN
  // TODO: Write a SQL query that returns all employees with their department name.
  //       Employees without a department should show NULL for department name.
  // Expected: All 5 employees; Eve shows NULL for department
  val exercise2: String = ???

  // Exercise 3: RIGHT JOIN
  // TODO: Write a SQL query that returns all departments with their employees.
  //       Departments without employees should still appear with NULL for employee name.
  // Expected: Engineering (Alice, Bob), Marketing (Carol, Dave), Sales (NULL)
  val exercise3: String = ???

  // Exercise 4: FULL OUTER JOIN
  // TODO: Write a SQL query using FULL OUTER JOIN between employees and departments.
  //       Show both unmatched employees (no dept) and unmatched departments (no employees).
  // Expected: All employees + Sales dept with NULL employee
  val exercise4: String = ???

  // Exercise 5: Self join
  // TODO: Write a SQL query that returns each employee's name and their manager's name.
  //       Use a self join on the employees table via manager_id.
  //       Include employees without managers (show NULL for manager name).
  // Expected: Bob->Alice, Dave->Carol, Alice->NULL, Carol->NULL, Eve->NULL
  val exercise5: String = ???

  // Exercise 6: Multi-table join
  // TODO: Write a SQL query joining employees, departments, and projects.
  //       Return employee name, department name, and project name.
  //       Only include employees whose department has projects.
  // Expected: Alice/Engineering/Alpha, Alice/Engineering/Beta, Bob/Engineering/Alpha,
  //           Bob/Engineering/Beta, Carol/Marketing/Gamma, Dave/Marketing/Gamma
  val exercise6: String = ???

  // Exercise 7: CROSS JOIN
  // TODO: Write a SQL query that produces a cross join between departments and
  //       a VALUES list of quarters ('Q1','Q2','Q3','Q4').
  //       Return department name and quarter.
  // Expected: 12 rows (3 departments x 4 quarters)
  val exercise7: String = ???

  // Exercise 8: JOIN with aggregation
  // TODO: Write a SQL query that returns each department name along with the number
  //       of employees and the average salary in that department.
  //       Include only departments that have employees. Order by avg salary DESC.
  // Expected: Engineering (2 employees, avg 88500), Marketing (2 employees, avg 80000)
  val exercise8: String = ???

  def main(args: Array[String]): Unit = {
    println(s"Exercise 1 (INNER JOIN):         $exercise1")
    println(s"Exercise 2 (LEFT JOIN):          $exercise2")
    println(s"Exercise 3 (RIGHT JOIN):         $exercise3")
    println(s"Exercise 4 (FULL OUTER JOIN):    $exercise4")
    println(s"Exercise 5 (Self join):          $exercise5")
    println(s"Exercise 6 (Multi-table join):   $exercise6")
    println(s"Exercise 7 (CROSS JOIN):         $exercise7")
    println(s"Exercise 8 (JOIN + aggregation): $exercise8")
    println("All Sql003_JoinsBasic exercises defined!")
  }
}
