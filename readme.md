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
### Command Line###
Interactive Mode command line have some benefits

1. Allows for quicker execution of commands
2. Use TAB for autocomplete commands

To activate interactive mode type 'grails' at the command line

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
runs app again and click hellowrorldcontroller link under availabla controller

you can response directly or setting different view using `render` method

```java
package com.javaaround

class HelloworldController {

    def index() { 
    	//render "Hello World" // response directly
    	render(view : 'greet.gsp') //setting different view
    }
}
```



### Domain ###
Domain is used to representation of app data.command create a domain<br>
`grails create-domain-class com.javaaround.usermanagement.user`

```java
package com.javaaround.usermanagement

class User {
	String userId
	String fullName
	String address
    static constraints = {
    	//validation
    	userId (blank: false)
		fullName (blank: false)
		address (blank: false)
    }
}
```
###Displaying Domain Contents###
```java
package com.javaaround
import com.javaaround.usermanagement.User;
class HelloworldController {
    // the framework will automatically look for a GSP file 
    //located in a folder with the same method name as the controller under views 
    //since there is render.
    def index() { 
        //render "Hello World"; //render directly
        //render (view: "greet"); // render specific view
        
        User user = new User(userId: 'IT007', fullName:'Md.Shamim Miah', address:'Tangail')
        
        // attach in view
        [ user:user] 

        /*
        if register view name
        def map = [ user:user ] 
        render(view: "display", model: map)
        */
    }
    
}
```
```jsp
<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Grails</title>
</head>
<body>
    Helloworld
    UserId: <g:fieldValue bean="${user}" field="userId"/><br/>
    Full Name: <g:fieldValue bean="${user}" field="fullName"/><br/>
    Address: <g:fieldValue bean="${user}" field="address"/><br/>
</body>
</html>
```

### Display a List ###
```java
package com.javaaround
import com.javaaround.usermanagement.User;
class HelloworldController {
    
    def index() { 
        //render "Hello World"; //render directly
        //render (view: "greet"); // render specific view
        User user = new User(userId: 'IT007', fullName:'Md.Shamim Miah', address:'Tangail')
        

        /*if register view name
        def map = [ user:user ] 
        render(view: "display", model: map)
        */
        def userList = []
        userList << new User(userId: 'IT007', fullName:'Md.Shamim Miah', address:'Tangail')
        userList << new User(userId: 'IT008', fullName:'Md.dd', address:'dgggd')
        userList << new User(userId: 'IT0010', fullName:'Md.dd', address:'ad')

        // attach in view
        [ user:user,userList:userList ] 
    }
    
}
```

```jsp
<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Grails</title>
</head>
<body>S
    Helloworld
    UserId: <g:fieldValue bean="${user}" field="userId"/><br/>
    Full Name: <g:fieldValue bean="${user}" field="fullName"/><br/>
    Address: <g:fieldValue bean="${user}" field="address"/><br/>
    <g:each in="${userList}" var="user">
        ${user.userId}, ${user.fullName},${user.address} <br/>
        
    </g:each>     
</body>
</html>
```
### Groovy Object-relational mapping (GORM) - Crud ###
```java
package com.javaaround
import com.javaaround.usermanagement.User;
class HelloworldController {
    
    def index() { 
        //render "Hello World"; //render directly
        //render (view: "greet"); // render specific view
        User user = new User(userId: 'IT007', fullName:'Md.Shamim Miah', address:'Tangail')
        
        /*if register view name
        def map = [ user:user ] 
        render(view: "display", model: map)
        */
        
        //save into db
        user.save()
        //read
        User u = User.get(1)

        //update
        u.fullName="update"
        u.save()

        //delete
        //u.delete()

        //no of record
        println(u.count)


        def userList = []
        userList << new User(userId: 'IT007', fullName:'Md.Shamim Miah', address:'Tangail')
        userList << new User(userId: 'IT008', fullName:'Md.Shohel', address:'Feni')
        userList << new User(userId: 'IT0010', fullName:'Md.Mozzammel', address:'Dhaka')

        // set view model
        [ user:user,userList:userList ] 
    }
    
}
```

Grails bydefault save data in h2 database. you can view the data by h2 web console

`http://localhost:8484/myapp/dbconsole`

go conf/application.yml for jdbc url .copy development jdbc url and paste in web console jdbc url and click login

### Layout Template ###
Usually the header, footer, and sidebars stays the same and only the content at the middle of the screen that change.Grails comes with template(main.gsp) that respective page content automatically add into main.gsp . you don't need add all thing in your page !!!

layouts/main.gsp

`<g:layoutTitle default="Grails"/>` is used to replace title of respective page if respetive has no title then Grails show in title bar

`<g:layoutHead/>`  is used to replace respective page head tag content

`<g:layoutBody/>` is used to replace respective page body tag content

### Static Scaffolding ###
To get started quickly with Grails it is often useful to use a feature called Scaffolding to generate  some basic CRUD interfaces(views,crud logic code at controller) for a domain class automatically.Static Scaffolding means the code can be viewed and modified, and not generated at runtime. where as dynamic scaffolding generate code at runtime you can't see code !!!!.

create user controller <br/>
`grails create-controller '*'`

### view ###
view is used to display app data<br>

`grails generate-views com.javaaround.usermanagement.User`

//com.javaaround.usermanagement.user == fully qualified model name <br/>

if you want to generate everything(view,controller) of a single command you can use

`grails generate-all com.javaaround.usermanagement.User`

run app again and click usercontroller link under available controller and add some user

### Explanation of auto generate code ###
UserController.groovy
```groovy
def index(Integer max) {
    params.max = Math.min(max ?: 10, 100)
    respond User.list(params), model:[userCount: User.count()]
}
```
params Scopes - Mutable map of incoming request query string or POST parameters
`def id = params["id"] or def id = params.id`
The `respond` method uses Content Negotiation to respond with the most appropriate content type.Syntax <br/>

Parameters:

object - The object to render
arguments - A map of arguments.
Supported arguments:

view - The view to use in case of HTML rendering
model - The model to use in case of HTML rendering
[formats:['xml', 'json']] // pick the best content type to respond with from the given formats

index.gsp
```html
<f:table collection="${userList}" />
<div class="pagination">
    <g:paginate total="${userCount ?: 0}" />
</div>
```

```groovy
def show(User user) {
    respond user
}
```
show.gsp
```html
<f:display bean="user" />
```

```groovy
def create() {
    println(params)
    respond new User(params)
}
```
create.gsp
```html
<g:form action="save">
    <fieldset class="form">
        <f:all bean="user"/>
    </fieldset>
    <fieldset class="buttons">
        <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
    </fieldset>
</g:form>
```
```groovy
@Transactional
def save(User user) {
    if (user == null) {
        transactionStatus.setRollbackOnly()
        notFound()
        return
    }

    if (user.hasErrors()) {
        transactionStatus.setRollbackOnly()
        respond user.errors, view:'create'
        return
    }

    user.save flush:true

    request.withFormat {
        form multipartForm {
            flash.message = message(code: 'default.created.message', args: [message(code: 'user.label', default: 'User'), user.id])
            redirect user
        }
        '*' { respond user, [status: CREATED] }
    }
}
```
Grails supports the concept of flash scope as a temporary store to make attributes available for this request and the next request only
`flash.message = "User not found for id ${params.id}"`

### Change App Default Page ###
you can change application default page .go to controller\grails3\UrlMappings.groovy
uncomment `"/"(view:"/index")` add `"/"(action: "index",controller: "user")`


```java
package com.javaaround

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        //"/"(view:"/index")
        "/"(action: "index",controller: "user")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
```
### Dynamic Scaffolding ###
Dynamic scaffolding means there is no need to generate code, as the functionality is generated at runtime.Dynamic scaffolding is to enable it by setting the *scaffold* property in the controller to a specific domain class

```groovy
class RoleController {
    static scaffold = Role
}
```
No need other code.You get CRUD operation !!!

### Service Layer ###

The Grails team(expert) discourages the all embedding of core application logic inside place(controllers), as it does not promote reuse and a clean separation of concerns.it may occur Don't Repeast Yourself (DRY) Principle.

 
The real purpose of a controller should control (routing logic e.g receive request,call most approprivate business logic,call view to display) your app

Services in Grails are the place to put the majority of the logic in your application

`grails create-service com.javaaround.usermanagement.UserService`

```java
package com.javaaround.usermanagement

import grails.transaction.Transactional
import com.javaaround.usermanagement.User

@Transactional
class UserService {

    def updateUser(User user) {
        user.save()
    }
}

```
UserController.java
```java
def userService  //dependency injection
userService.updateUser(user)
```

### Validation ###
Grails validation capability is built on Spring's Validator API and data binding capabilities

User.java
```java
static constraints = {
    //validation key:value
    //size chararcter between 2 and 5,it can't blank and unique
    userId size:2..5 , blank: false , unique: true 

    fullName blank: false
    address blank: false

    //valid email
    email email: true

    // age minimum 18
    age min: 18

    // you can't give future data
    birthDate max: new Date()
}
```

Display error : `<g:renderErrors bean="${user}" />`

If a constraint is violated Grails will by convention look for a message( grails-app/i18n/messages.properties) code of the form:

`[Class Name].[Property Name].[Constraint Code]`

eg.
`user.login.blank=Your login name must be specified!`

Thank you


