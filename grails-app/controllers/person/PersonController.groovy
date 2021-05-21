package person

class PersonController {

    static scaffold = Person

    def show() {
        def person = Person.get(params.id)

        log.info(person)

        [personInstance : person]
    }

    def edit() {
        def person = Person.get(params.id)

        person.setName(person.name + ' edit')

        log.info(person)

        [personInstance : person]
    }
}
