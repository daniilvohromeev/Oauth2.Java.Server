package com.main.authserver.model

import com.main.authserver.entity.ClientDetail
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.oauth2.provider.ClientDetails

class BasicClientDetails(private val clientDetail: ClientDetail) : ClientDetails {

    override fun getClientId(): String = clientDetail.clientId

    override fun getResourceIds(): MutableSet<String>? {
        clientDetail.resourceIds?.let { return mutableSetOf(it) } ?: run { return null }
    }

    override fun isSecretRequired(): Boolean {
        return clientDetail.isSecretRequired
    }

    override fun getClientSecret(): String {
        return clientDetail.clientSecret
    }

    override fun isScoped(): Boolean {
        return clientDetail.isScoped
    }

    override fun getScope(): MutableSet<String> {
        return clientDetail.scope.split(",").map { it.trim() }.toMutableSet()
    }

    override fun getAuthorizedGrantTypes(): MutableSet<String> {
        return clientDetail.authorizedGrantTypes.split(",").map { it.trim() }.toMutableSet()
    }

    override fun getRegisteredRedirectUri(): MutableSet<String>? {
        clientDetail.registeredRedirectUri?.let { urls ->
            return urls.split(",").map { it.trim() }.toMutableSet()
        } ?: run { return null }
    }

    override fun getAuthorities(): MutableCollection<GrantedAuthority>? {
        clientDetail.authorities?.let { auth ->
            return auth.split(",").map { SimpleGrantedAuthority(it.trim()) }.toMutableList()
        } ?: run { return null }
    }

    override fun getAccessTokenValiditySeconds(): Int? {
        clientDetail.accessTokenValiditySeconds?.let { return it } ?: run { return null }
    }

    override fun getRefreshTokenValiditySeconds(): Int? {
        clientDetail.refreshTokenValiditySeconds?.let { return it } ?: run { return null }
    }

    override fun isAutoApprove(scope: String?): Boolean {
        return clientDetail.isAutoApprove
    }

    override fun getAdditionalInformation(): MutableMap<String, Any>? {
        return null
    }
}