package com.main.authserver.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import lombok.Data
import org.hibernate.Hibernate
import org.springframework.security.core.GrantedAuthority
import javax.persistence.*

@Entity
@Data
data class Role(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long,
        @Enumerated(EnumType.STRING)
        val role: RoleType
) : GrantedAuthority {
    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
    var usersDetail: List<UserDetail>? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Role

        return id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , role = $role )"
    }

    override fun getAuthority(): String {
        return role.toString()
    }
}