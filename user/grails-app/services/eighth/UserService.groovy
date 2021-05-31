package eighth

import grails.orm.PagedResultList
import grails.transaction.Transactional
import org.grails.datastore.mapping.query.api.BuildableCriteria

@Transactional
class UserService {

    NewUser findByLogin(String login) {
        NewUser.findByLogin(login)
    }

    void removeUser(String userId) {
        NewUser.findById(userId as Long).delete()
    }

    NewUser findUserById(String userId) {
        NewUser.findById(userId as Long)
    }

    PagedResultList getAllUsers(int offset, int max) {
        BuildableCriteria bc = NewUser.createCriteria()
        bc.list(offset: offset, max: max) {}
    }

    PagedResultList findUsers(String login, String firstName, String lastName,
                              int offset, int max) {
        BuildableCriteria bc = NewUser.createCriteria()
        bc.list(offset: offset, max: max) {
            if (login) {
                like('login', login + "%")
            }

            if (firstName) {
                like('firstName', firstName + "%")
            }

            if (lastName) {
                like('lastName', lastName + "%")
            }
        }
    }

    def saveNewUser(String id, String login, String firstName, String lastName, String password) {
        if (!id) {
            new NewUser(login, firstName, lastName, password).save()
        } else {
            NewUser newUser = NewUser.findById(id as Long)

            if (login) {
                newUser.login = login
            }

            if (firstName) {
                newUser.firstName = firstName
            }

            if (lastName) {
                newUser.lastName = lastName
            }

            if (password) {
                newUser.password = password
            }

            newUser.save()
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