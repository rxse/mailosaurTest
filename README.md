# Ranorex Webtestit Email testing with Mailosaur sample

This is an example of how testing confirmation e-mails and fetching the email content scenarios could be solved with [Ranorex Webtestit](https://www.ranorex.com/webtestit/) and Java, using the  [Maliosaur client library](https://docs.mailosaur.com/docs/client-libraries).
In order to perform an e-mail testing scenario with Mailosaur, you need to have an Mailosaur account. You can register for a [free trial here](https://mailosaur.com/app/free-trial/).
After you register, make sure to store your Mailosaur Server ID and API Key into the default.endpoints.json as environment variables. The file located under the root folder of your project! 

```java
"environment": {
    "mailosaurAPIKey": "YOUR-API-KEY",
    "mailosaurServerID": "YOUR-SERVER-ID"
    }
```
## Ranorex Webtestit

Ranorex Webtestit is a lightweight IDE optimized for building UI web tests with Selenium, Unittest or Protractor. It supports developing tests in Java, Python and TypeScript and includes built-in best practices such as the creation of Page Objects, separating test code from the testing framework, creating modular and reusable tests, cross-browser testing, [and more](https://www.ranorex.com/webtestit/beta/).

## Requirements

* [Ranorex Webtestit](https://www.ranorex.com/webtestit/)
* [Java JDK](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
	* [How to setup JDK for Ranorex Webtestit](https://discourse.webtestit.com/t/how-to-setup-the-java-jdk-for-use-with-webtestit/23)

## Instructions

* Make sure JDK is installed
* Open Ranorex Webtestit
* Click "Open remot project" and then select "custom"
* Enter the URL for this sample project (https://github.com/rxse/mailosaurTest.git)
* Choose a folder to clone into and confirm


## Other samples

* [Java Demoshop](https://github.com/rxse/java-demoshop)
* [TypeScript Demoshop](https://github.com/rxse/ts-demoshop)
* [Python Demoshop](https://github.com/rxse/python-demoshop)
* [Python Data-driven Sample](https://github.com/rxse/python-data-driven-sample.git)

## License

This project is licensed under the MIT License.