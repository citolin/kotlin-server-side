package com.example.database

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

object Accounts : IntIdTable() {
    val name = varchar("name", 50)
    val document = char("document", length = 11)
}

class Account(id: EntityID<Int>): IntEntity(id) {
    companion object: IntEntityClass<Account>(Accounts)

    var name by Accounts.name
    var document by Accounts.document
}

interface AccountsDAO {
    fun findAccountById(accountId: Int): Account?
    fun createAccount(name: String, document: String): Account
}

class AccountsDatabaseDAO: AccountsDAO {
    constructor() {
        Database.connect(url ="jdbc:postgresql://localhost:5432/datastoredev",
            driver="org.postgresql.Driver",
            user = "dev",
            password = "ZCE7PjK36nK5SZRc")

        transaction {
            SchemaUtils.create(Accounts)
        }
    }

    override fun findAccountById(accountId: Int): Account? {
        return transaction {
            return@transaction Account.findById(accountId)
        }
    }

    override fun createAccount(name: String, document: String): Account {
        println(name)
        println(document)
        return transaction {
            return@transaction Account.new {
                this.name = name
                this.document = document
            }
        }
    }
}
