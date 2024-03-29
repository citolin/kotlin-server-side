import br.com.ume.grpc.proto.accounts.AccountsGrpcKt
import br.com.ume.grpc.proto.accounts.createAccountRequest
import br.com.ume.grpc.proto.accounts.getAccountByIdRequest
import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import java.io.Closeable
import java.util.concurrent.TimeUnit

class AccountsClient(private val channel: ManagedChannel) : Closeable {
    private val stub: AccountsGrpcKt.AccountsCoroutineStub = AccountsGrpcKt.AccountsCoroutineStub(channel)

    suspend fun createAccount(name: String, document: String, value: Double) {
        val request = createAccountRequest {
            this.name = name
            this.document = document
            this.value = value
        }
        val response = stub.createAccount(request)
        println("Received Name: ${response.name} Received document: ${response.document}")
    }

    suspend fun getAccountById(id: String) {
        val request = getAccountByIdRequest {
            this.id = id
        }
        val response = stub.getAccountById(request)
        println("Id: ${response.id} Received Name: ${response.name} Received document: ${response.document}")
    }

    override fun close() {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS)
    }
}

/**
 * Greeter, uses first argument as name to greet if present;
 * greets "world" otherwise.
 */
suspend fun main(args: Array<String>) {
    val port = 5052

    val channel = ManagedChannelBuilder.forAddress("localhost", port).usePlaintext().build()

    val client = AccountsClient(channel)

    val user = args.singleOrNull() ?: "1"
    client.getAccountById("1")
    client.createAccount(name = "lu", document = "11111111112", value = 100.1)
}