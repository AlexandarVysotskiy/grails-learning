package showMessage

import org.springframework.web.servlet.support.RequestContextUtils as RCU

class ShowMessageController {

    def index() {
        log.info("RCU.getLocale(request) ${RCU.getLocale(request)}")

        def input = params.digitalInput

        log.info("input ${input}")

        [digit : "input ${RCU.getLocale(request) == 'en' ? input.replaceAll("", ".") : input.replaceAll("", ",")}",
         locale: "${RCU.getLocale(request)}"]
    }
}
