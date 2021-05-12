package hello

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
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
