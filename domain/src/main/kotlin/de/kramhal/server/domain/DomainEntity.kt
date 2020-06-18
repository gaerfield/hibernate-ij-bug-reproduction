package de.kramhal.server.domain

import de.kramhal.server.persistence.sql.BaseEntity
import de.kramhal.server.persistence.sql.BaseEntityId
import javax.persistence.Embeddable
import javax.persistence.Entity

@Embeddable
class DomainEntityId(id: String? = null) : BaseEntityId(id)

// here I get a warning:
//    "Persistent entity 'DomainEntity' should have primary key"
@Entity
class DomainEntity (
    val description: String
) : BaseEntity<DomainEntityId>(DomainEntityId())