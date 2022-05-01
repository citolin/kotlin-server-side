package br.com.ume.repositories

import br.com.ume.models.Account
import org.jetbrains.exposed.sql.transactions.transaction

// TODO(lucas.citolin): Structure repositories package
// TODO(lucas.citolin): Separate interface on another file
interface AccountsDAO {
    fun findAccountById(accountId: Int): Account?
    fun createAccount(name: String, document: String): Account
}

class AccountsDatabaseDAO: AccountsDAO {
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
