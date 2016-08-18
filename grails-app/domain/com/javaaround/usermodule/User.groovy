package com.javaaround.usermodule

class User {
	String id
	String name
	String address
    static constraints = {
    	//not allow empty value
    	name nullable: false
        address nullable: false
    }
}
