package br.com.ume.daos.accounts

interface AccountsDao {
    suspend fun findAccountById(accountId: Int): AccountDTO?
    suspend fun findAccountByDocument(document: String): AccountDTO?
}

