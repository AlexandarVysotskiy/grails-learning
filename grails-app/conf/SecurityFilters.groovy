class SecurityFilters {

    def filters = {
        all(controller:'*', action:'*', uriExclude: '/login/index') {
            before = {
                if (!session.user) {
                    redirect(controller: "login", action: "index")
                    return false
                }
            }
        }
    }
}
