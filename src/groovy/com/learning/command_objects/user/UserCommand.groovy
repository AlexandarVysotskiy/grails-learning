package com.learning.command_objects.user

import org.springframework.context.i18n.LocaleContextHolder

import java.text.SimpleDateFormat

@grails.validation.Validateable
class UserCommand {

    Date from
    Date to

    UserCommand(String from, String to) {

        if (from && to) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", LocaleContextHolder.getLocale())

            this.from = formatter.parse(from)
            this.to = formatter.parse(to)
        }
    }

    static constraints = {
        from blank: false, nullable: false
        to blank: false, nullable: false, max: new Date()
    }
}
