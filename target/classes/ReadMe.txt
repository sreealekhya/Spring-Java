To run the program:

Import maven project
mvn clean install
run Application calss->the service is up and running on localhost:8080

Happy scenarios:
To add User >
curl -i -X PUT -H "Content-Type:application/json" -d "{\"userName\" : \"alekhya\",\"roleIdentifier\" : \"A_user\"}" http://localhost:8080/addUserWithRole
To delete a user with role >
curl -i -X DELETE -H "Content-Type:application/json" -d "{\"userName\" : \"alekhya\",\"roleIdentifier\" : \"A_user\"}" http://localhost:8080/deleteUserWithRole
To check access:
curl -i -X GET -H "Content-Type:application/json" -d "{\"userName\" : \"alekhya\",\"actionType\" :\"READ\",\"resource\":\"A\"}" http://localhost:8080/checkUserWithRole


