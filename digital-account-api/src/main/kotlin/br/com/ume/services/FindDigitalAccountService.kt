package br.com.ume.services

import br.com.ume.daos.accounts.AccountsDao
import br.com.ume.models.DigitalAccount
import br.com.ume.repositories.digital_account.DigitalAccountDao

// TODO(lucas.citolin): Separate interface on another file
interface FindDigitalAccountService {
    suspend fun findDigitalAccountByAccountId(accountId: Int): DigitalAccount?
    suspend fun findDigitalAccountByDocument(document: String): DigitalAccount?
}

class FindDigitalAccountServiceImpl(private val accountsDao: AccountsDao,
                                    private val digitalAccountDao: DigitalAccountDao): FindDigitalAccountService {
    override suspend fun findDigitalAccountByAccountId(accountId: Int): DigitalAccount? {
        return this.digitalAccountDao.findDigitalAccountByAccountId(accountId)
    }

    override suspend fun findDigitalAccountByDocument(document: String): DigitalAccount? {
        val account = this.accountsDao.findAccountByDocument(document) ?: return null
        return this.digitalAccountDao.findDigitalAccountByAccountId(account.id)

    }
}

