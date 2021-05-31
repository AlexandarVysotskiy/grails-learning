<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Edit user</title>
    <meta name="layout" content="headerFooter"/>
</head>

<body onload="">
<g:form controller="user" action="saveNewUser">
    <g:if test="${user}">
        <g:hiddenField name="userId" value="${user.id}"/>
    </g:if>

    <div>
        <p>User login:</p>
        <g:textField name="login" value="${user ? user.login : ""}"/>
    </div>

    <div>
        <p>User first name:</p>
        <g:textField name="firstName" value="${user ? user.firstName : ""}"/>
    </div>

    <div>
        <p>User last name:</p>
        <g:textField name="lastName" value="${user ? user.lastName : ""}"/>
    </div>

    <div>
        <p>User password:</p>
        <g:textField name="password" value="${user ? user.password : ""}"/>
    </div>

    <g:submitButton style="margin: 1rem 0 0 0" value="Save" name="Save"/>

</g:form>
</body>
</html>