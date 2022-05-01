package br.com.ume

import io.ktor.server.application.*
import br.com.ume.plugins.*
import br.com.ume.repositories.DatabaseFactory
import br.com.ume.repositories.TransfersDatabaseDAO
import br.com.ume.services.CreateTransferServiceImpl

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    // Configs
    // TODO(lucas.citolin): Isolate and use separated config loader from framework
    val dbUsername = environment.config.propertyOrNull("ktor.database.username")?.getString() ?: ""
    val dbPassword = environment.config.propertyOrNull("ktor.database.password")?.getString() ?: ""
    val dbHost = environment.config.propertyOrNull("ktor.database.host")?.getString() ?: ""
    val dbDatabase = environment.config.propertyOrNull("ktor.database.database")?.getString() ?: ""

    // Setup
    val database = DatabaseFactory()
    database.connectAndMigrate(username = dbUsername, password = dbPassword, database = dbDatabase, host = dbHost )

    // Dependency Injection
    val transfersDao = TransfersDatabaseDAO()
    val createTransferService = CreateTransferServiceImpl(transfersDao)

    configureRouting(createTransferService)
    configureSerialization()
}
