import grails.test.AbstractCliTestCase

class ShowMessageTests extends AbstractCliTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testShowMessage() {

        execute(["showMessage-message"])

        assertEquals 0, waitForProcess()
        verifyHeader()
    }
}
