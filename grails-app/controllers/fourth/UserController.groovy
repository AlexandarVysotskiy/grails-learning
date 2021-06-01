package fourth

import com.learning.command_objects.user.UserCommand
import grails.gorm.PagedResultList

class UserController {

    FourthService fourthService

    def index(String userName, String pokemonName, UserCommand userCommand) {
        if (userCommand.hasErrors()) {
            return [userCommand: userCommand]
        }

        PagedResultList users = fourthService.findUsersByNameAndPokemons(
                userName,
                pokemonName,
                userCommand.getFrom(),
                userCommand.getTo(),
                params.int('max', 5),
                params.int('offset', 0))

        [userCommand: userCommand, users: users, userCount: users.getTotalCount()]
    }
}
