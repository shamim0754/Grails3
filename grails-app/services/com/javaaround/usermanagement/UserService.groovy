package com.javaaround.usermanagement

import grails.transaction.Transactional
import com.javaaround.usermanagement.User

@Transactional
class UserService {

    def updateUser(User user) {
    	user.save()
    }
}
