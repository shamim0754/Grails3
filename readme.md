### Grails Introduction : ### 

Java web development as it stands today is dramatically more complicated than it needs to be. Most modern web frameworks in the Java space are over complicated and don't embrace the Don't Repeat Yourself (DRY) principles.
Dynamic frameworks like Rails, Django and TurboGears helped pave the way to a more modern way of thinking about web applications. Grails builds on these concepts and dramatically reduces the complexity of building web applications on the Java platform. What makes it different, however, is that it does so by building on already established Java technologies like Spring and Hibernate.

### Grails 3.0 Feature : ###
1. Grails is now based on Spring Boot and Spring 4.2.
2. Build system changed from Gant to Gradle.
3. existing features were reimplemented using Traits.
4. new features like Profiles and Interceptors were added.

### Installation ###
1. Download grails latest version [download link](https://github.com/grails/grails-core/releases)<br>
	* Setup environment variables:<br>
	 GRAILS_HOME=/path/to/grails & attach GRAILS_HOME to PATH <br>Variable [see guide](http://www.javatpoint.com/<br>how-to-set-path-in-java)<br>
	 check installation ok<br>
	 grails -version

### Create App ###
grails create-app is used to create grails app
General Syntax:
grails create-app [name] [--skip-wrapper] [--profile] [profile name] [--features] [FEATURE NAMES]
[check doc](http://docs.grails.org/latest/ref/Command%20Line/create-app.html)

`grails create-app Grails3`
### Setting App ###
grails App run on default port 8080 and no context path(domain name).if you want change this behaviour then go to grails-app\conf\application.yml and add following setting at last

```yml
server:
  port: 8484
  contextPath: /myapp
```  
### Run App ###	
grails run-app is used to run grails app . Befault it is run on embeeded tomcat container
General Syntax:
grails [env]* run-app

[check doc](http://docs.grails.org/latest/ref/Command%20Line/run-app.html)

`grails run-app`
	
### Browse App ###
http://localhost:8484/myapp
### Deploying App other external server ###
we can deploy app  external container (Jboss, Glassfish,websphere etc.) by follwing command(generats war on build directory) 

`grails war`

### Controller ###
A controller is responsible for handling incoming web requests and performing actions such as redirects, rendering views and so on.Create Helloworld controller automatically by following command<br>
`grails create-controller com.javaaround.helloworld`

create helloworld controller with package com.javaaround if you don't provide package then it will create default package with app name like grails3.helloworld

```java
package com.javaaround

class HelloworldController {

    def index() { 
    	render "Hello World";
    }
}


