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
	<g:each in="${userList}" var="user">
        ${user.userId}, ${user.fullName},${user.address} <br/>
        
    </g:each>     
</body>
</html>