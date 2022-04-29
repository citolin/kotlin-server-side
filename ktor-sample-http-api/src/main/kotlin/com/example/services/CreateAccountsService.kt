package com.example.services

import com.example.database.Account
import com.example.database.AccountsDAO
import com.example.models.CreateAccountDTO

interface CreateAccountsService {
    fun createAccount(accountToBeCreated: CreateAccountDTO): Account
}

class CreateAccountsServiceImpl(private val accountsDAO: AccountsDAO): CreateAccountsService {

    override fun createAccount(accountToBeCreated: CreateAccountDTO): Account {
        return accountsDAO.createAccount(name = accountToBeCreated.name, document = accountToBeCreated.document)
    }

}

