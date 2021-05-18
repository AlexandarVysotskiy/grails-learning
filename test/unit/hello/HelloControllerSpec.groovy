package hello

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(HelloController)
class HelloControllerSpec extends Specification {

    static doWithSpring = {
        simpleService SimpleService
    }

    void "indexTest"() {
        given:
        controller.request.parameters = ['hello': 'hello']

        when:
        controller.index()

        then:
        controller.response.text == "Hello Grails!"
        controller.response.text != "No Grails"
    }
}
