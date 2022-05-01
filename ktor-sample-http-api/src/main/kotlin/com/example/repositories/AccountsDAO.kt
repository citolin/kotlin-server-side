package com.example.models

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

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
            SchemaUtils.create(AccountsSchema)
        }
    }

    override fun findAccountById(accountId: Int): Account? {
        return transaction {
            return@transaction AccountEntity.findById(accountId)?.toAccount()
        }
    }

    override fun createAccount(name: String, document: String): Account {
        return transaction {
            return@transaction AccountEntity.new {
                this.name = name
                this.document = document
            }.toAccount()
        }
    }
}
