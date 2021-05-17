package showMessage

import org.springframework.web.servlet.support.RequestContextUtils as RCU

class ShowMessageController {

    def index() {
        log.info("RCU.getLocale(request) ${RCU.getLocale(request)}")

        def input = params.digitalInput

        if (input) {

            log.info("input ${input}")

            [digit : "input ${RCU.getLocale(request) == 'en' ? input.replaceAll("", ".") : input.replaceAll("", ",")}",
             locale: "${RCU.getLocale(request)}"]
        }
    }

    def changeLanguage() {
        log.info('Change language')

        if (RCU.getLocale(request) == Locale.ENGLISH) {
            session['org.springframework.web.servlet.i18n.SessionLocaleResolver.LOCALE'] = Locale.GERMANY
        } else {
            session['org.springframework.web.servlet.i18n.SessionLocaleResolver.LOCALE'] = Locale.ENGLISH
        }

        redirect(uri: "/showMessage")
    }
}
