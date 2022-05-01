package com.example.controllers

import com.example.dtos.response.AccountDTO
import com.example.dtos.request.CreateAccountDTO
import com.example.services.CreateAccountsService
import com.example.services.FindAccountsService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.accountsRouting(findAccountsService: FindAccountsService, createAccountsService: CreateAccountsService) {
    route("/accounts") {
        get("{id?}") {
            val id =
                call.parameters["id"] ?: return@get call.respondText("Missing id", status = HttpStatusCode.BadRequest)

            val account = findAccountsService.findAccountById(id)

            if(account != null) {
                val accountDTO = AccountDTO(id=account.id, name=account.name, document=account.document)
                call.respond(accountDTO)
            } else {
                call.respond(HttpStatusCode.NotFound)
            }
        }
        post {
            val accountToBeCreated = call.receive<CreateAccountDTO>()
            val createdAccount = createAccountsService.createAccount(accountToBeCreated)

            val accountDTO = AccountDTO(id = createdAccount.id, name = createdAccount.name, document = createdAccount.document)
            call.respond(accountDTO)
        }
    }
}