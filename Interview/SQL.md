## **SQL Query to find the second highest salary of Employee**

SELECT MAX(Salary)
FROM Employee
WHERE Salary NOT IN (select MAX(Salary) from Employee);

## SQL Query to find Max Salary from each department.

SELECT DeptID, MAX(Salary)
FROM Employee
GROUP BY DeptID.

if ask you to print the department name instead of the department id then

SELECT DeptName, MAX(Salary) FROM Employee e RIGHT JOIN Department d
ON e.DeptId = d.DeptID
GROUP BY DeptName;

##  SQL Query to find duplicate row (column's value) in table.

SELECT
    name, email, COUNT(*)
FROM
    users
GROUP BY
    name, email
HAVING
    COUNT(*) > 1

**All columns:**

List all rows containg duplicates:

SELECT a.*
FROM users a
JOIN (SELECT username, email, COUNT(*)
FROM users
GROUP BY username, email
HAVING count(*) > 1 ) b
ON a.username = b.username
AND a.email = b.email
ORDER BY a.email

## What is Self join and when to use?

E.g., an Employee table may have a SupervisorID column that points to the employee that is the boss of the current employee.

It's basically used where there is any relationship between rows stored in the same table.

Well, one classic example is where you wanted to get a list of employees and their immediate managers:

select e.employee as employee, b.employee as boss
from emp e, emp b
where e.manager_id = b.empolyee_id
order by 1

## There is a table which contains two columns Student and Marks, you need to find all the students, whose marks are greater than average marks i.e. list of above-average students.

SELECT student, marks
FROM table
WHERE marks > (SELECT AVG(marks) from table);
