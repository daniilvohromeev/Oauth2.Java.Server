package com.main.authserver.repository

import com.main.authserver.entity.UserDetail
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepository : JpaRepository<UserDetail, Long> {
    fun findByUsername(username: String): Optional<UserDetail>
}