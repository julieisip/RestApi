"# sample" 

This is sample RestFul api webservice.


This API allow to perform search base on first name, last name, email and phone number.
It produces response in JSON. It access a MYSQL DB and base on the search parameter on the api it queries the DB and parse the result.

by adding more filter (query parameters) it refines the result of the search.

Implementation details:
Use Resteasy framework to create the restful api.
Spring Framework for connecting to MySQL db using JDBCTemplate.

This connect to DB using JNDI name look-up (server may need to set up JNDI config for DB  connections).


Sample use:

request:
http://localhost:8080/sample-api?lastName=doe
response:
[  
   {  
      "firstname":"john",
      "lastName":"doe",
      "email":"jd@gmail.com",
      "phone":"9023440989",
      "address":"1 main st.",
      "city":"halifax"
   },
   {  
      "firstname":"jane",
      "lastName":"doe",
      "email":"jad@gmail.com",
      "phone":"9023840979",
      "address":"34 main st.",
      "city":"halifax"
   }
]

request:http://localhost:8080/sample-api?lastName=doe&email=jad@gmail.com
response:
[  
   {  
      "firstname":"jane",
      "lastName":"doe",
      "email":"jad@gmail.com",
      "phone":"9023840979",
      "address":"34 main st.",
      "city":"halifax"
   }
]
