package io.grpc.examples.helloworld

import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import tutorial.GreeterGrpcKt
import tutorial.helloRequest
import java.io.Closeable
import java.util.concurrent.TimeUnit

class HelloWorldClient(private val channel: ManagedChannel) : Closeable {
    private val stub: GreeterGrpcKt.GreeterCoroutineStub = GreeterGrpcKt.GreeterCoroutineStub(channel)

    suspend fun greet(name: String) {
        val request = helloRequest { this.name = name }
        val response = stub.sayHello(request)
        println("Received: ${response.message}")
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
    val port = 5005

    val channel = ManagedChannelBuilder.forAddress("localhost", port).usePlaintext().build()

    val client = HelloWorldClient(channel)

    val user = args.singleOrNull() ?: "world"
    client.greet(user)
}