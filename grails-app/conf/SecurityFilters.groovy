class SecurityFilters {

    def filters = {
        all(controller:'user', action:'index') {
            before = {
                if (!session.user && actionName != "login") {
                    redirect(controller: "login", action: "index")
                    return false
                }
            }
//            after = { Map model ->
//
//            }
//            afterView = { Exception e ->
//
//            }
        }
    }
}
