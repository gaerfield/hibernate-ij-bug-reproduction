package de.kramhal.server.persistence.sql

import org.hibernate.annotations.GenericGenerator
import java.io.Serializable
import java.util.*
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.MappedSuperclass
import javax.persistence.Version

@MappedSuperclass
open class BaseEntityId(
    givenId: String? = null
) : Serializable {
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    val id: String = givenId ?: UUID.randomUUID().toString()

    override fun equals(other: Any?) = when {
        null == other -> false
        this === other -> true
        javaClass != other.javaClass -> false
        id != (other as BaseEntityId).id -> false
        else -> true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    override fun toString(): String {
        return "${this::class.simpleName}=[$id]"
    }
}

@MappedSuperclass
abstract class BaseEntity<T : Serializable>(
    @Id
    val id: T,
    @Version
    val version: Long? = null
) {
    override fun equals(other: Any?) = when {
        this === other -> true
        javaClass != other?.javaClass -> false
        else -> id.equals((other as BaseEntity<*>).id)
    }

    override fun hashCode(): Int = id.hashCode()
}