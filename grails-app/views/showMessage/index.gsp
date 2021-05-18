<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>

<g:link controller="showMessage" action="changeLanguage">
    <button type="button">${message(code: 'change.language')}</button>
</g:link>

<h1>
    <div>
        ${digit}
    </div>

    <div>
        <h3>Current locale ${locale}</h3>
    </div>

    <div>
        <g:message code="good.morning"/>
    </div>

    <g:form controller="showMessage" action="inputDigit">
        <div class="form-group">
            <label>Before convert: ${message?.text}</label>
            <g:textField name="text" value="${message.text}"/>
            <label>After convert: ${message?.digit}</label>
            <g:textField name="digit" value="${message.digit}"/>
        </div>
        <g:submitButton name="messageSent"/>
    </g:form>
</h1>
</body>
</html>