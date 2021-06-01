package login

import fourth.FourthService

class LoginController {

    FourthService fourthService

    def index(String login, String password) {
        fourthService.initUsersAndPokemons()

        if (!login) {
            render(view: "index", model: [message: "Input login please"])
        }

        if (!password) {
            render(view: "index", model: [message: "Input password please"])
        }

        def u = fourthService.findUserByName(login)

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
