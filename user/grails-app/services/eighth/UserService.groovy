package eighth

import com.learning.commandObject.UserCommandObject
import grails.orm.PagedResultList
import grails.transaction.Transactional
import org.grails.datastore.mapping.query.api.BuildableCriteria

@Transactional
class UserService {

    NewUser findByLogin(String login) {
        NewUser.findByLogin(login)
    }

    void removeUser(NewUser user) {
        user.delete()
    }

    NewUser findUserById(String userId) {
        NewUser.get(userId as Long)
    }

    PagedResultList findUsers(UserCommandObject commandObject,
                              int offset, int max) {
        BuildableCriteria bc = NewUser.createCriteria()
        bc.list(offset: offset, max: max) {
            if (commandObject.login) {
                like('login', commandObject.login + "%")
            }

            if (commandObject.firstName) {
                like('firstName', commandObject.firstName + "%")
            }

            if (commandObject.lastName) {
                like('lastName', commandObject.lastName + "%")
            }
        }
    }

    def saveEditUser(NewUser user) {
        if (!user.id) {
            user.save()
        } else {
            NewUser changeUser = NewUser.get(user.id)

            changeUser.login = user.login
            changeUser.firstName = user.firstName
            changeUser.lastName = user.lastName
            changeUser.password = user.password

            changeUser.save()
        }
    }

    void initUsers() {
        if (NewUser.count == 0) {
            new NewUser('Nick123', '123', 'Nick', 'Cage').save()
            new NewUser('NickolaT123', '123', 'Nickola', 'Tesla').save()
            new NewUser('Tom445', '123', 'Tom', 'Edison').save()
            new NewUser('Bill123', '123', 'Bill', 'Gates').save()
            new NewUser('Elon563', '123', 'Elon', 'Musk').save()
            new NewUser('Jeff543', '123', 'Jeff', 'Bezos').save()
            new NewUser('Serj', '123', 'Sergey', 'Brin').save()
        }
    }
}