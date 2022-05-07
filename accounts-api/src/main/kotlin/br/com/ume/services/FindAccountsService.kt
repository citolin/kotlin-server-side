package br.com.ume.services

import br.com.ume.models.Account
import br.com.ume.repositories.AccountsDao
import org.postgresql.jdbc.PgResultSet.toInt

// TODO(lucas.citolin): Separate interface on another file
interface FindAccountsService {
    fun findAccountById(accountId: String): Account?
}

class FindAccountsServiceImpl(private val accountsDAO: AccountsDao): FindAccountsService {

    override fun findAccountById(accountId: String): Account? {
        return accountsDAO.findAccountById(toInt(accountId))
    }

}

