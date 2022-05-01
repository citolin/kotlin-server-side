package br.com.ume.services

import br.com.ume.dtos.request.CreateTransferDTO
import br.com.ume.models.Transfer
import br.com.ume.repositories.TransfersDAO
import br.com.ume.utils.DateUtils

// TODO(lucas.citolin): Separate interface on another file
interface CreateTransferService {
    fun createTransfer(accountToBeCreated: CreateTransferDTO): Transfer
}

class CreateTransferServiceImpl(private val transfersDAO: TransfersDAO): CreateTransferService {
    override fun createTransfer(transferToBeCreated: CreateTransferDTO): Transfer {
        val timestamp = DateUtils.currentTimestamp()

        return transfersDAO.createTransfer(senderAccountId = transferToBeCreated.senderAccountId,
            receiverAccountId = transferToBeCreated.receiverAccountId,
            transferredValue = transferToBeCreated.transferredValue,
            timestamp = timestamp)
    }

}

