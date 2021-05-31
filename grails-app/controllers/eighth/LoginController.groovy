package eighth

class LoginController {

    UserService userService

    def index(String login, String password) {

        if (!login) {
            return render(view: "index", model: [message: "Input login please"])
        }

        if (!password) {
            return render(view: "index", model: [message: "Input password please"])
        }

        def u = userService.findByLogin(login)

        if (u) {
            if (u.password == password) {
                session.user = u
                redirect(controller: "user", action: "index")
            } else {
                render(view: "index", model: [message: "Password incorrect"])
            }
        } else {
            render(view: "index", model: [message: "User not found"])
        }
    }

    def logout() {
        session.user = null
        render(view: "index", model: [message: "User not found"])
    }
}
