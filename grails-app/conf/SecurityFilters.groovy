class SecurityFilters {

    def filters = {
        all(controller:'user', action:'index') {
            before = {
                if (!session.user && actionName != "login") {
                    redirect(controller: "login", action: "index")
                    return false
                }
            }

            after = { Map model ->
                log.info('After: ' + model)
            }

            afterView = { Exception e ->
                log.error('afterView error', e)
            }
        }
    }
}
