package br.com.ume

import br.com.ume.daos.accounts.AccountsGrpcDao
import br.com.ume.daos.accounts.AccountsRestDao
import io.ktor.server.application.*
import br.com.ume.plugins.*
import br.com.ume.repositories.DatabaseFactory
import br.com.ume.repositories.TransfersDatabaseDao
import br.com.ume.services.CreateTransferServiceImpl
import io.grpc.ManagedChannelBuilder

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    // Configs
    // TODO(lucas.citolin): Isolate and use separated config loader from framework
    val dbUsername = environment.config.propertyOrNull("ktor.database.username")?.getString() ?: ""
    val dbPassword = environment.config.propertyOrNull("ktor.database.password")?.getString() ?: ""
    val dbHost = environment.config.propertyOrNull("ktor.database.host")?.getString() ?: ""
    val dbDatabase = environment.config.propertyOrNull("ktor.database.database")?.getString() ?: ""

    val shouldAccountsUseGrpc = environment.config.propertyOrNull("ktor.accounts.grpc.enabled")?.getString() ?: ""
    val accountsGrpcHost = environment.config.propertyOrNull("ktor.accounts.grpc.host")?.getString() ?: ""
    val accountsGrpcPort = environment.config.propertyOrNull("ktor.accounts.grpc.port")?.getString() ?: ""
    val accountsRestBaseUrl = environment.config.propertyOrNull("ktor.accounts.rest.baseUrl")?.getString() ?: ""

    // Setup
    val database = DatabaseFactory()
    database.connectAndMigrate(username = dbUsername, password = dbPassword, database = dbDatabase, host = dbHost )
    val grpcChannel = ManagedChannelBuilder.forAddress(accountsGrpcHost, accountsGrpcPort.toInt()).usePlaintext().build()

    // Dependency Injection
    val transfersDao = TransfersDatabaseDao()
    println("Using GRPC? ${shouldAccountsUseGrpc.toBoolean()}")
    val accountsDao = if(shouldAccountsUseGrpc.toBoolean()) AccountsGrpcDao(grpcChannel) else AccountsRestDao(accountsRestBaseUrl)

    val createTransferService = CreateTransferServiceImpl(transfersDao, accountsDao)

    configureRouting(createTransferService)
    configureSerialization()
}
