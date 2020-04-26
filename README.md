# SPRING SECURITY USING JDBC AUTHENTICATION
A basic template for JDBC authentication using MySQL database in Spring Security. Below are the documents and videos I refered
to create this template
  - https://www.youtube.com/watch?v=LKvrFltAgCQ&list=PLqq-6Pq4lTTYTEooakHchTGglSvkZAjnE&index=7
  - https://docs.spring.io/spring-security/site/docs/current/reference/html5/#user-schema
  - https://dev.mysql.com/doc/refman/8.0/en/tutorial.html

## Additional Configurations to make it work

### Create below tables in MySQL Database

    CREATE TABLE USERS (
         USERNAME VARCHAR(50) PRIMARY KEY,
         PASSWORD VARCHAR(50) NOT NULL,
         ENABLED CHAR(1) CHECK (ENABLED IN ('Y', 'N')) NOT NULL
     );
     
    CREATE TABLE AUTHORITIES(
        USERNAME VARCHAR(50) NOT NULL,
        AUTHORITY VARCHAR(50) NOT NULL
     );

     

### Run below queries to configure foreign key and indexing

    ALTER TABLE AUTHORITIES ADD CONSTRAINT AUTHORITIES_UNIQUE UNIQUE (USERNAME, AUTHORITY);

    ALTER TABLE AUTHORITIES ADD CONSTRAINT AUTHORITIES_FK1 FOREIGN KEY (USERNAME) REFERENCES USERS (USERNAME);
    

### Configure your application.yml file with datasource configuration related to your MySQL
    
    spring:
    datasource:
      url: "jdbc:mysql://localhost/your-table-name"
      username: #username to connect to your DB
      password: #password to connect to your DB
      
      
  


