# microservice-design
A project that contains all the features of micro-service design

- Running spring boot from command line
```shell
mvn package
mvn spring-boot:run -Dspring.boot.run.arguments=--instanceId=sumit
```

- Running spring boot using java command
```shell
java -cp "app:app/lib/*" -Dserver.port=8080 com.sum.security.MyApplication
```

# Checking authorization code grant flow in Auth0
```shell
export CLIENT_ID=
export CLIENT_SECRET=

# Use the below output and call using browser and copy the code reponse
echo "https://skmaji.auth0.com/authorize?response_type=code&client_id=$CLIENT_ID&redirect_uri=http://localhost:8080/login/oauth2/code/auth0&scope=openid&state=adfasdf"

export CODE=

curl --request POST \
  --url 'https://skmaji.auth0.com/oauth/token' \
  --header 'content-type: application/x-www-form-urlencoded' \
  --data grant_type=authorization_code \
  --data client_id=$CLIENT_ID \
  --data client_secret=$CILENT_SECRET \
  --data code=$CODE \
  --data redirect_uri=http://localhost:8080/login/oauth2/code/auth0 \
  --data audience=$CLIENT_ID

export ACCESS_TOKEN=

curl -v --request GET \
  --url http://localhost:8081/users/api/welcome \
  --header 'authorization: Bearer $ACCESS_TOKEN' \
  --header 'content-type: application/json'
```

# Checking authorization code grant flow in keycloak

- Export clientId and clientSecret
```shell
export CLIENT_ID=microserviceclient
export CLIENT_SECRET=bFPQHeOg79Lr4bQWaPdR3nK3YQfveI1d
```
- Call the endpoint to authenticate user
```shell
echo "http://localhost:8080/realms/microservicedev/protocol/openid-connect/auth?response_type=code&client_id=$CLIENT_ID&redirect_uri=http://localhost:8081/callback&scope=openid&state=adfasdf"
```

- Get the authorization code
```shell
export CODE=
```

- Call the endpoint to get access token
```shell
curl --request POST \
  --url 'http://localhost:8080/realms/microservicedev/protocol/openid-connect/token' \
  --header 'content-type: application/x-www-form-urlencoded' \
  --data grant_type=authorization_code \
  --data client_id=$CLIENT_ID \
  --data client_secret=$CLIENT_SECRET \
  --data code=$CODE \
  --data redirect_uri=http://localhost:8081/callback \
  --data audience=$CLIENT_ID
```

- Get the access token
```shell
export ACCESS_TOKEN=
```

- Call secured resource
```shell
curl -v --request GET \
  --url http://localhost:8081/users/api/welcome \
  --header 'authorization: Bearer $ACCESS_TOKEN' \
  --header 'content-type: application/json'
```
