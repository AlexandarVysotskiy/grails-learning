package eighth

import com.learning.commandObject.UserCommandObject
import grails.orm.PagedResultList

class UserController {

    UserService userService

    def index() {
        render(view: 'index')
    }

    def search(UserCommandObject commandObject) {
        PagedResultList users = userService.findUsers(commandObject,
                params.int('offset', 0),
                params.int('max', 5))

        render(view: 'index', model: [users: users, userTotal: users.totalCount])
    }

    def editUser() {
        render(view: 'addEditUserView', model: [user: userService.findUserById(params.get("id"))])
    }

    def addNewUser() {
        render(view: 'addEditUserView')
    }

    def removeUser(NewUser user) {
        userService.removeUser(user)

        redirect(action: 'index')
    }

    def saveNewUser(NewUser user) {
        userService.saveEditUser(user)

        redirect(action: 'index')
    }
}
