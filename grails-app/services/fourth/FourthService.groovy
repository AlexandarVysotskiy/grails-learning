package fourth

import com.learning.command_objects.user.UserCommand
import grails.gorm.PagedResultList
import grails.transaction.Transactional
import org.grails.datastore.mapping.query.api.BuildableCriteria

@Transactional
class FourthService {

    User findUserByName(String name) {
        if (name) {
            return User.findByName(name)
        }

        return null
    }

    PagedResultList findUsersByNameAndPokemons(String userName, String pokemonName,
                                               Date fromDate, Date toDate,
                                               int max, int offset) {
        BuildableCriteria bc = User.createCriteria()
        bc.list(max: max, offset: offset) {
            if (userName) {
                like('name', userName.endsWith('*')
                        ? userName.replace(userName[userName.length() - 1], '%')
                        : userName)
            }

            between("birthday", fromDate, toDate)

            if (pokemonName) {
                pokemons {
                    like('name', pokemonName.endsWith('*')
                            ? pokemonName.replace(pokemonName[pokemonName.length() - 1], '%')
                            : pokemonName)
                }
            }
        }
    }

    void initUsersAndPokemons() {
        if (User.count == 0) {
            User nick = new User('Nick', '123', new Date())
            User nickolas = new User('Nickolas', '123', new Date().plus(6000))
            User natalia = new User('Natalia', '123', new Date().plus(7000))
            User mike = new User('Mike', '123', new Date().minus(1000))
            User masha = new User('Masha', '123', new Date().minus(2000))
            User alena = new User('Alena', '123', new Date().minus(5000))
            User peter = new User('Peter', '123', new Date().minus(5500))
            User olya = new User('Olya', '123', new Date().minus(6500))
            User elena = new User('Elena', '123', new Date().minus(65000))
            User maria = new User('Maria', '123', new Date().minus(5700))
            User vitalya = new User('Vitalya', '123', new Date().minus(6600))
            User andrew = new User('Andrew', '123', new Date().minus(2300))
            User garic = new User('Garic', '123', new Date().minus(123100))
            User pavel = new User('Pavel', '123', new Date().minus(2400))

            Pokemon first = new Pokemon('First')
            Pokemon second = new Pokemon('Second')
            Pokemon third = new Pokemon('Third')
            Pokemon fourth = new Pokemon('Fourth')
            Pokemon fifth = new Pokemon('Fifth')

            addPokemonToUser(nick, first)
            addPokemonToUser(nickolas, fourth)
            addPokemonToUser(natalia, first)
            addPokemonToUser(mike, second)
            addPokemonToUser(masha, third)
            addPokemonToUser(alena, fourth)
            addPokemonToUser(alena, first)
            addPokemonToUser(nick, second)
            addPokemonToUser(alena, third)
            addPokemonToUser(mike, third)
            addPokemonToUser(peter, first)
            addPokemonToUser(olya, second)
            addPokemonToUser(elena, third)
            addPokemonToUser(vitalya, fourth)
            addPokemonToUser(maria, third)
            addPokemonToUser(andrew, fifth)
            addPokemonToUser(garic, first)
            addPokemonToUser(pavel, second)
        }
    }

    void addPokemonToUser(User user, Pokemon pokemon) {
        user.addToPokemons(pokemon).save()
    }
}
