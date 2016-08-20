package com.javaaround.usermanagement

class User {
	String userId
	String fullName
	String address
    static constraints = {
    	//validation key:value
    	//size chara between 2 and 5,it can't blank and unique
    	userId size:2..5 , blank: false , unique: true 
		fullName blank: false)
		address blank: false
    }
}
