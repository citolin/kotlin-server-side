package br.com.ume.controllers

import br.com.ume.dtos.request.CreateTransferByAccountIdDTO
import br.com.ume.dtos.request.CreateTransferByDocumentDTO
import br.com.ume.dtos.response.TransferListDTO
import br.com.ume.exceptions.AccountsException
import br.com.ume.exceptions.TransfersException
import br.com.ume.services.CreateTransferService
import br.com.ume.services.FindTransfersService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

// TODO(lucas.citolin): Implement `orDie` methods and handle exceptions on middleware
// TODO(lucas.citolin): Implement middleware validator for incoming DTOs
fun Route.transfersRouting(createTransferService: CreateTransferService, findTransfersService: FindTransfersService) {
    route("/transfers") {
        post {
            val transferToBeCreated = call.receive<CreateTransferByAccountIdDTO>()

            try {
                val createdTransfer = createTransferService.createTransfer(transferToBeCreated)
                call.respond(createdTransfer.toDto())
            } catch(exception: AccountsException) {
                // TODO: Respond a JSON error
                call.respond(HttpStatusCode.NotFound, exception.message.toString())
            } catch(exception: TransfersException) {
                call.respond(HttpStatusCode.Conflict, exception.message.toString())
            }
        }
        post("/by-document"){
            val transferToBeCreated = call.receive<CreateTransferByDocumentDTO>()

            try {
                val createdTransfer = createTransferService.createTransfer(transferToBeCreated)
                call.respond(createdTransfer.toDto())
            } catch(exception: AccountsException) {
                // TODO: Respond a JSON error
                call.respond(HttpStatusCode.NotFound, exception.message.toString())
            } catch(exception: TransfersException) {
                call.respond(HttpStatusCode.Conflict, exception.message.toString())
            }
        }
        get(){
            // TODO(lucas.citolin): Make this route more generic
            val senderAccountId = call.request.queryParameters["senderAccountId"] ?: throw BadRequestException("senderAccountId is required")

            try {
                val transfers = findTransfersService.findTransfersBySenderAccountId(senderAccountId.toInt())
                call.respond(TransferListDTO( transfers.map { it.toDto() } ))
            } catch(exception: AccountsException) {
                // TODO: Respond a JSON error
                call.respond(HttpStatusCode.NotFound, exception.message.toString())
            } catch(exception: TransfersException) {
                call.respond(HttpStatusCode.Conflict, exception.message.toString())
            }
        }


    }
}