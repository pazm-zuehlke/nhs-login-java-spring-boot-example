# NHS Login Java Demo

### Prerequisites

* Java 8+
* Access to NHS Login sandpit (See [nhsconnect/nhslogin](https://github.com/nhsconnect/nhslogin#how-do-i-integrate-to-the-sandpit))


### Building

```./gradlew clean build```

### Running

```./gradlew bootRun```

Navigate browser to localhost:8081


### Integrating with the sandpit

Once you have generated your public/private key pair and recieved your client ID for the NHS login sandpit:

* Add your client ID to the `application.yml` file (under nhs.login.clientId)
* copy your own private key into `src/main/resources/keys/private_key.pem`