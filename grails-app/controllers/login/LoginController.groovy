package login

import fourth.FourthService

class LoginController {

    FourthService fourthService

    def index(String login, String password) {
        fourthService.initUsersAndPokemons()

        if (!login || !password) {
            return render(view: "index", model: [message: "Incorrect login or password"])
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
