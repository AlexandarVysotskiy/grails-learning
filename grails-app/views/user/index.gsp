<!DOCTYPE html>
<html>
<head>
    <title>User list</title>
    <meta name="layout" content="headerFooter"/>
    <asset:stylesheet src="application.css"/>
</head>

<body onload="">
<div class="content scaffold-list">
    <g:form controller="user" action="index">
        <label>Input user's name:</label>

        <g:hasErrors bean="${userCommand}">
            <ul>
                <g:eachError var="err" bean="${userCommand}">
                    <li>${err}</li>
                </g:eachError>
            </ul>
        </g:hasErrors>

        <div class="form-group">
            <g:textField name="userName"/>

            <g:textField name="pokemonName"/>

            <g:textField name="from"/>

            <g:textField name="to"/>

            <g:submitButton name="search"/>
        </div>

        <g:each var="user" in="${users}">
            <p>User with name: ${user.name}, has next pokemon(s):</p>
            <g:each var="pokemon" in="${user.pokemons}">
                <p>Pokemon name: ${pokemon.name}</p>
            </g:each>
        </g:each>
    </g:form>

    <g:if test="${users}">
        <div class="pagination">
            <g:paginate controller="user" action="index"
                        max="5" total="${userCount}"/>
        </div>
    </g:if>
</div>
</body>
</html>