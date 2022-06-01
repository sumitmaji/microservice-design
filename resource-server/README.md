# Resource Server

- For `local` eureka and config clients are disabled.
- For `dev`,`prod` eureka and config clients are enabled. The configurations are fetched from
Configuration server. The configuration server fetches the config from [`git repo`](https://github.com/sumitmaji/spring-app-prop-repo).

## In order to configure resource server to use Auth0 follow the below article
### `Auth0`
- [`1`](https://auth0.com/docs/quickstart/backend/java-spring-security5?_ga=2.225893971.815247790.1653906983-383438293.1653444346&_gl=1*enohx7*rollup_ga*MzgzNDM4MjkzLjE2NTM0NDQzNDY.*rollup_ga_F1G3E656YZ*MTY1MzkwNjE3MC4xMC4xLjE2NTM5MDc4ODEuNjA.)
- [`2`](https://auth0.com/docs/quickstart/backend/java-spring-security5/02-using)
- [`3`](https://auth0.com/docs/get-started/authentication-and-authorization-flow/call-your-api-using-the-authorization-code-flow)

### Creating and configuring jwk and jws for spring boot resource server and auth server
- [`JWS & JWK`](https://www.baeldung.com/spring-security-oauth2-jws-jwk)

### Creating Encoded JWT and decoding
[`Okta Example`](https://developer.okta.com/blog/2018/10/31/jwts-with-java)

### Configuring resource server for JWT
[`Spring Example`](https://docs.spring.io/spring-security/reference/servlet/oauth2/resource-server/jwt.html)

- [`JWT handbook`](https://auth0.com/resources/ebooks/jwt-handbook)

### Difference between access token and Id toke
[`Access token and Id Token`](https://auth0.com/blog/id-token-access-token-what-is-the-difference/)

- [`Validating ID token`](https://auth0.com/docs/secure/tokens/id-tokens#how-to-validate-an-id-token)

https://connect2id.com/learn/oauth-2#optional-endpoints


