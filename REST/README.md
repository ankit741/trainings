# REST fundamentals

REST works on top of the HTTP protocol. Each URI works as an API resource. Therefore, we should use nouns as endpoints instead of verbs. RPC-style endpoints use verbs, for example,  **/api/v1/getPersons** . In comparison, in REST, this endpoint could be simply written as  **/api/v1/persons** . You must be wondering, then, how we can differentiate between the different actions performed on a REST resource. This is where HTTP methods help us. We can make our HTTP methods act as verbs, for example,  **GET** ,  **DELETE** , **POST** (for creating), **PUT** (for modifying), and **PATCH** (for partial updating). We’ll discuss this in more detail later. For now, the **getPerson** RPC-style endpoint is translated into **GET /api/v1/persons** **in REST.**

The REST endpoint is a unique URI that represents a REST resource. For example, **https://demo.app/api/v1/persons** is a REST endpoint. Additionally, **/api/v1/persons** is the endpoint path and **persons** is the **REST resource.**

A REST API does not maintain its state. It only transfers states from the server to the client or vice versa. This is why it is called  *REpresentational State Transfer* , or REST **for short.**

REST also makes use of HTTP cache control, which makes REST APIs  *cacheable* . Therefore, the client can also cache the representation (that is, the HTTP response) because every representation **is self-descriptive.**

REST operates using three **key components:**

* Resources **and URIs**
* **HTTP methods**
* **HATEOAS**

# Exploring HTTP methods and status codes

HTTP provides various HTTP methods. However, you are primarily going to use only five of them. To begin with, you want to have  **Create** ,  **Read** ,  **Update** , and **Delete** ( **CRUD** ) operations associated with **HTTP methods:**

* **POST** : Create **or search**
* **GET**: Read
* **PUT**: Update
* **DELETE**: Delete
* **PATCH** : **Partial update**

Some organizations also provide the **HEAD** method for scenarios where you just want to retrieve the header responses from the REST endpoints. You can hit any GitHub API with the **HEAD** operation to retrieve only headers; for example,  **curl --** **head https://api.github.com/users**.

NOTE

REST has no requirement that specifies which method should be used for which operation. However, widely used []()industry guidelines and practices suggest following **certain rules.**

Lets discuss each method **in detail.**


## POST

The HTTP **POST** method is normally what you want to associate with creating resource operations. However, there are certain exceptions when you might want to use the **POST** method for read operations. However, it should be put into practice after a well-thought-out process. One such exception is a search operation where the filter criteria have too many parameters, which might cross the **GET** call’s **length limit.**

A **GET** query string has a limit of 256 characters. Additionally, the HTTP **GET** method is limited to a maximum of 2,048 characters minus the number of characters in the actual path. On the other hand, the **POST** method is not limited by the size of the URL for submitting name and **value pairs.**

You may also want to use the **POST** method with HTTPS for a read call if the submitted input parameters contain any private or **secure information.**

For successful create operations, you can respond with the **201 Created** status,

## GET

The HTTP **GET** method is what you usually want to associate with read resource operations. Similarly, you must have observed the GitHub **GET /licenses** call that returns the available licenses in the GitHub system. Additionally, successful **GET **operations should be associated with the **200 OK** status code if the response contains data, or **204 No Content** if the response contains **no data.**

## PUT

The HTTP **PUT** method is what you usually want to associate with update resource operations. Additionally, successful update operations should be associated with a **200 OK** status code if the response contains data, or **204 No Content** if the response contains no data. Some developers use the **PUT** HTTP method to replace existing resources. For example, GitHub API v3 uses **PUT** to replace the **existing resource.**

## DELETE

The HTTP **DELETE** method is what you want to associate with resource deletion operations. GitHub does not provide the **DELETE** operation on the **licenses** resource. However, if you assume it exists, it will certainly look very similar to  **DELETE / licenses/agpl-3.0** . A successful **DELETE** call should delete the resource associated with the **agpl-3.0** key. Additionally, successful **DELETE** operations should be associated with the **204 No Content** **status code.**

## PATCH

The HTTP **PATCH** method is what you want to associate with partial update resource operations. Additionally, successful **PATCH** operations should be associated with a **200 OK** status code. **PATCH** is relatively new as compared to other HTTP operations. In fact, a few years ago, Spring did not have state-of-the-art support for this method for REST implementation due to the old Java HTTP library. However, currently, Spring provides built-in support for the **PATCH** method in **REST implementation.**


## HTTP status codes

There are five categories of HTTP status codes, **as follows:**

* Informational **responses (****100**–**199**)
* Successful **responses (****200**–**299**)
* **Redirects (****300**–**399**)
* Client **errors (****400**–**499**)
* Server **errors (****500**–**599**)


| **HTTP ****Status Code**          | **Description**                                                                                                                                                                           |
| --------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **200 OK**                        | For successful requests other than those**already created.**                                                                                                                              |
| **201 Created**                   | For successful**creation requests.**                                                                                                                                                      |
| **202 Accepted**                  | The request has been received but not yet acted upon. This is used when the server accepts the request, but the response cannot be sent immediately, for example, in**batch processing.** |
| **204 ****No Content**            | For successful operations that contain no data in**t he response.**                                                                                                                       |
| **304 ****Not Modified**          | This is used for caching. The server responds to the client that the resource is not modified; therefore, the same cache resource can**be used.**                                         |
| **400 ****Bad Request**           | This is for failed operations when input parameters either are incorrect or missing or the request itself**is incomplete.**                                                               |
| **401 Unauthorized**              | This is for operations that have failed due to unauthenticated requests. The specification says its unauthorized, but semantically, it**means unauthenticated.**                          |
| **403 Forbidden**                 | This is for failed operations that the invoker is not authorized**to perform.**                                                                                                           |
| **404 ****Not Found**             | This is for failed operations when the requested resource**doesnt exist.**                                                                                                                |
| **405 Method ****Not Allowed**    | This is for failed operations when the method is not allowed for the**requested resource.**                                                                                               |
| **409 Conflict**                  | This is for failed operations when an attempt is made for a duplicate**create operation.**                                                                                                |
| **429 Too ****Many Requests**     | This is for failed operations when a user sends too many requests in a given amount of time (**rate limiting).**                                                                          |
| **500 Internal ****Server Error** | This is for failed operations due to server errors. Its a**generic error.**                                                                                                               |
| **502 ****Bad Gateway**           | This is for failed operations when upstream server calls fail, for example, when an app calls a third-party payment service, but the**call fails.**                                       |
| **503 ****Service Unavailable**   | This is for failed operations when something unexpected has happened at the server, for example, an overload or a**service fails.**                                                       |


##  What is HATEOAS?

With HATEOAS, RESTful web services provide information dynamically through hypermedia. Hypermedia is a part of the content that you receive from a REST call response. This hypermedia content contains links to different types of media, such as text, images, **and videos.** Hypermedia links can be contained either in HTTP headers or the response body.

REST clients should possess a generic understanding of hypermedia so they can interact with RESTful web services without having any specific knowledge of how to interact with the server. You just call any static REST API endpoint, and you will receive the dynamic links as a part of the response to interact further.

# Best practices for designing REST APIs


## Using nouns and not verbs when naming a resource in the endpoint path

We previously discussed HTTP methods. HTTP methods use verbs. Therefore, it would be redundant to use verbs yourself, and it would make your call look like an RPC endpoint, for example,  **GET /getlicenses** . In REST, we should always use the resource name because, according to REST, you transfer the states and not the instructions. For example, let’s take another look at the GitHub license API, which retrieves licenses. It is  **GET /licenses** . That is perfect.


## Using the plural form for naming the collection resource in the endpoint path

we can use **/licenses** instead of  **/license** . A **GET** call returns the collection of licenses.


## Using hypermedia (HATEOAS)

Hypermedia (that is, links to other resources) makes the REST client.s job easier. There are two advantages []()if you provide explicit URL links in a response. First, the REST client is not required to construct the REST URLs on their own. Second, any upgrade in the endpoint path will be taken care of automatically and this, therefore, makes upgrades easier for clients **and developers**


## Versioning your APIs

The versioning of APIs is key for future upgrades. Over time, APIs keep changing, and you may have customers who are still using an older version. Therefore, you need to support multiple versions **of APIs.**

There are different ways you can version **your APIs:**

* *Using headers* : The GitHub API uses this approach. You can add an **Accept** header that tells you which API version should serve the request; for example, consider **the following:**

```
  Accept: application/vnd.github.v3+json
```

This approach gives you the advantage of setting the default version. If there is no **Accept** header, it should lead to the default version. However, if a REST client that uses a versioning header is not changed after a recent upgrade of APIs, it may break the functionality. Therefore, it is recommended that you use a **versioning header.**

* *Using an endpoint path* : In this approach, you add a version in the endpoint path itself; for example,  **https://demo.app/api/v1/persons** . Here, **v1** denotes that version **1** is being added to the **path itself.**

You cannot set default versioning out of the box. However, you can overcome this limitation by using other methods, such as request forwarding. Clients always use the intended versions of the APIs in **this approach.**

Based on your preferences and views, you can choose either of the preceding approaches for versioning. However, the important point is that you should always **use versioning.**

## Nesting resources

Consider this very interesting question: how are you going to construct the endpoint for resources that are nested or have a certain relationship? Lets take a look at some examples of customer resources from an **e-commerce perspective:**

* **GET /customers/1/addresses** : This returns the collection of addresses for **customer** **1**
* **GET /customers/1/addresses/2** : This returns the second address of **customer** **1**
* **POST /customers/1/addresses** : This adds a new address to customer **1**s addresses
* **PUT /customers/1/addresses/2** : This replaces the second address of **customer** **1**
* **PATCH /customers/1/addresses/2** : This partially updates the second address of **customer** **1**
* **DELETE /customers/1/addresses/2** : This deletes the second address of **customer** **1**

So far so good. Now, can  we have an altogether separate address resource endpoint ( **GET /addresses/2** )? It makes sense, and you can do that if there is a relationship that requires it; for example, orders and payments. Instead of  **/orders/1/payments/1** , you might prefer a separate **/payments/1** endpoint. In the microservice world, this makes more sense; for instance, you would have two separate RESTful web services for both orders **and payments.**

Now, if you combine this approach with hypermedia, it makes things easier. When you make a REST API request to customer  **1** , it will provide the customer 1 data and address links as hypermedia (that is, links). The same applies to orders. For orders, the payment link will be available **as hypermedia.**

However, in some cases, you might wish to have a complete response in a single request rather than using the hypermedia-provided URLs to fetch the related resource. This reduces your web hits. However, there is no rule of thumb. For a flag operation, it makes sense to use the nested endpoint approach; for example, **PUT /gist/2/star** (which adds a star) and **DELETE /gist/2/star** (which undoes the star) in the case of the **GitHub API.**

Additionally, in some scenarios, you might not find a suitable resource name when multiple resources are involved, for example, in a search operation. In that case, you should use a **direct/search** endpoint. This is **an exception.**


## Securing APIs

Securing your API is another expectation that requires diligent attention. Here are **some recommendations:**

* Always use HTTPS for **encrypted communication.**
* Always look for OWASPs top API security threats and vulnerabilities. These can be found on their website ( **https://owasp.org/www-project-api-security/** ) or their GitHub **repository (****https://github.com/OWASP/API-Security**).
* Secure REST APIs should have authentication in place. REST APIs are stateless; therefore, REST APIs should not use cookies or sessions. Instead, they should be secured using JWT or OAuth **2.0-based tokens.**


## Maintaining documentation

Documentation should be easily accessible and up to date with the latest implementation with their respective versioning. It is always good to provide sample code and examples. It makes the developer’s integration **job easier.**

A change log or a release log should list all the affected libraries, and if some APIs are deprecated, then replacement APIs or workarounds should be elaborated upon inside **the documentation.**


## Ensuring caching

HTTP already provides a caching mechanism. You just have to provide additional headers in the REST API response. Then, the REST client makes use of the validation to make sure whether to make a call or use the cached response. There are two ways to **do this:**

* **ETag** : ETag is a special header value that contains the hash or checksum value of the resource representation (that is, the response object). This value must change with respect to the response representation. It will remain the same if the resource response doesn’t change. Now, the client can send a request with another header field, called  **If-None-Match** , which contains the **ETag** value. When the server receives this request and finds that the hash or checksum value of the resource representation value is different from  **If-None-Match** , only then should it return the response with a new representation and this hash value in the **ETag** header. If it finds them to be equal, then the server should simply respond with a **304 (Not Modified)** **status code.**
* **Last-Modified** : This a[]()pproach is identical to the **ETag** way. However, instead of using the hash or checksum, it uses the timestamp value in RFC-1123 ([http://www.ietf.org/rfc/rfc1123.txt](http://www.ietf.org/rfc/rfc1123.txt)) in the format:  **Last-Modified: Wed, 21 Oct 2015 07:28:00 GMT** . It is less accurate than **ETag** and should only be used as **a fallback.**

In the **Last-Modified** approach, the client sends the **If-Modified-Since** header with the value received in the **Last-Modified** response header. The server compares the resource-modified timestamp value with the **If-Modified-Since** header value and sends a **304** status if there is a match; otherwise, it sends the response with a new **Last-Modified** **header.**

## Maintaining the rate limit

Maintaining the rate limit is important if you want to prevent the overuse of APIs. The HTTP status code **429 Too Many Requests** is used when the rate limit is infringed. Currently, there is no standard to communicate any warning to the client before the rate limit goes over. However, there is a popular way to communicate about it using response headers. These response headers are **as follows:**

* **X-Ratelimit-Limit** : The number of allowed requests in the current period, for example, **X-Ratelimit-Limit: 60**.
* **X-Ratelimit-Remaining** : The number of remaining requests in the current period, for example, **X-Ratelimit-Remaining: 55**.
* **X-Ratelimit-Reset** : The number of seconds left in the current period, for example, **X-Ratelimit-Reset: 1601299930**.
* **X-Ratelimit-Used** : The number of requests used in the current period, for example,  **X-Ratelimit-Used: 5** . This information then might be used by the client to keep track of the total number of available API calls for the **given period.**

So far, we have []()discussed various concepts related to REST. Next, let me introduce you to the app we will be building in this book using **these concepts.**
