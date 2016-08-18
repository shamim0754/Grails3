package com.javaaround.usermanagement

class User {
	String userId
	String fullName
	String address
    static constraints = {
    	//validation
    	userId (blank: false)
		fullName (blank: false)
		address (blank: false)
    }
}
