package eighth

import grails.orm.PagedResultList

class UserController {

    UserService userService

    def index() {
        userService.initUsers()

        PagedResultList users = userService.getAllUsers(
                params.int('offset', 0),
                params.int('max', 5))

        render(view: 'index', model: [users: users, userTotal: users.totalCount])
    }

    def search(String login, String firstName, String lastName) {
        PagedResultList users = userService.findUsers(login, firstName, lastName,
                params.int('offset', 0),
                params.int('max', 2))

        render(view: 'index', model: [users: users, userTotal: users.totalCount])
    }

    def editUser() {
        render(view: 'addEditNewUser', model: [user: userService.findUserById(params.get("id"))])
    }

    def addNewUser() {
        render(view: 'addEditNewUser')
    }

    def removeUser(String id) {
        userService.removeUser(id)

        redirect(view: 'index')
    }

    def saveNewUser(String login, String firstName, String lastName, String password) {
        userService.saveNewUser(params.get('userId'), login, firstName, lastName, password)

        index()
    }
}
