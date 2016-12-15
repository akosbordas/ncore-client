# NcoreClient

[![Build Status](https://travis-ci.org/akosbordas/ncore-client.svg?branch=master)](https://travis-ci.org/akosbordas/ncore-client) [![Coverage Status](https://coveralls.io/repos/github/akosbordas/ncore-client/badge.svg?branch=master)](https://coveralls.io/github/akosbordas/ncore-client?branch=master)

NcoreClient is a Java client for [https://ncore.cc](https://ncore.cc) torrent site. This library makes it easy to automate your torrent downloads searches from any Java program based on your needs. Ncore is a restricted site. You need to have an account on the site to use this client.

## Getting started

To setup library in your project you can use `maven` artifact by adding the following lines to your `pom.xml`:

```
<dependency>
  <groupId>com.github.akosbordas</groupId>
  <artifactId>ncore-client</artifactId>
  <version>1.0.0-RC1</version>
</dependency>
```

## Background

This library uses [Apache HttpClient](http://hc.apache.org/httpcomponents-client-4.5.x/index.html) to make requests of [https://ncore.cc](https://ncore.cc) and [Jsoup](https://jsoup.org/) to parse pages. `NcoreClient` is the main interface which allows you to create another ways of implementation if you need. 
If you don't need custom implementation, you can use my default one as well (`DefaultNcoreClient`). Each operation tries to login to the site if the connection has not been initialized yet or the session has already expired.

## Usage

If you are too lazy to read this document just try my sample application in `sample` package. After you filled out your credentials in `credential.properties` you can easily test it.

#### Login

First off you must instantiate a client. There are two ways to do this. You can use static methods on `CredentialsProvider` class to store your `username` and `password` for your ncore account. In this case all of your client instances are going to use the same username and password combination for connection.

```java
CredentialsProvider.setUsername(credentialProperties.getProperty("username"));
CredentialsProvider.setPassword(credentialProperties.getProperty("password"));

NcoreClient client = new DefaultNcoreClient();
```

The other option to instantiate your client by setting username and password directly in it's constructor:

```java
NcoreClient client = new DefaultNcoreClient("username", "password");
```
#### How to search

There are multiple ways to search torrents on the site:

* Search by a single term without any filter (site defaults will be used): 
    ```java
    client.search("Inception.2010.iNTERNAL.BDRip.x264-REGRET");
    ```
* Search by term and use filter for torrent types. You can specify any number of torrent types using the method with varargs.  
    ```java
    client.search("Inception.2010.iNTERNAL.BDRip.x264-REGRET", new TorrentTypeCriterion(TorrentType.MOVIE_HD), new TorrentTypeCriterion(TorrentType.MOVIE_SD) /* ... and many more criteria */);
    ```    
    ... or if varargs does not fit to your needs than you can pass a list of criteria as well:
    ```java
    List<TorrentTypeCriterion> criteria = new ArrayList<>();
    criteria.add(new TorrentTypeCriterion(TorrentType.MOVIE_HD));
    criteria.add(new TorrentTypeCriterion(TorrentType.MOVIE_SD));
    /* ... and many more criteria */
    client.search("Inception.2010.iNTERNAL.BDRip.x264-REGRET", criteria);
    ```  
    If you don't like to write too much I have written static factory methods to all possible torrent type criteria. You can find these in `CriteriaFactory` class. With static imports the above example will be much easier: 
    ```java
    client.search("Inception.2010.iNTERNAL.BDRip.x264-REGRET", hdMovie(), sdMovie());
    ```
    
All searches will be performed with Hungarian language by default however you can search in english torrent types as well. You only need to set the english flag in the torrent type enum value:
```java
TorrentType type = MOVIE_DVD;
type.setEnglish(true);
new TorrentTypeCriterion(type);
```
..or if you want to simplify this you can use the `*En` static methods from the `CriteriaFactory`.

#### Search results

Each search request will return with a list of `TorrentListElement` (with zero elements if there were no results). Each `TorrentListElement` represents a row from the torrent search result list and contains the following properties:
* *id*: The id of the torrent in ncore database
* *name*: The name of the torrent as it is displayed in the search results.
* *url*: The url of the torrent details page

You can access to these properties by their getters.

**Note:** Currently the search only returns with the first page of the result list. If it is not enough for you please refine your search or create a pull request. :P

#### Detailed torrent properties

If you want to get more detailed information about a torrent. You can use the `getTorrentDetails` method on the client interface. It requires a torrent id to find the proper details page (you can use the torrent id's provided by the search results). 
```java
TorrentListElement torrentListElement = searchResult.get(0);
TorrentDetails torrentDetails = client.getTorrentDetails(torrentListElement.getId());
torrentDetails.getDescription(); // access to detailed torrent informations such as description 
``` 
It's up to you which torrent details you are interested in. You can iterate through all of the search results and query them one-by-one if you want. I didn't do that by default because it is not necessary every time and it could be a bit time consuming process. 

There are `TorrentDetails` implementations for each `TorrentTypes`. These contain type specific informations based on the type. If you are interested in the properties you can access, just check the fields in `*TorrentDetails` classes. You can find the general properites in the `TorrentDetails` class itself.

#### Download torrents

Finally you can download a torrent if you want. You only need to specify the id and and a path where you want to save it.
After it is downloded you can schedule it for auto download or anything you want. :)

```java
client.download(torrentListElement.getId(), "c:\\tmp\\");
``` 

#### Final notes
I am not responsible for any technical malfunction or other problems caused by this library. Please use it with responsibility and do not make any harm for anyone. :)
