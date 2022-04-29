package com.example

import com.example.database.AccountsDatabaseDAO
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import com.example.services.CreateAccountsService
import com.example.services.CreateAccountsServiceImpl
import com.example.services.FindAccountsServiceImpl

fun main() {
    // Dependency Injection
    val accountsDao = AccountsDatabaseDAO()
    val findAccountsService = FindAccountsServiceImpl(accountsDao)
    val createAccountsService = CreateAccountsServiceImpl(accountsDao)

    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureRouting(findAccountsService, createAccountsService)
        configureSerialization()
    }.start(wait = true)
}
