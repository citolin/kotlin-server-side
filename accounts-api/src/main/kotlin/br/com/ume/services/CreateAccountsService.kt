package br.com.ume.services

import br.com.ume.models.Account
import br.com.ume.dtos.request.CreateAccountDTO
import br.com.ume.repositories.AccountsDao

// TODO(lucas.citolin): Separate interface on another file
interface CreateAccountsService {
    fun createAccount(accountToBeCreated: CreateAccountDTO): Account
}

class CreateAccountsServiceImpl(private val accountsDAO: AccountsDao): CreateAccountsService {
    override fun createAccount(accountToBeCreated: CreateAccountDTO): Account {
        return accountsDAO.createAccount(name = accountToBeCreated.name, document = accountToBeCreated.document, value = accountToBeCreated.value)
    }

}

