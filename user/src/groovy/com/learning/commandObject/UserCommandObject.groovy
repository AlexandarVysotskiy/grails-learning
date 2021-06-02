package com.learning.commandObject

@grails.validation.Validateable(nullable = true)
class UserCommandObject {
    String login
    String firstName
    String lastName
}
