<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>User's list</title>
    <meta name="layout" content="headerFooter"/>
    <asset:stylesheet src="application.css"/>
</head>

<body onload="">
<div>
    <g:form controller="user" action="addNewUser">
        <g:submitButton value="addNewUser" name="addNewUser"/>
    </g:form>
</div>

<div>
    <g:form controller="user" action="search">
        <g:textField name="login"/>

        <g:textField name="firstName"/>

        <g:textField name="lastName"/>

        <g:submitButton value="search" name="search"/>
    </g:form>
</div>

<div>
    <table>
        <g:each var="u" in="${users}">
            <tr>
                <td>
                    <p>Login: ${u.login}</p>
                </td>

                <td>
                    <p>First name: ${u.firstName}</p>
                </td>

                <td>
                    <p>Last name: ${u.lastName}</p>
                </td>

                <td>
                    <g:form controller="user" action="editUser" params="${params}">
                        <g:hiddenField name="id" value="${u.id}"/>

                        <g:submitButton name="edit" value="edit">Edit</g:submitButton>
                    </g:form>
                </td>

                <td>
                    <my:remove user="${u}">Remove</my:remove>
                </td>
            </tr>
        </g:each>
    </table>

    <div style="margin: 2rem 0 0 0">
        <g:paginate params="${params}" offset="0" max="5" controller="user" action="index"
                    total="${userTotal}"/>
    </div>
</div>
</body>
</html>