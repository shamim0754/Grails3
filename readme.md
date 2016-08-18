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
grails create-app command is used to create grails app<br/>
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
grails run-app is used to run grails app . Befault it is run on embeeded tomcat container<br/>
General Syntax:
grails [env]* run-app

[check doc](http://docs.grails.org/latest/ref/Command%20Line/run-app.html)

`grails run-app`
	
### Browse App ###
http://localhost:8484/myapp

### stop App ###
`grails stop-app`
or ctl-c

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
    	
    }
}
```

the framework will automatically look for a method name GSP file(in this case index.gsp)
located in a folder with the same name as the controller under views.
so create file views/helloworld/index.gsp

```gsp
<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Grails</title>
</head>
<body>
    Helloworld
</body>
</html>
``` 
you can respose directly or setting different view using `rend` method

```java
package com.javaaround

class HelloworldController {

    def index() { 
    	//render "Hello World" // respose directly
    	render(view : 'greet.gsp') //setting different view
    }
}
```

runs app again and click hellowrorldcontroller link under availabla controller

### Static Scaffolding ###
To get started quickly with Grails it is often useful to use a feature called Scaffolding to generate the skeleton of an application.Static Scaffolding means the code can be viewed and modified, and not generated at runtime. where as dynamic scaffolding generate code at runtime you can't see code !!!!

### Domain ###
Domain is used to representation of app data<br>
`grails create-domain-class com.javaaround.usermodule.user`
### view ###
view is used to display app data<br>

`grails generate-views com.javaaround.usermodule.user`

//com.javaaround.usermodule.user == fully qualified model name <br/>

create user controller <br/>
`grails create-controller com.javaaround.usermodule.user`


