package com.javaaround.usermanagement

class Role {
	String roleName
    static constraints = {
    	roleName(blank : false)
    }
}
