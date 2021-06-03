import eighth.UserService

class BootStrap {

    UserService userService

    def init = { servletContext ->
        userService.initUsers()
    }

    def destroy = {
    }
}
