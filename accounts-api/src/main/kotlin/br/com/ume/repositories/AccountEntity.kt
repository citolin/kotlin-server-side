package br.com.ume.repositories

import br.com.ume.models.Account
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

const val UNIQUE_ACCOUNTS_DOCUMENT_INDEX_NAME = "unique_accounts_document"

internal object AccountsSchema : IntIdTable("accounts") {
    val name = varchar("name", 50)
    val document = char("document", length = 11 ).uniqueIndex(UNIQUE_ACCOUNTS_DOCUMENT_INDEX_NAME)
    val value = double("value")
}

internal class AccountEntity(id: EntityID<Int>): IntEntity(id) {
    companion object: IntEntityClass<AccountEntity>(AccountsSchema)

    var name by AccountsSchema.name
    var document by AccountsSchema.document
    var value by AccountsSchema.value

    fun toAccount(): Account = Account(id = this.id.value, name = this.name, document = this.document, value = this.value)
}

