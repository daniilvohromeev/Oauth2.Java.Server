package com.main.authserver.entity

import lombok.Data
import org.hibernate.Hibernate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
@Data
data class ClientDetail(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long,
        val clientId: String,
        val resourceIds: String? = null,
        val isSecretRequired: Boolean,
        val clientSecret: String,
        val isScoped: Boolean,
        val scope: String,
        val isAutoApprove: Boolean,
        val authorizedGrantTypes: String,
        val registeredRedirectUri: String? = null,
        val authorities: String? = null,
        val accessTokenValiditySeconds: Int? = null,
        val refreshTokenValiditySeconds: Int? = null,
        val additionalInformation: String? = null
) {
        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
                other as ClientDetail

                return id == other.id
        }

        override fun hashCode(): Int = javaClass.hashCode()

        @Override
        override fun toString(): String {
                return this::class.simpleName + "(id = $id , clientId = $clientId , resourceIds = $resourceIds , isSecretRequired = $isSecretRequired , clientSecret = $clientSecret , isScoped = $isScoped , scope = $scope , isAutoApprove = $isAutoApprove , authorizedGrantTypes = $authorizedGrantTypes , registeredRedirectUri = $registeredRedirectUri , authorities = $authorities , accessTokenValiditySeconds = $accessTokenValiditySeconds , refreshTokenValiditySeconds = $refreshTokenValiditySeconds , additionalInformation = $additionalInformation )"
        }
}