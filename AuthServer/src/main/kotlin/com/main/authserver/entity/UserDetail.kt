package com.main.authserver.entity

import lombok.Data
import org.hibernate.Hibernate
import javax.persistence.*

@Entity
@Data
data class UserDetail(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long,
        val username: String,
        val password: String,
        val active: Boolean,
        val isExpired: Boolean,
        val isLocked: Boolean,
        val isNotExpired: Boolean,
        @ManyToMany(fetch = FetchType.EAGER)
        val roles: List<Role>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as UserDetail

        return id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , username = $username , password = $password , active = $active , isExpired = $isExpired , isLocked = $isLocked , isNotExpired = $isNotExpired )"
    }
}