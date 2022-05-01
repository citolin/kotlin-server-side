package br.com.ume.services

import br.com.ume.daos.accounts.AccountsDAO
import br.com.ume.daos.accounts.AccountsException
import br.com.ume.daos.accounts.AccountsExceptionCodes
import br.com.ume.dtos.request.CreateTransferDTO
import br.com.ume.models.Transfer
import br.com.ume.repositories.TransfersDAO
import br.com.ume.utils.DateUtils

// TODO(lucas.citolin): Separate interface on another file
interface CreateTransferService {
    fun createTransfer(accountToBeCreated: CreateTransferDTO): Transfer
}

class CreateTransferServiceImpl(private val transfersDAO: TransfersDAO, private val accountsDAO: AccountsDAO): CreateTransferService {

    override fun createTransfer(transferToBeCreated: CreateTransferDTO): Transfer {
        this.accountsDAO.findAccountById(transferToBeCreated.senderAccountId)
            ?: throw AccountsException(AccountsExceptionCodes.SENDER_ACCOUNT_NOT_FOUND)

        this.accountsDAO.findAccountById(transferToBeCreated.receiverAccountId)
            ?: throw AccountsException(AccountsExceptionCodes.RECEIVER_ACCOUNT_NOT_FOUND)

        val timestamp = DateUtils.currentTimestamp()

        return transfersDAO.createTransfer(senderAccountId = transferToBeCreated.senderAccountId,
            receiverAccountId = transferToBeCreated.receiverAccountId,
            transferredValue = transferToBeCreated.transferredValue,
            timestamp = timestamp)
    }

}

