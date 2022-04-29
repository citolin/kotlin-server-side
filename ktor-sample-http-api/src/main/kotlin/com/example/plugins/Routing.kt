package com.example.plugins

import com.example.database.AccountsDAO
import com.example.routes.accountsRouting
import com.example.routes.customerRouting
import com.example.services.CreateAccountsService
import com.example.services.FindAccountsService
import io.ktor.server.routing.*
import io.ktor.server.application.*

fun Application.configureRouting(findAccountsService: FindAccountsService, createAccountsService: CreateAccountsService) {
    routing {
        accountsRouting(findAccountsService, createAccountsService)
        customerRouting()
    }
}
