package br.com.ume.plugins

import br.com.ume.controllers.accountsRouting
import br.com.ume.services.CreateAccountsService
import br.com.ume.services.FindAccountsService
import io.ktor.server.routing.*
import io.ktor.server.application.*

fun Application.configureRouting(findAccountsService: FindAccountsService, createAccountsService: CreateAccountsService) {
    routing {
        accountsRouting(findAccountsService, createAccountsService)
    }
}
