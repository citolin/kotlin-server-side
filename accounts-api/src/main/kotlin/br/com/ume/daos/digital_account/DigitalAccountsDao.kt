package br.com.ume.daos.digital_account

interface DigitalAccountsDao {
    suspend fun createDigitalAccount(accountId: Int, value: Double): DigitalAccountDTO?
}

