includeTargets << grailsScript("_GrailsInit")

target(showMessage: "The description of the script goes here!") {
    ant.println('This is second task')
}

setDefaultTarget(showMessage)
