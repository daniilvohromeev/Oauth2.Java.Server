package com.main.authserver.service

import com.main.authserver.model.BasicClientDetails
import com.main.authserver.repository.ClientDetailRepository
import org.springframework.security.oauth2.provider.ClientDetails
import org.springframework.security.oauth2.provider.ClientDetailsService
import org.springframework.stereotype.Service

@Service
class BasicClientDetailsService(
        private val clientDetailRepository: ClientDetailRepository
) : ClientDetailsService {

    override fun loadClientByClientId(clientId: String): ClientDetails {
        val clientDetail = clientDetailRepository.findByClientId(clientId).get()
        return BasicClientDetails(clientDetail)
    }
}