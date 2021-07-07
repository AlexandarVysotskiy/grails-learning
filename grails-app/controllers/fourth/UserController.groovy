package fourth

import grails.gorm.PagedResultList

class UserController {

    FourthService fourthService

    def index(String userName, String pokemonName) {
        PagedResultList users = fourthService.findUsersByNameAndPokemons(
                userName,
                pokemonName,
                params.int('max', 5),
                params.int('offset', 0))

        [users: users, userCount: users.getTotalCount()]
    }
}
