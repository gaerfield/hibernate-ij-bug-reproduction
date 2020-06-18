package de.kramhal.server.service

import de.kramhal.server.domain.DomainEntity
import de.kramhal.server.domain.DomainEntityId
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.web.bind.annotation.*

interface DomainEntityRepository : JpaRepository<DomainEntity, DomainEntityId>

@RestController
@RequestMapping("/domain-entity")
class DomainEntityController(
    val repo: DomainEntityRepository
) {

    @GetMapping
    fun get() : List<DomainEntity> = repo.findAll()

    data class CreateDomainEntity(val description: String)
    @PostMapping
    fun create(@RequestBody create: CreateDomainEntity) : DomainEntity
            = repo.save(DomainEntity(create.description))
}