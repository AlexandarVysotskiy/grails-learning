<!DOCTYPE html>
<html>
<head>
    <title>An Example Page</title>
    <meta name="layout" content="headerFooter"/>
</head>

<body onload="">
<div class="content scaffold-list">
    <g:form controller="login" action="index">
        <div>
            <label>Input user's name:</label>

            <g:textField name="login"/>

            <g:textField name="password"/>

            <g:submitButton name="enter"/>
        </div>
    </g:form>

    <label>${message}</label>
</div>
</body>
</html>