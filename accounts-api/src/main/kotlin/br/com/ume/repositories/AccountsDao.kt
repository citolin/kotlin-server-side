package br.com.ume.repositories

import br.com.ume.exceptions.AccountsException
import br.com.ume.exceptions.AccountsExceptionCodes
import br.com.ume.models.Account
import br.com.ume.utils.EXPOSED_ORM_UNIQUE_ERROR_CODE
import org.jetbrains.exposed.exceptions.ExposedSQLException
import org.jetbrains.exposed.sql.transactions.transaction

// TODO(lucas.citolin): Structure repositories package
// TODO(lucas.citolin): Separate interface on another file
interface AccountsDao {
    fun findAccountById(accountId: Int): Account?
    fun createAccount(name: String, document: String, value: Double): Account
}

class AccountsDatabaseDao: AccountsDao {
    override fun findAccountById(accountId: Int): Account? {
        return transaction {
            return@transaction AccountEntity.findById(accountId)?.toAccount()
        }
    }

    override fun createAccount(name: String, document: String, value: Double): Account {
        try {
            val createdAccount = transaction {
                return@transaction AccountEntity.new {
                    this.name = name
                    this.document = document
                    this.value = value
                }.toAccount()
            }
            return createdAccount
        } catch(exception: ExposedSQLException) {
            // This strategy "loses" the ID due to auto increment transaction error
            if(exception.sqlState.toInt() == EXPOSED_ORM_UNIQUE_ERROR_CODE) {
                throw AccountsException(AccountsExceptionCodes.DOCUMENT_UNIQUE_ERROR)
            }
            throw exception
        }
    }
}
