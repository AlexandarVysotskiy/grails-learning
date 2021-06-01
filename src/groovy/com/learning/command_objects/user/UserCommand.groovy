package com.learning.command_objects.user

import org.grails.databinding.BindingFormat

@grails.validation.Validateable(nullable = true)
class UserCommand {

    @BindingFormat('yyyy-MM-dd')
    Date from

    @BindingFormat('yyyy-MM-dd')
    Date to

    static constraints = {
        from validator: { from, uc ->
            if (from && from.after(uc.to)) {
                ['Incorecte date', 'Date From must be after To date']
            }
        }

        to validator: { to ->
            if (to && to.after(new Date())) {
                ['Incorecte date', 'Date cannot be from future']
            }
        }
    }
}
