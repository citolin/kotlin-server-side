package br.com.ume.repositories.digital_account

import br.com.ume.models.DigitalAccount
import br.com.ume.utils.DateUtils
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.javatime.datetime

// TODO(lucas.citolin): don't use double for financial values
internal object DigitalAccountSchema : IntIdTable("digital_account") {
    val createdAt = datetime("created_at")
    val accountId = integer("account_id")
    val value = double("value")
}

internal class DigitalAccountEntity(id: EntityID<Int>): IntEntity(id) {
    companion object: IntEntityClass<DigitalAccountEntity>(DigitalAccountSchema)

    var createdAt by DigitalAccountSchema.createdAt
    var accountId by DigitalAccountSchema.accountId
    var value by DigitalAccountSchema.value

    fun toDigitalAccount(): DigitalAccount = DigitalAccount(id = this.id.value, createdAt =  this.createdAt.toInstant(DateUtils.timezone), accountId =  this.accountId, value = this.value)
}

