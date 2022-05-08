package br.com.ume.services

import br.com.ume.models.Account
import br.com.ume.repositories.accounts.AccountsDao
import org.postgresql.jdbc.PgResultSet.toInt

// TODO(lucas.citolin): Separate interface on another file
interface FindAccountsService {
    fun findAccountById(accountId: String): Account?
    fun findAccountByDocument(document: String): Account?
}

class FindAccountsServiceImpl(private val accountsDao: AccountsDao): FindAccountsService {
    override fun findAccountById(accountId: String): Account? {
        return accountsDao.findAccountById(toInt(accountId))
    }

    override fun findAccountByDocument(document: String): Account? {
        return accountsDao.findAccountByDocument(document)
    }

}

