# Banking

The front-end for this project can be found in <https://github.com/UberAffe/UberAffe.github.io> under the pages and helpers folders.
If you want to run this project, you can clone this directory and copy these files from the front-end:
* pages
  * bank.html
  * customer.html
  * employee.html
* helpers
  * Customer.css
  * Customer.js
  * Employee.css
  * Employee.js
  * Login.js
  
Export the java project as a .war and add it to the webapp directory of a tomcat installation.
In the Login.js you will need to change the ip address at the top of the file to point at your specific tomcat instance.
You will also need to have a postgres database that implements all of the tables, functions and stored procedures.

Future Improvements:
* Add conditional logic to the project to generate the necessary tables, functions, and stored procedures on the targeted database.
* Delegate the database connection information to an external configuration file.
