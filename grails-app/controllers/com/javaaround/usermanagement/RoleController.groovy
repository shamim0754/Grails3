package com.javaaround.usermanagement

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class RoleController {
    static scaffold = Role 
}
