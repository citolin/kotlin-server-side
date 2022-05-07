package br.com.ume.daos.accounts

import br.com.ume.grpc.proto.accounts.AccountsGrpcKt
import br.com.ume.grpc.proto.accounts.getAccountByIdRequest

import io.grpc.ManagedChannel
import java.io.Closeable
import java.util.concurrent.TimeUnit

class AccountsGrpcDao(private val channel: ManagedChannel): AccountsDao, Closeable {
    private val stub: AccountsGrpcKt.AccountsCoroutineStub = AccountsGrpcKt.AccountsCoroutineStub(channel)

    override suspend fun findAccountById(accountId: Int): AccountDTO? {
        val request = getAccountByIdRequest {
            this.id = accountId.toString()
        }

        val response = stub.getAccountById(request)
        return AccountDTO(id = response.id.toInt(), name = response.name.toString(), document = response.document.toString())
    }

    override fun close() {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS)
    }

}