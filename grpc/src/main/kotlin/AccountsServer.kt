import br.com.ume.grpc.proto.accounts.AccountResponse
import br.com.ume.grpc.proto.accounts.AccountsGrpcKt
import br.com.ume.grpc.proto.accounts.CreateAccountRequest
import br.com.ume.grpc.proto.accounts.GetAccountByIdRequest
import io.grpc.Server
import io.grpc.ServerBuilder


class AccountsServer(private val port: Int) {
    val server: Server = ServerBuilder
        .forPort(port)
        .addService(HelloWorldService())
        .build()

    fun start() {
        server.start()
        println("Server started, listening on $port")
        Runtime.getRuntime().addShutdownHook(
            Thread {
                println("*** shutting down gRPC server since JVM is shutting down")
                this@AccountsServer.stop()
                println("*** server shut down")
            }
        )
    }

    private fun stop() {
        server.shutdown()
    }

    fun blockUntilShutdown() {
        server.awaitTermination()
    }

    internal class HelloWorldService : AccountsGrpcKt.AccountsCoroutineImplBase() {
        override suspend fun getAccountById(request: GetAccountByIdRequest): AccountResponse {
            return AccountResponse.newBuilder().setId(1).setName("Lucas Citolin").setDocument("02730229205").build()
        }

        override suspend fun createAccount(request: CreateAccountRequest): AccountResponse {
            println("Name: ${request.name} document: ${request.document}")

            return AccountResponse.newBuilder().setId(1).setName("Lucas Citolin").setDocument("02730229205").build()
        }
    }
}

fun main() {
    val port = System.getenv("PORT")?.toInt() ?: 50051
    val server = AccountsServer(port)
    server.start()
    server.blockUntilShutdown()
}
