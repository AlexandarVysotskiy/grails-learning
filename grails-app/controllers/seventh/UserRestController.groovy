package seventh

import com.learning.command_objects.user.UserCommand
import fourth.FourthService
import grails.converters.JSON
import grails.gorm.PagedResultList
import grails.rest.RestfulController
import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.servlet.mvc.GrailsParameterMap

@Transactional(readOnly = true)
class UserRestController extends RestfulController {

    FourthService fourthService

    PagedResultList searchUsers(String userName, String pokemonName, GrailsParameterMap params,
                                UserCommand userCommand) {
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

        header('Content-Range', '13123')

//        fourthService.checkInputDate(userCommand)

//        if (userCommand.hasErrors()) {
//            return [userCommand: userCommand]
//        }

        PagedResultList users = searchUsers(userName, pokemonName, params, userCommand)

        render(view: "index", model: [users: users, userCount: users.getTotalCount()])
    }


    def search(String userName, String pokemonName, int max, int offset) {
        UserCommand userCommand = new UserCommand('', '')
//        fourthService.checkInputDate(userCommand)
//        if (userCommand.hasErrors()) {
//            return [userCommand: userCommand]
//        }

        params.int('max', max)
        params.int('offset', offset)

        PagedResultList users = searchUsers(userName, pokemonName, params, userCommand)

        response.setHeader('Content-Range', "users ${offset}-${max}/${users.totalCount}")

        render users as JSON
    }
}
