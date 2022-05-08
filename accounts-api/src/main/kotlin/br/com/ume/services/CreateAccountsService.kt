package br.com.ume.services

import br.com.ume.daos.digital_account.DigitalAccountsDao
import br.com.ume.models.Account
import br.com.ume.dtos.request.CreateAccountDTO
import br.com.ume.repositories.accounts.AccountsDao

// TODO(lucas.citolin): Separate interface on another file
interface CreateAccountsService {
    suspend fun createAccount(accountToBeCreated: CreateAccountDTO): Account
}

class CreateAccountsServiceImpl(private val accountsDao: AccountsDao, private val digitalAccountsDao: DigitalAccountsDao): CreateAccountsService {
    override suspend fun createAccount(accountToBeCreated: CreateAccountDTO): Account {
        val createdAccount = accountsDao.createAccount(name = accountToBeCreated.name, document = accountToBeCreated.document, value = accountToBeCreated.value)
        // TODO(lucas.citolin): Create digital account assync using debezium
        this.digitalAccountsDao.createDigitalAccount(accountId = createdAccount.id, value = accountToBeCreated.value)
        return createdAccount
    }

}

