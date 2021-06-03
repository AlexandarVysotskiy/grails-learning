import eighth.NewUser

class UserDataJob {

    def mailService

    static triggers = {
//        simple repeatInterval: 1D // execute job once in 5 seconds
        simple repeatInterval: 5000l // execute job once in 5 seconds
    }

    def execute() {
        int userCount = NewUser.count()

        log.info('User count right now ' + userCount)

        sendUserInfo(userCount)
    }

    def sendUserInfo(int userCount) {
//        mailService.sendMail {
//            to "bestof@list.ru"
//            subject "User data"
//            body "Right now in the app ${userCount} users"
//        }
    }
}
