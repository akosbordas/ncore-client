# NcoreClient

[![Build Status](https://travis-ci.org/akosbordas/ncore-client.svg?branch=master)](https://travis-ci.org/akosbordas/ncore-client)

NcoreClient is a Java client for [https://ncore.cc](https://ncore.cc) torrent site. This library makes it easy to automate your torrent downloads, searches from any Java program based on your needs. Ncore is a restricted site. You need to have an account on the site to use this client.
<!---
### Getting started

To setup library you can use `maven`. Add the following lines to your `pom.xml`:

```
<dependency>
	<groupId>com.github.akosbordas</groupId>
	<artifactId>ncore-client</artifactId>
	<version>0.1.0</version>
</dependency>
```

### Background

This library uses [Apache HttpClient](http://hc.apache.org/httpcomponents-client-4.5.x/index.html) to make requests of [https://ncore.cc](https://ncore.cc) and (Jsoup)[https://jsoup.org/] to parse pages. `NcoreClient` is the main interface which allows you to create another ways of implementation. Each operation tries to login to the site if it detects that the connection has not been initialized already or the session is expired.

### Usage

First off you must instantiate a client. There are two ways to do this. You can use static methods on `CredentialsProvider` class to store your `username` and `password` for your ncore account. In this case all of your clients are going to use the same username and password combination for connection.

```java
CredentialsProvider.setUsername(credentialProperties.getProperty("username"));
CredentialsProvider.setPassword(credentialProperties.getProperty("password"));

NcoreClient client = new DefaultNcoreClient();
```

The other option to instantiate your client by setting username and password directly in it's constructor:

```java
NcoreClient client = new DefaultNcoreClient("username", "password");
```
--->
