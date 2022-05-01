package br.com.ume.controllers

import br.com.ume.dtos.response.AccountDTO
import br.com.ume.dtos.request.CreateAccountDTO
import br.com.ume.services.CreateAccountsService
import br.com.ume.services.FindAccountsService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

// TODO(lucas.citolin): Implement `orDie` methods and handle exceptions on middleware
// TODO(lucas.citolin): Implement middleware validator for incoming DTOs
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