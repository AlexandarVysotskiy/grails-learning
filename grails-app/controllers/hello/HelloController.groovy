package hello

/**
 * My first controller
 * @author: AVysotskiy
 */
class HelloController {

    SimpleService simpleService
    def myFirstBean

    def index() {
        log.info("index() was got params: ${params}")

        if (params.hello && simpleService.isHello(params.hello)) {
            render "Hello Grails!"
        } else {
            render "Hello $params.hello ${myFirstBean.prefix}"
        }
    }
}