# aston-hibernate-task

TECHNOLOGY STACK
- Spring boot
- Hibernate
- PostgreSQL

DB DIAGRAM
![image](https://github.com/AzimovRuslan/aston-hibernate-task/assets/55226276/968c9832-fd5a-4ce8-916a-fcb6c1c36ec0)

ENDPOINTS DESCRIPTION
_______________________________________________________________________________________
EMPLOYEE ROLE
- api/v0/employee-roles [GET] -> Receive all employee roles
- api/v0/employee-roles/{id} [GET] -> Receive an employee role by id
- api/v0/employee-roles [POST] -> Save a new employee role into the db
- api/v0/employee-roles [PUT] -> Update an employee role
- api/v0/employee-roles [DELETE] -> Delete an employee role
_______________________________________________________________________________________
EMPLOYEE PERSONAL INFO
- api/v0/employees-personal-info [GET] -> Receive all employee personal infos
- api/v0/employees-personal-info/{id} [GET] -> Receive an employee personal info by id
- api/v0/employees-personal-info [POST] -> Save a new employee personal info into the db
- api/v0/employees-personal-info [PUT] -> Update an employee personal info
- api/v0/employees-personal-info [DELETE] -> Delete an employee personal info
_______________________________________________________________________________________
EMPLOYEE
- api/v0/employees [GET] -> Receive all employees
- api/v0/employees/{id} [GET] -> Receive an employee by id
- api/v0/employees [POST] -> Save a new employee into the db
- api/v0/employees [PUT] -> Update an employee
- api/v0/employees [DELETE] -> Delete an employee
_______________________________________________________________________________________
PROJECT
- api/v0/projects [GET] -> Receive all projects
- api/v0/projects/{id} [GET] -> Receive a project by id
- api/v0/projects [POST] -> Save a new project into the db
- api/v0/projects [PUT] -> Update a project
- api/v0/projects [DELETE] -> Delete a project
- api/v0/projects/add-employee-to-project [POST] -> Add a new employee to the project
- api/v0/projects/delete-employee-from-project [POST] -> Delete a employee from project

POSTMAN CREATED EMPLOYEE ROLE
![image](https://github.com/AzimovRuslan/aston-hibernate-task/assets/55226276/5e5c66f9-d085-494f-add8-59d1be9e2a6c)



POSTMAN CREATED EMPLOYEE PERSONAL INFO
![image](https://github.com/AzimovRuslan/aston-hibernate-task/assets/55226276/64d07a66-d19a-44e2-8a55-d1fb015594f2)



POSTMAN CREATED EMPLOYEE
![image](https://github.com/AzimovRuslan/aston-hibernate-task/assets/55226276/6dc5d572-60e6-46e3-8817-730862cca903)



POSTMAN CREATED PROJECT
![image](https://github.com/AzimovRuslan/aston-hibernate-task/assets/55226276/052a4463-a45f-4286-b99e-fd1cf3125bca)



POSTMAN ADDED EMPLOYEE TO PROJECT
![image](https://github.com/AzimovRuslan/aston-hibernate-task/assets/55226276/2a79804d-758c-4f65-941f-6f6d94f6c827)






