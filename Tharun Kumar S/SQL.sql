1. select * 
from Employee 
where Job_ID like '%CLEARK' and Hire_date > 12-31-1997;
 
2. select Last_name,JOB_ID,Salary,Commission_pct * Salary as Commission 
order by Salary DESC:
 
3.select 'The Salary if' | Last_name |'after 10% rise is'|round(sal+0.1*sal)
from employee 
where comm is null ;
 
 
4.select last_name,A/12 AS YEAR,A%12 AS MONTHSfrom employee where monthsbetween(hire_date,sysdate) as A ORDER BY A DESC;
 
5.select last_name from employee where last_name like in('J%','K%','L%','M%');
 
6.select LastName,sal,decode(commission,null,no,yes) as Commission
 from Employees;
  
7.select department name,location id,lastname,jobid,salary where &cond;
 
8.
select count(*) 
from employee 
where last_name like '%n';

 
9.
select d.Department id , d.Department Name, d.Locaton Id , NVL(e.count(Emp Id),0) as "No of Emp" 
from Department d 
Left join Employee e on d.Department id = e.Department id
 
group by Department Name;
 
 
10.
select Job_Id 
from Department 
where Department Id in (10,20) 
Group by Department Name.
 
 
11.
SELECT jobID,COUNT(*) AS num_employees
FROM Department
WHERE department_id IN ('Administration', 'Executive')
GROUP BY jobID
ORDER BY num_employees DESC;
 
 
12.
SELECT LAST_NAME,HIRE_DATE
FROM EMPLOYEE
WHERE DAY(round(HIRE_DATE,'MONTH'))=1;
 
13.
SELECT Last Name,Salary, Salary/1000 as Thousands
FROM EMPLOYEE;
 
14.
SELECT Last Name,Manager,Salary,Grade Level
FROM Employee e1
joins Employee e2 on e1.manager = e1.Last Name
WHERE Salary > 15000;
 
15.
SELECT Dept,Dept Name,COUNT(Last Name) as Employees,AVG( Salary),Last_name
FROM Employees
Group By Dept Name,Last_name;
