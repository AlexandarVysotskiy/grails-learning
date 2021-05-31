<div style="alignment: left">
    <g:form controller="user" action="removeUser">
        <g:hiddenField name="id" value="${user.id}"/>

        <button type="submit" onclick="if (!confirm('You want to delete user: ${user.login}?')) {
          return false
        }">
            <span>Remove user ${user.login}</span>
        </button>
    </g:form>
</div>
