DROP TABLE EMP;
DROP TABLE DEPT;
DROP TABLE SALGRADE;
CREATE TABLE EMP
(EMPNO NUMBER(4) NOT NULL,
ENAME VARCHAR2(10),
JOB VARCHAR2(9),
MGR NUMBER(4),
HIREDATE DATE,
SAL NUMBER(7, 2),
COMM NUMBER(7, 2),
DEPTNO NUMBER(2));
INSERT INTO EMP VALUES
(7369, 'SMITH', 'CLERK', 7902,
TO_DATE('17-MAR-1980', 'DD-MON-YYYY'), 800, NULL, 20);
INSERT INTO EMP VALUES
(7499, 'ALLEN', 'SALESMAN', 7698,
TO_DATE('20-MAR-1981', 'DD-MON-YYYY'), 1600, 300, 30);
INSERT INTO EMP VALUES
(7521, 'WARD', 'SALESMAN', 7698,
TO_DATE('22-MAR-1981', 'DD-MON-YYYY'), 1250, 500, 30);
INSERT INTO EMP VALUES
(7566, 'JONES', 'MANAGER', 7839,
TO_DATE('2-MAR-1981', 'DD-MON-YYYY'), 2975, NULL, 20);
INSERT INTO EMP VALUES
(7654, 'MARTIN', 'SALESMAN', 7698,
TO_DATE('28-MAR-1981', 'DD-MON-YYYY'), 1250, 1400, 30);
INSERT INTO EMP VALUES
(7698, 'BLAKE', 'MANAGER', 7839,
TO_DATE('1-MAR-1981', 'DD-MON-YYYY'), 2850, NULL, 30);
INSERT INTO EMP VALUES
(7782, 'CLARK', 'MANAGER', 7839,
TO_DATE('9-MAR-1981', 'DD-MON-YYYY'), 2450, NULL, 10);
INSERT INTO EMP VALUES
(7788, 'SCOTT', 'ANALYST', 7566,
TO_DATE('09-MAR-1982', 'DD-MON-YYYY'), 3000, NULL, 20);
INSERT INTO EMP VALUES
(7839, 'KING', 'PRESIDENT', NULL,
TO_DATE('17-MAR-1981', 'DD-MON-YYYY'), 5000, NULL, 10);
INSERT INTO EMP VALUES
(7844, 'TURNER', 'SALESMAN', 7698,
TO_DATE('8-MAR-1981', 'DD-MON-YYYY'), 1500, 0, 30);
INSERT INTO EMP VALUES
(7876, 'ADAMS', 'CLERK', 7788,
TO_DATE('12-MAR-1983', 'DD-MON-YYYY'), 1100, NULL, 20);
INSERT INTO EMP VALUES
(7900, 'JAMES', 'CLERK', 7698,
TO_DATE('3-MAR-1981', 'DD-MON-YYYY'), 950, NULL, 30);
INSERT INTO EMP VALUES
(7902, 'FORD', 'ANALYST', 7566,
TO_DATE('3-MAR-1981', 'DD-MON-YYYY'), 3000, NULL, 20);
INSERT INTO EMP VALUES
(7934, 'MILLER', 'CLERK', 7782,
TO_DATE('23-MAR-1982', 'DD-MON-YYYY'), 1300, NULL, 10); 
CREATE TABLE DEPT
(DEPTNO NUMBER(2),
DNAME VARCHAR2(14),  
LOC  VARCHAR2(13) );
INSERT INTO DEPT VALUES (10, 'ACCOUNTING', 'NEW YORK');
INSERT INTO DEPT VALUES (20, 'RESEARCH', 'DALLAS');
INSERT INTO DEPT VALUES (30, 'SALES', 'CHICAGO');
INSERT INTO DEPT VALUES (40, 'OPERATIONS', 'BOSTON');

CREATE TABLE SALGRADE
(GRADE NUMBER,
LOSAL NUMBER,
HISAL NUMBER);
INSERT INTO SALGRADE VALUES (1, 700, 1200);
INSERT INTO SALGRADE VALUES (2, 1201, 1400);
INSERT INTO SALGRADE VALUES (3, 1401, 2000);
INSERT INTO SALGRADE VALUES (4, 2001, 3000);
INSERT INTO SALGRADE VALUES (5, 3001, 9999); 
COMMIT;

SELECT job, avg(sal) 
from emp 
group by job
having avg(sal)>=3000;

CREATE TABLE AEMP AS SELECT * FROM EMP;
SELECT * FROM AEMP;
CREATE TABLE ASALGRADE AS SELECT * FROM SALGRADE;
CREATE TABLE ADEPT AS SELECT * FROM DEPT;

Set ServerOutput ON
Create or replace trigger R
After insert or update on AEMP
For each row
Begin
DBMS_output.put_line('MY TRIGGER WORKS');
End;

update AEMP
set COMM=0
where ename='KING';

Create or replace trigger MoreColleagues
after insert on AEMP
Begin
DBMS_output.put_line('More colleagues');
End;

Create or replace trigger CountDept
after insert on ADEPT
Declare x integer;
Begin
Select count(deptno) into x
From ADEPT;
DBMS_output.put_line('Now we have '||x);
End;


INSERT INTO ADEPT VALUES (50, 'MARKETING', 'EREBOR');


Select e.ename
from emp e, emp m, salgrade g
where e.mgr = m.empno
and(select grade from salgrade where e.sal between g.losal and g.hisal)>(select grade from salgrade where m.sal between g.losal and g.hisal);

Select e.ename,eg.grade,bg.grade
from emp e, emp b, salgrade eg, salgrade bg
where e.mgr = b.empno
and e.sal between eg.losal and eg.hisal
and b.sal between bg.losal and bg.hisal
and eg.grade > bg.grade;

select *
from emp;
update emp
set sal = 1000
where ename='KING';

SELECT job
FROM EMP
WHERE deptno=10
INTERSECT
SELECT job
FROM EMP
WHERE deptno=20
Order by job;



SELECT count(ename)
FROM EMP
WHERE hiredate<(SELECT max(hiredate)
FROM EMP, DEPT
WHERE emp.deptno=dept.deptno and loc='ACCOUNTING');

SELECT b.ename, count(w.ename)
FROM EMP b, EMP w
WHERE b.empno=w.mgr
GROUP BY b.ename
ORDER BY 2 desc;

SELECT ename
FROM emp
WHERE job='CLERK' AND hiredate>(SELECT hiredate
FROM emp
WHERE ename='ADAMS');

SELECT ename, job, hiredate
FROM emp, dept
WHERE emp.deptno=dept.deptno and loc='DALLAS';

SELECT count(ename)
FROM emp
WHERE sal<(
SELECT max(sal)
FROM emp, dept
WHERE loc='NEW YORK');

SELECT count(b.ename)
FROM emp b
WHERE EXISTS
(SELECT w.ename
FROM emp w
WHERE b.empno = w.mgr);

SELECT job, grade, avg(12*sal-nvl(comm,0))
FROM emp, salgrade
WHERE sal between losal and hisal
GROUP by job, grade
Order by job;

SELECT ENAME
FROM EMP,SALGRADE
WHERE sal between losal and hisal
AND (SAL,job,grade) in(
SELECT min(sal), job, grade
FROM EMP, SALGRADE
WHERE sal between losal and hisal
GROUP BY job, grade);