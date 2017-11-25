# study-swagger-api

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>io.swagger</groupId>
    <artifactId>study-swagger-api</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "io.swagger:study-swagger-api:1.0.0"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/study-swagger-api-1.0.0.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import org.alf.aadb2c.*;
import org.alf.aadb2c.auth.*;
import org.alf.aadb2c.model.*;
import org.alf.aadb2c.api.AzureAdGraphApi;

import java.io.File;
import java.util.*;

public class AzureAdGraphApiExample {

    public static void main(String[] args) {
        
        AzureAdGraphApi apiInstance = new AzureAdGraphApi();
        String tenantName = "tenantName_example"; // String | The name of your B2C tenant, in the format <name>.onmicrosoft.com
        String authorization = "authorization_example"; // String | The value must be 'Bearer access_token'
        UserCreationRequest userCreationRequest = new UserCreationRequest(); // UserCreationRequest | The request body contains the properties of the user to create. At a minimum, you must specify the required properties for the account use.
        try {
            B2CUser result = apiInstance.createLocalAccountUser(tenantName, authorization, userCreationRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AzureAdGraphApi#createLocalAccountUser");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://graph.windows.net*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*AzureAdGraphApi* | [**createLocalAccountUser**](docs/AzureAdGraphApi.md#createLocalAccountUser) | **POST** /{tenant_name}/users?api-version&#x3D;1.6 | 
*AzureAdGraphApi* | [**deleteUser**](docs/AzureAdGraphApi.md#deleteUser) | **DELETE** /{tenant_name}/users/{user_id}?api-version&#x3D;1.6 | 
*AzureAdGraphApi* | [**getUser**](docs/AzureAdGraphApi.md#getUser) | **GET** /{tenant_name}/users/{user_id}?api-version&#x3D;1.6 | Get a user information
*AzureAdGraphApi* | [**getUsers**](docs/AzureAdGraphApi.md#getUsers) | **GET** /{tenant_name}/users?api-version&#x3D;1.6 | Get users information by filter
*AzureAdGraphApi* | [**resetUserPassword**](docs/AzureAdGraphApi.md#resetUserPassword) | **PATCH** /{tenant_name}/users/{user_id}?api-version&#x3D;1.6 | 


## Documentation for Models

 - [AssignedLicenseItem](docs/AssignedLicenseItem.md)
 - [AssignedPlanItem](docs/AssignedPlanItem.md)
 - [B2CUser](docs/B2CUser.md)
 - [B2CUsers](docs/B2CUsers.md)
 - [PasswordProfile](docs/PasswordProfile.md)
 - [ProvisionedPlanItem](docs/ProvisionedPlanItem.md)
 - [SignInNameItem](docs/SignInNameItem.md)
 - [User](docs/User.md)
 - [UserCreationRequest](docs/UserCreationRequest.md)
 - [UserPasswordResetRequest](docs/UserPasswordResetRequest.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author



