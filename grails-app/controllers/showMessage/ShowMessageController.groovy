package showMessage

import org.springframework.web.servlet.support.RequestContextUtils as RCU
import third.Message

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols

class ShowMessageController {

    Message message

    def index() {
        message = new Message("First")

        [message: message]
    }

    def inputDigit(Message message) {
        if (message.digit) {

            log.info('message.digit ' + message.digit)

            DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols()

            if (RCU.getLocale(request) == Locale.ENGLISH) {
                decimalFormatSymbols.setDecimalSeparator('.' as char)
                message.setText(new DecimalFormat("##0.000", decimalFormatSymbols)
                        .format(message.getDigit()))
            } else {
                decimalFormatSymbols.setDecimalSeparator(',' as char)
                message.setText(new DecimalFormat("##0,000", decimalFormatSymbols)
                        .format(message.getDigit()))
            }
        }

        render(view: "index", model: [message: message])
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
