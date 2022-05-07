package br.com.ume.services

import br.com.ume.daos.accounts.AccountDTO
import br.com.ume.daos.accounts.AccountsDao
import br.com.ume.exceptions.AccountsException
import br.com.ume.exceptions.AccountsExceptionCodes
import br.com.ume.dtos.request.CreateTransferDTO
import br.com.ume.exceptions.TransfersException
import br.com.ume.exceptions.TransfersExceptionCodes
import br.com.ume.models.Transfer
import br.com.ume.repositories.TransfersDao
import br.com.ume.utils.DateUtils

// TODO(lucas.citolin): Separate interface on another file
interface CreateTransferService {
    suspend fun createTransfer(accountToBeCreated: CreateTransferDTO): Transfer
}

const val TRANSFER_DUPLICATED_PERIOD_IN_SECONDS = 30L

class CreateTransferServiceImpl(private val transfersDao: TransfersDao, private val accountsDAO: AccountsDao): CreateTransferService {
    private fun checkIfAccountHasEnoughValue(account: AccountDTO, transferValue: Double): Boolean {
        return account.value < transferValue
    }

    override suspend fun createTransfer(transferToBeCreated: CreateTransferDTO): Transfer {
        val senderAccount = this.accountsDAO.findAccountById(transferToBeCreated.senderAccountId)
            ?: throw AccountsException(AccountsExceptionCodes.SENDER_ACCOUNT_NOT_FOUND)

        this.accountsDAO.findAccountById(transferToBeCreated.receiverAccountId)
            ?: throw AccountsException(AccountsExceptionCodes.RECEIVER_ACCOUNT_NOT_FOUND)

        if(!this.checkIfAccountHasEnoughValue(senderAccount, transferToBeCreated.transferValue)) {
            throw TransfersException(TransfersExceptionCodes.INSUFFICIENT_VALUE_IN_ACCOUNT)
        }

        val timestamp = DateUtils.currentTimestamp()

        val duplicatedPeriod = timestamp.minusSeconds(TRANSFER_DUPLICATED_PERIOD_IN_SECONDS)
        if(this.transfersDao.countTransfersSinceTimestamp(senderAccountId = transferToBeCreated.senderAccountId,
                receiverAccountId = transferToBeCreated.receiverAccountId,
                transferValue = transferToBeCreated.transferValue,
                timestamp = duplicatedPeriod) > 0) {
            throw TransfersException(TransfersExceptionCodes.DUPLICATED_TRANSFER)
        }

        return transfersDao.createTransfer(senderAccountId = transferToBeCreated.senderAccountId,
            receiverAccountId = transferToBeCreated.receiverAccountId,
            transferValue = transferToBeCreated.transferValue,
            timestamp = timestamp)
    }

}

