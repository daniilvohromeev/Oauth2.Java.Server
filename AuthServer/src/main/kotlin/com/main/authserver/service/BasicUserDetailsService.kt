package com.main.authserver.service

import com.main.authserver.model.BasicUserDetails
import com.main.authserver.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class BasicUserDetailsService(val userRepository: UserRepository) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        val userDetail = userRepository.findByUsername(username).get()
        return BasicUserDetails(userDetail)
    }
}