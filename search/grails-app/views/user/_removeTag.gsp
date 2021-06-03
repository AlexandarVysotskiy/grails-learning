<div style="alignment: left">
    <g:form controller="user" action="removeUser">
        <g:hiddenField name="id" value="${user.id}"/>

        <button type="submit" onclick="return confirm('You want to delete user: ${user.login}?')">
            <span>
                Remove user ${user.login}
            </span>
        </button>
    </g:form>
</div>
