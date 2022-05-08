package br.com.ume.plugins

import br.com.ume.controllers.transfersRouting
import br.com.ume.services.CreateTransferService
import br.com.ume.services.FindTransfersService
import io.ktor.server.routing.*
import io.ktor.server.application.*

fun Application.configureRouting(createTransferService: CreateTransferService, findTransfersService: FindTransfersService) {
    routing {
        transfersRouting(createTransferService, findTransfersService)
    }
}
