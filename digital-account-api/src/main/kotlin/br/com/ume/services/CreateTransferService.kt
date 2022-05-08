package br.com.ume.services

import br.com.ume.dtos.request.CreateTransferByAccountIdDTO
import br.com.ume.dtos.request.CreateTransferByDocumentDTO
import br.com.ume.exceptions.AccountsException
import br.com.ume.exceptions.AccountsExceptionCodes
import br.com.ume.exceptions.TransfersException
import br.com.ume.exceptions.TransfersExceptionCodes
import br.com.ume.models.DigitalAccount
import br.com.ume.models.Transfer
import br.com.ume.repositories.TransfersDao
import br.com.ume.utils.DateUtils

// TODO(lucas.citolin): Separate interface on another file
interface CreateTransferService {
    suspend fun createTransfer(transferToBeCreated: CreateTransferByDocumentDTO): Transfer
    suspend fun createTransfer(transferToBeCreated: CreateTransferByAccountIdDTO): Transfer
}

const val TRANSFER_DUPLICATED_PERIOD_IN_SECONDS = 60L

class CreateTransferServiceImpl(private val transfersDao: TransfersDao, private val findDigitalAccountService: FindDigitalAccountService): CreateTransferService {
    private fun checkIfAccountHasEnoughValue(account: DigitalAccount, transferValue: Double): Boolean {
        return account.value >= transferValue
    }

    private fun transfer(senderAccount: DigitalAccount, receiverAccount: DigitalAccount, transferValue: Double): Transfer {
        if(!this.checkIfAccountHasEnoughValue(senderAccount, transferValue)) {
            throw TransfersException(TransfersExceptionCodes.INSUFFICIENT_VALUE_IN_ACCOUNT)
        }

        val timestamp = DateUtils.currentTimestamp()

        // TODO(lucas.citolin): Separate the duplicate check in a use case
        val duplicatedPeriod = timestamp.minusSeconds(TRANSFER_DUPLICATED_PERIOD_IN_SECONDS)
        if(this.transfersDao.countTransfersSinceTimestamp(senderAccountId = senderAccount.accountId,
                receiverAccountId = receiverAccount.accountId,
                transferValue = transferValue,
                timestamp = duplicatedPeriod) > 0) {
            throw TransfersException(TransfersExceptionCodes.DUPLICATED_TRANSFER)
        }

        return transfersDao.createTransfer(senderAccountId = senderAccount.accountId,
            receiverAccountId = receiverAccount.accountId,
            transferValue = transferValue,
            timestamp = timestamp)
    }

    override suspend fun createTransfer(transferToBeCreated: CreateTransferByAccountIdDTO): Transfer {
        val senderAccount = this.findDigitalAccountService.findDigitalAccountByAccountId(transferToBeCreated.senderAccountId)
            ?: throw AccountsException(AccountsExceptionCodes.SENDER_ACCOUNT_NOT_FOUND)

        val receiverAccount = this.findDigitalAccountService.findDigitalAccountByAccountId(transferToBeCreated.receiverAccountId)
            ?: throw AccountsException(AccountsExceptionCodes.RECEIVER_ACCOUNT_NOT_FOUND)

        return this.transfer(senderAccount = senderAccount, receiverAccount = receiverAccount, transferValue = transferToBeCreated.transferValue)
    }
    override suspend fun createTransfer(transferToBeCreated: CreateTransferByDocumentDTO): Transfer {
        val senderAccount = this.findDigitalAccountService.findDigitalAccountByDocument(transferToBeCreated.senderDocument)
            ?: throw AccountsException(AccountsExceptionCodes.SENDER_ACCOUNT_NOT_FOUND)

        val receiverAccount = this.findDigitalAccountService.findDigitalAccountByDocument(transferToBeCreated.receiverDocument)
            ?: throw AccountsException(AccountsExceptionCodes.RECEIVER_ACCOUNT_NOT_FOUND)

        return this.transfer(senderAccount = senderAccount, receiverAccount = receiverAccount, transferValue = transferToBeCreated.transferValue)
    }
}

