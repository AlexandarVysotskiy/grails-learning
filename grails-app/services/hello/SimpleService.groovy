package hello

class SimpleService {

    boolean isHello(String hello) {
        if (hello && hello.equalsIgnoreCase('Hello')) {
            return true
        }

        return false
    }
}
