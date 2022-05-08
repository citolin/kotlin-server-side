package br.com.ume

import br.com.ume.controllers.DigitalAccountGRPCController
import br.com.ume.daos.accounts.AccountsGrpcDao
import br.com.ume.daos.accounts.AccountsRestDao
import br.com.ume.grpc.GRPCServerFactory
import io.ktor.server.application.*
import br.com.ume.plugins.*
import br.com.ume.repositories.DatabaseFactory
import br.com.ume.repositories.TransfersDatabaseDao
import br.com.ume.repositories.digital_account.DigitalAccountDatabaseDao
import br.com.ume.services.CreateDigitalAccountServiceImpl
import br.com.ume.services.CreateTransferServiceImpl
import br.com.ume.services.FindDigitalAccountServiceImpl
import br.com.ume.services.FindTransfersServiceImpl
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

    val grpcServerPort = environment.config.propertyOrNull("ktor.grpcServer.port")?.getString() ?: ""

    // Setup
    val database = DatabaseFactory()
    database.connectAndMigrate(username = dbUsername, password = dbPassword, database = dbDatabase, host = dbHost )

    // Dependency Injection
    val transfersDao = TransfersDatabaseDao()
    val accountsDao = if(shouldAccountsUseGrpc.toBoolean()) AccountsGrpcDao(accountsGrpcHost, accountsGrpcPort.toInt()) else AccountsRestDao(accountsRestBaseUrl)
    val digitalAccountDao = DigitalAccountDatabaseDao()
    // -- Use Cases
    val findDigitalAccountService = FindDigitalAccountServiceImpl(accountsDao, digitalAccountDao)
    val createTransferService = CreateTransferServiceImpl(transfersDao, findDigitalAccountService)
    val createDigitalAccountService = CreateDigitalAccountServiceImpl(digitalAccountDao)
    val findTransfersService = FindTransfersServiceImpl(transfersDao)

    // -- Controllers
    val digitalAccountGRPCController = DigitalAccountGRPCController(createDigitalAccountService)

    configureRouting(createTransferService, findTransfersService)
    configureSerialization()

    // Start gRPC server
    val server = GRPCServerFactory(grpcServerPort.toInt(), digitalAccountGRPCController)
    server.start()
}
