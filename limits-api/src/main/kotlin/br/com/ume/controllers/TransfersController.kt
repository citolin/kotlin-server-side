package br.com.ume.controllers

import br.com.ume.daos.accounts.AccountsException
import br.com.ume.dtos.response.TransferDTO
import br.com.ume.dtos.request.CreateTransferDTO
import br.com.ume.services.CreateTransferService
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

// TODO(lucas.citolin): Implement `orDie` methods and handle exceptions on middleware
// TODO(lucas.citolin): Implement middleware validator for incoming DTOs
fun Route.transfersRouting(createTransferService: CreateTransferService) {
    route("/transfers") {
        post {
            val transferToBeCreated = call.receive<CreateTransferDTO>()

            try {
                val createdTransfer = createTransferService.createTransfer(transferToBeCreated)
                call.respond(createdTransfer.toDto())
            } catch(accountsException: AccountsException) {
                // TODO: Respond a JSON error
                call.respond(accountsException.message.toString())
            }
        }
    }
}