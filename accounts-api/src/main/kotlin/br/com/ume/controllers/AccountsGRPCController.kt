package br.com.ume.controllers

import accounts.AccountResponse
import accounts.AccountsGrpcKt
import accounts.CreateAccountRequest
import accounts.GetAccountByIdRequest

import br.com.ume.dtos.request.CreateAccountDTO
import br.com.ume.services.CreateAccountsService
import br.com.ume.services.FindAccountsService
import io.grpc.Status
import io.grpc.StatusException

class AccountsGRPCController(private val findAccountsService: FindAccountsService, private val createAccountsService: CreateAccountsService) : AccountsGrpcKt.AccountsCoroutineImplBase() {
    override suspend fun getAccountById(request: GetAccountByIdRequest): AccountResponse {
        val account = this.findAccountsService.findAccountById(request.id.toString())
            ?: throw StatusException(Status.NOT_FOUND)

        return AccountResponse.newBuilder().setId(account.id.toLong()).setName(account.name).setDocument(account.document).build()
    }

    override suspend fun createAccount(request: CreateAccountRequest): AccountResponse {
        val accountToBeCreated = CreateAccountDTO(name = request.name.toString(), document = request.document.toString())

        val dtoValidation = accountToBeCreated.validate()
        if(dtoValidation.error) throw StatusException(Status.INVALID_ARGUMENT)

        val createdAccount = this.createAccountsService.createAccount(accountToBeCreated)

        return AccountResponse.newBuilder().setId(createdAccount.id.toLong()).setName(createdAccount.name).setDocument(createdAccount.document).build()
    }
}
