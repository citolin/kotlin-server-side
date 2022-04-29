package com.example.services

import com.example.database.Account
import com.example.database.AccountsDAO
import org.postgresql.jdbc.PgResultSet.toInt

interface FindAccountsService {
    fun findAccountById(accountId: String): Account?
}

class FindAccountsServiceImpl(private val accountsDAO: AccountsDAO): FindAccountsService {

    override fun findAccountById(accountId: String): Account? {
        return accountsDAO.findAccountById(toInt(accountId))
    }

}

