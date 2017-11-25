# AzureAdGraphApi

All URIs are relative to *https://graph.windows.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createLocalAccountUser**](AzureAdGraphApi.md#createLocalAccountUser) | **POST** /{tenant_name}/users?api-version&#x3D;1.6 | 
[**deleteUser**](AzureAdGraphApi.md#deleteUser) | **DELETE** /{tenant_name}/users/{user_id}?api-version&#x3D;1.6 | 
[**getUser**](AzureAdGraphApi.md#getUser) | **GET** /{tenant_name}/users/{user_id}?api-version&#x3D;1.6 | Get a user information
[**getUsers**](AzureAdGraphApi.md#getUsers) | **GET** /{tenant_name}/users?api-version&#x3D;1.6 | Get users information by filter
[**resetUserPassword**](AzureAdGraphApi.md#resetUserPassword) | **PATCH** /{tenant_name}/users/{user_id}?api-version&#x3D;1.6 | 


<a name="createLocalAccountUser"></a>
# **createLocalAccountUser**
> B2CUser createLocalAccountUser(tenantName, authorization, userCreationRequest)



Create a local account user with minimum required information. (https://msdn.microsoft.com/en-us/library/azure/ad/graph/api/users-operations#CreateLocalAccountUser)

### Example
```java
// Import classes:
//import org.alf.aadb2c.ApiException;
//import org.alf.aadb2c.api.AzureAdGraphApi;


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
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenantName** | **String**| The name of your B2C tenant, in the format &lt;name&gt;.onmicrosoft.com |
 **authorization** | **String**| The value must be &#39;Bearer access_token&#39; |
 **userCreationRequest** | [**UserCreationRequest**](UserCreationRequest.md)| The request body contains the properties of the user to create. At a minimum, you must specify the required properties for the account use. |

### Return type

[**B2CUser**](B2CUser.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deleteUser"></a>
# **deleteUser**
> deleteUser(tenantName, authorization, userId)



Deletes a user. Deleted users might not be recoverable. (https://msdn.microsoft.com/en-us/library/azure/ad/graph/api/users-operations#DeleteUser)

### Example
```java
// Import classes:
//import org.alf.aadb2c.ApiException;
//import org.alf.aadb2c.api.AzureAdGraphApi;


AzureAdGraphApi apiInstance = new AzureAdGraphApi();
String tenantName = "tenantName_example"; // String | The name of your B2C tenant, in the format <name>.onmicrosoft.com
String authorization = "authorization_example"; // String | The value must be 'Bearer access_token'
String userId = "userId_example"; // String | The user ID. Can be the object ID (GUID) or the user principal name
try {
    apiInstance.deleteUser(tenantName, authorization, userId);
} catch (ApiException e) {
    System.err.println("Exception when calling AzureAdGraphApi#deleteUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenantName** | **String**| The name of your B2C tenant, in the format &lt;name&gt;.onmicrosoft.com |
 **authorization** | **String**| The value must be &#39;Bearer access_token&#39; |
 **userId** | **String**| The user ID. Can be the object ID (GUID) or the user principal name |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getUser"></a>
# **getUser**
> B2CUser getUser(tenantName, authorization, userId)

Get a user information

Gets a specified user. You can use either the object ID (GUID) or the user principal name (UPN) to identify the target user (https://msdn.microsoft.com/en-us/library/azure/ad/graph/api/users-operations#GetAUser)

### Example
```java
// Import classes:
//import org.alf.aadb2c.ApiException;
//import org.alf.aadb2c.api.AzureAdGraphApi;


AzureAdGraphApi apiInstance = new AzureAdGraphApi();
String tenantName = "tenantName_example"; // String | The name of your B2C tenant, in the format <name>.onmicrosoft.com
String authorization = "authorization_example"; // String | The value must be 'Bearer access_token'
String userId = "userId_example"; // String | The user ID. Can be the object ID (GUID) or the user principal name
try {
    B2CUser result = apiInstance.getUser(tenantName, authorization, userId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AzureAdGraphApi#getUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenantName** | **String**| The name of your B2C tenant, in the format &lt;name&gt;.onmicrosoft.com |
 **authorization** | **String**| The value must be &#39;Bearer access_token&#39; |
 **userId** | **String**| The user ID. Can be the object ID (GUID) or the user principal name |

### Return type

[**B2CUser**](B2CUser.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getUsers"></a>
# **getUsers**
> B2CUsers getUsers(tenantName, authorization, filter)

Get users information by filter

Gets a list of user which fulfill given filter. (https://msdn.microsoft.com/en-us/library/azure/ad/graph/api/users-operations#GetUsers)

### Example
```java
// Import classes:
//import org.alf.aadb2c.ApiException;
//import org.alf.aadb2c.api.AzureAdGraphApi;


AzureAdGraphApi apiInstance = new AzureAdGraphApi();
String tenantName = "tenantName_example"; // String | The name of your B2C tenant, in the format <name>.onmicrosoft.com
String authorization = "authorization_example"; // String | The value must be 'Bearer access_token'
String filter = "filter_example"; // String | The specific filter to obtain the list of user. eg. objectId, creationType, displayName, givenName, surname, userType, userName, emailAddress ...etc
try {
    B2CUsers result = apiInstance.getUsers(tenantName, authorization, filter);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AzureAdGraphApi#getUsers");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenantName** | **String**| The name of your B2C tenant, in the format &lt;name&gt;.onmicrosoft.com |
 **authorization** | **String**| The value must be &#39;Bearer access_token&#39; |
 **filter** | **String**| The specific filter to obtain the list of user. eg. objectId, creationType, displayName, givenName, surname, userType, userName, emailAddress ...etc |

### Return type

[**B2CUsers**](B2CUsers.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="resetUserPassword"></a>
# **resetUserPassword**
> resetUserPassword(tenantName, authorization, userId, passwordResetRequest)



Reset the password of a B2C user (https://msdn.microsoft.com/en-us/library/azure/ad/graph/api/users-operations#ResetUserPassword)

### Example
```java
// Import classes:
//import org.alf.aadb2c.ApiException;
//import org.alf.aadb2c.api.AzureAdGraphApi;


AzureAdGraphApi apiInstance = new AzureAdGraphApi();
String tenantName = "tenantName_example"; // String | The name of your B2C tenant, in the format <name>.onmicrosoft.com
String authorization = "authorization_example"; // String | The value must be 'Bearer access_token'
String userId = "userId_example"; // String | The user ID. Can be the object ID (GUID) or the user principal name
UserPasswordResetRequest passwordResetRequest = new UserPasswordResetRequest(); // UserPasswordResetRequest | The request body contains the properties of the user to update.
try {
    apiInstance.resetUserPassword(tenantName, authorization, userId, passwordResetRequest);
} catch (ApiException e) {
    System.err.println("Exception when calling AzureAdGraphApi#resetUserPassword");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenantName** | **String**| The name of your B2C tenant, in the format &lt;name&gt;.onmicrosoft.com |
 **authorization** | **String**| The value must be &#39;Bearer access_token&#39; |
 **userId** | **String**| The user ID. Can be the object ID (GUID) or the user principal name |
 **passwordResetRequest** | [**UserPasswordResetRequest**](UserPasswordResetRequest.md)| The request body contains the properties of the user to update. |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

