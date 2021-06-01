import eighth.NewUser

class UserDataJob {

    def mailService

    static triggers = {
//        simple repeatInterval: 1D // execute job once in 5 seconds
        simple repeatInterval: 5000l // execute job once in 5 seconds
    }

    def execute() {
        println('Job works!!!')

        sendUserInfo(NewUser.findAll())
    }

    def sendUserInfo(List<NewUser> list) {
        mailService.sendMail {
            to "bestof@list.ru"
            subject "User data"
            body "Right now in the app ${list.size()} users"
        }
    }
}
