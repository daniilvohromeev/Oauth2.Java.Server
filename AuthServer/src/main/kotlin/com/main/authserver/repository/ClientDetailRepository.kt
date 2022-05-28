package com.main.authserver.repository

import com.main.authserver.entity.ClientDetail
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ClientDetailRepository : JpaRepository<ClientDetail, Long> {
    fun findByClientId(clientId: String): Optional<ClientDetail>
}