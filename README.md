# kafana
Kafana is a studies/college management application based on an AngularJS frontend (brena) 
and a java/spring RESTful backend (halid).

# Setup
## Brena
For `brena` you will need to have `npm` (along with `nodejs`) installed on your machine.<br>
To start the http server navigate to `../kafana/brena` and run:
```
npm start
```
The http server will run `brena` on `localhost:8080`

## halid
For halid you need `java` and `maven`.
To start `halid` in a tomcat server navigate to `../kafana/halid` and run:
```
mvn tomcat7:run
```
`halid` will run on `localhost:5000`
