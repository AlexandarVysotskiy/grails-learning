package eighth

class NewUser {

    static constraints = {
    }

    NewUser(String login, String password, String firstName, String lastName) {
        this.login = login
        this.password = password
        this.firstName = firstName
        this.lastName = lastName
    }
    String login
    String password
    String firstName
    String lastName
}