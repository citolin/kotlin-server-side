package br.com.ume.controllers

import br.com.ume.dtos.request.CreateDigitalAccountDTO
import br.com.ume.grpc.proto.digital_account.CreateDigitalAccountRequest
import br.com.ume.grpc.proto.digital_account.DigitalAccountGrpcKt
import br.com.ume.grpc.proto.digital_account.DigitalAccountResponse
import br.com.ume.services.CreateDigitalAccountService
import io.grpc.Status
import io.grpc.StatusException

class DigitalAccountGRPCController(private val createDigitalAccountService: CreateDigitalAccountService): DigitalAccountGrpcKt.DigitalAccountCoroutineImplBase() {
    override suspend fun createDigitalAccount(request: CreateDigitalAccountRequest): DigitalAccountResponse {
        val accountToBeCreated = CreateDigitalAccountDTO(accountId = request.accountId.toInt(), value = request.value)

        val dtoValidation = accountToBeCreated.validate()
        if(dtoValidation.error) throw StatusException(Status.INVALID_ARGUMENT)

        val createdAccount = this.createDigitalAccountService.createDigitalAccount(accountToBeCreated)
        return DigitalAccountResponse
            .newBuilder()
            .setAccountId(createdAccount.accountId.toLong())
            .setId(createdAccount.id.toLong())
            .setValue(createdAccount.value)
            .build()
    }
}
