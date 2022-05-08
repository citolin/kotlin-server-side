package br.com.ume.services

import br.com.ume.dtos.request.CreateDigitalAccountDTO
import br.com.ume.models.DigitalAccount
import br.com.ume.repositories.digital_account.DigitalAccountDao

// TODO(lucas.citolin): Separate interface on another file
interface CreateDigitalAccountService {
    suspend fun createDigitalAccount(accountToBeCreated: CreateDigitalAccountDTO): DigitalAccount
}

class CreateDigitalAccountServiceImpl(private val digitalAccountDao: DigitalAccountDao): CreateDigitalAccountService {
    override suspend fun createDigitalAccount(accountToBeCreated: CreateDigitalAccountDTO): DigitalAccount {
        return this.digitalAccountDao.createDigitalAccount(accountId = accountToBeCreated.accountId, value = accountToBeCreated.value)
    }
}

