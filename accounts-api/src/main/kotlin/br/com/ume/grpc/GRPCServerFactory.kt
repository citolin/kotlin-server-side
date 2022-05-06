package br.com.ume.grpc

import io.grpc.BindableService
import io.grpc.Server
import io.grpc.ServerBuilder

open class GRPCServerFactory {
    private var server: Server
    private var port: Int

    constructor(port: Int, vararg grpcService: BindableService) {
        this.port = port

        val server = ServerBuilder
            .forPort(port)

        for(item in grpcService) {
            server.addService(item)
        }

        this.server = server.build()
    }

    fun start() {
        server.start()
        println("Server started, listening on $port")
        Runtime.getRuntime().addShutdownHook(
            Thread {
                println("*** shutting down gRPC server since JVM is shutting down")
                this@GRPCServerFactory.stop()
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
}