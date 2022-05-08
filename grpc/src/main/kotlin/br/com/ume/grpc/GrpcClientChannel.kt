package br.com.ume.grpc

import io.grpc.ManagedChannelBuilder

open class GrpcClientChannel(host: String, port: Int) {
    val channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build()
}