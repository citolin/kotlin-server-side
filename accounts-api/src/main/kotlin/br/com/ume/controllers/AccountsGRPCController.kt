package br.com.ume.controllers

import br.com.ume.dtos.request.CreateAccountDTO
import br.com.ume.exceptions.AccountsException
import br.com.ume.exceptions.AccountsExceptionCodes
import br.com.ume.grpc.proto.accounts.*
import br.com.ume.models.Account
import br.com.ume.services.CreateAccountsService
import br.com.ume.services.FindAccountsService
import io.grpc.Status
import io.grpc.StatusException

class AccountsGRPCController(private val findAccountsService: FindAccountsService,
                             private val createAccountsService: CreateAccountsService,
) : AccountsGrpcKt.AccountsCoroutineImplBase() {
    private fun adaptAccountToAccountResponse(account: Account): AccountResponse {
        return AccountResponse.newBuilder().setId(account.id.toLong()).setName(account.name).setDocument(account.document).build()
    }

    override suspend fun getAccountById(request: GetAccountByIdRequest): AccountResponse {
        val account = this.findAccountsService.findAccountById(request.id.toString())
            ?: throw StatusException(Status.NOT_FOUND)

        return this.adaptAccountToAccountResponse(account)
    }

    override suspend fun getAccountByDocument(request: GetAccountByDocumentRequest): AccountResponse {
        val account = this.findAccountsService.findAccountByDocument(request.document)
            ?: throw StatusException(Status.NOT_FOUND)

        return this.adaptAccountToAccountResponse(account)
    }

    override suspend fun createAccount(request: CreateAccountRequest): AccountResponse {
        val accountToBeCreated = CreateAccountDTO(name = request.name, document = request.document, value = request.value)

        val dtoValidation = accountToBeCreated.validate()
        if(dtoValidation.error) throw StatusException(Status.INVALID_ARGUMENT)

        try {
            val createdAccount = this.createAccountsService.createAccount(accountToBeCreated)
            return this.adaptAccountToAccountResponse(createdAccount)
        } catch(exception: AccountsException) {
            if(exception.code == AccountsExceptionCodes.DOCUMENT_UNIQUE_ERROR) {
                throw StatusException(Status.ALREADY_EXISTS)
            }
            throw exception
        }
    }
}
