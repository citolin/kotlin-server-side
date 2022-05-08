package br.com.ume.daos.digital_account

import br.com.ume.grpc.GrpcClientChannel
import br.com.ume.grpc.proto.digital_account.DigitalAccountGrpcKt
import br.com.ume.grpc.proto.accounts.getAccountByIdRequest
import br.com.ume.grpc.proto.digital_account.createDigitalAccountRequest

import io.grpc.ManagedChannel
import java.io.Closeable
import java.util.concurrent.TimeUnit

class DigitalAccountsGrpcDao(private val host: String, private val port: Int): DigitalAccountsDao, Closeable, GrpcClientChannel(host, port) {
    private val stub: DigitalAccountGrpcKt.DigitalAccountCoroutineStub = DigitalAccountGrpcKt.DigitalAccountCoroutineStub(super.channel)

    override suspend fun createDigitalAccount(accountId: Int, value: Double): DigitalAccountDTO? {
        val request = createDigitalAccountRequest {
            this.accountId = accountId.toLong()
            this.value = value
        }

        val response = stub.createDigitalAccount(request)
        return DigitalAccountDTO(id = response.id.toInt(), accountId = response.accountId.toInt(), value = response.value )
    }

    override fun close() {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS)
    }

}