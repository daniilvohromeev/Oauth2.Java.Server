package com.main.authserver.controller

import org.springframework.hateoas.EntityModel
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@RestController
@RequestMapping("/api")
class UserController {

    @GetMapping("/users/current")
    fun getUserName(user: Principal): EntityModel<Principal> {
        return EntityModel.of(user)
    }
}