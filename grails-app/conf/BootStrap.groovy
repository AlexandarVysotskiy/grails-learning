class BootStrap {

    def init = { servletContext ->
        new GroovyScriptEngine("scripts")
                .loadScriptByName("MyScript.groovy")
                .showMessage()
    }
    def destroy = {

    }
}
