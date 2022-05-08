package br.com.ume.daos.accounts

import br.com.ume.grpc.GrpcClientChannel
import br.com.ume.grpc.proto.accounts.AccountResponse
import br.com.ume.grpc.proto.accounts.AccountsGrpcKt
import br.com.ume.grpc.proto.accounts.getAccountByDocumentRequest
import br.com.ume.grpc.proto.accounts.getAccountByIdRequest

import io.grpc.Status
import io.grpc.StatusException
import java.io.Closeable
import java.util.concurrent.TimeUnit

class AccountsGrpcDao(private val host: String, private val port: Int): AccountsDao, Closeable, GrpcClientChannel(host, port) {
    private val stub: AccountsGrpcKt.AccountsCoroutineStub = AccountsGrpcKt.AccountsCoroutineStub(super.channel)

    private fun adaptAccountResponseToAccountDTO(response: AccountResponse) = AccountDTO(id = response.id.toInt(), name = response.name, document = response.document)

    override suspend fun findAccountById(accountId: Int): AccountDTO? {
        val request = getAccountByIdRequest {
            this.id = accountId.toString()
        }

        try {
            val response = stub.getAccountById(request)
            return this.adaptAccountResponseToAccountDTO(response)
        } catch(exception: StatusException) {
            if(exception.status == Status.NOT_FOUND) {
                return null
            }
            throw exception
        }
    }

    override suspend fun findAccountByDocument(document: String): AccountDTO? {
        val request = getAccountByDocumentRequest {
            this.document = document
        }

        try {
            val response = stub.getAccountByDocument(request)
            return this.adaptAccountResponseToAccountDTO(response)
        } catch(exception: StatusException) {
            if(exception.status == Status.NOT_FOUND) {
                return null
            }
            throw exception
        }

    }

    override fun close() {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS)
    }

}