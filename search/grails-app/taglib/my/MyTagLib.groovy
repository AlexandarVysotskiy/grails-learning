package my

class MyTagLib {

    static namespace = "my"

    def remove = { attrs, body ->

        out << render(template: '/user/removeTag', model: [user: attrs.user])
    }
}
