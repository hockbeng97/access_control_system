# access_control_system

This is a simple web applcation which built by Angular, Java and Spring Boot.

A H2 database (In-memory Database) is used which can access by <b> localhos:t8082/h2-console </b> 

A simple databse table called <b> "access" </b> is created. Please refer the data dictionary below:

<table>
<tr>
  <th>Column</th>
  <th>Type(255)</th>
  <th>Constraint</th>
</tr>

<tr>
  <td>email</td>
  <td>varchar(255)</td>
  <td>PRIMARY</td>
</tr>

<tr>
  <td>feature_name</td>
  <td>varchar(255)</td>
  <td>PRIMARY</td>
</tr>

<tr>
  <td>can_access</td>
  <td>bit</td>
  <td>-</td>
</tr>
</table>

The sample data insert as below:

<table>
<tr>
  <th>email</th>
  <th>feature_name</th>
  <th>can_access</th>
</tr>

<tr>
  <td>abc@gmail.com</td>
  <td>view</td>
  <td>true</td>
</tr>

<tr>
  <td>abc@gmail.com</td>
  <td>modify</td>
  <td>true</td>
</tr>

<tr>
  <td>abc@gmail.com</td>
  <td>delete</td>
  <td>false</td>
</tr>
</table>


<b> How to start the application? </b>

1) Run the maven install
2) Start the front-end <br/>
  a) npm install <br/>
  b) Change directory to <i>test-web-ngx</i> npm run start
3) Start the back-end <br/>
  a) Run the AccessRest.java at test-web-rest/src/main/java/com/test/rest
  
  
  
<b> Test Case: </b>

1) Get Request: <br/>
  URL: localhost:8082/rest/feature/get-can-access-by-email-and-feature-name <br/>
  Parameter: <br/>
   a) email = abc@gmail.com <br/>
   b) featureName = view <br/>

2) POST Request: <br/>
  URL: localhost:8082/rest/feature/add-access <br/>
  Body : <br/>
  {
      "featureName": "view",
      "email": "abc@gmail.com",
      "enable": true
  }















