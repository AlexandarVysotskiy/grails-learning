package fourth

import com.learning.command_objects.user.UserCommand
import grails.gorm.PagedResultList
import org.codehaus.groovy.grails.web.servlet.mvc.GrailsParameterMap

class UserController {

    FourthService fourthService

    PagedResultList searchUsers(String userName, String pokemonName,
                                String from, String to, GrailsParameterMap params, UserCommand userCommand) {
        fourthService.findUsersByNameAndPokemons(
                userName,
                pokemonName,
                userCommand.getFrom(),
                userCommand.getTo(),
                params.int('max', 2),
                params.int('offset', 0))
    }

    def index(String userName, String pokemonName, String from, String to) {
        UserCommand userCommand = new UserCommand(from, to)

//        fourthService.checkInputDate(userCommand)

//        if (userCommand.hasErrors()) {
//            return [userCommand: userCommand]
//        }

        PagedResultList users = searchUsers(userName, pokemonName, from, to, params, userCommand)

        render(view: "index", model: [users: users, userCount: users.getTotalCount()])
    }


    def search(String userName, String pokemonName, String from, String to) {
        UserCommand userCommand = new UserCommand(from, to)

//        fourthService.checkInputDate(userCommand)

//        if (userCommand.hasErrors()) {
//            return [userCommand: userCommand]
//        }

        PagedResultList users = searchUsers(userName, pokemonName, from, to, params, userCommand)

        render template: "usersTemplate", model: [users: users, userCount: users.getTotalCount()]
    }
}
