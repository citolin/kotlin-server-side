package br.com.ume

import br.com.ume.grpc.GRPCServerFactory
import br.com.ume.controllers.AccountsGRPCController
import br.com.ume.plugins.configureRouting
import br.com.ume.plugins.configureSerialization
import br.com.ume.repositories.AccountsDatabaseDao
import io.ktor.server.netty.*
import br.com.ume.repositories.DatabaseFactory
import br.com.ume.services.CreateAccountsServiceImpl
import br.com.ume.services.FindAccountsServiceImpl
import io.ktor.server.application.*

fun main(args: Array<String>): Unit = EngineMain.main(args)

fun Application.module() {
    // TODO(lucas.citolin): Isolate and use separated config loader from framework
    val dbUsername = environment.config.propertyOrNull("ktor.database.username")?.getString() ?: ""
    val dbPassword = environment.config.propertyOrNull("ktor.database.password")?.getString() ?: ""
    val dbHost = environment.config.propertyOrNull("ktor.database.host")?.getString() ?: ""
    val dbDatabase = environment.config.propertyOrNull("ktor.database.database")?.getString() ?: ""

    val grpcServerPort = environment.config.propertyOrNull("ktor.grpcServer.port")?.getString() ?: ""

    // Setup
    val database = DatabaseFactory()
    database.connectAndMigrate(username = dbUsername, password = dbPassword, database = dbDatabase, host = dbHost )

    // Dependency Injection
    val accountsDao = AccountsDatabaseDao()
    // -- Use Cases
    val findAccountsService = FindAccountsServiceImpl(accountsDao)
    val createAccountsService = CreateAccountsServiceImpl(accountsDao)
    // -- GRPC Controller
    val accountsGRPCController = AccountsGRPCController(findAccountsService, createAccountsService)

    configureRouting(findAccountsService, createAccountsService)
    configureSerialization()

    // Start gRPC server
    val server = GRPCServerFactory(grpcServerPort.toInt(), accountsGRPCController)
    server.start()
}