package br.com.ume.services

import br.com.ume.models.Transfer
import br.com.ume.repositories.TransfersDao

interface FindTransfersService {
    fun findTransfersBySenderAccountId(senderAccountId: Int): List<Transfer>
}

class FindTransfersServiceImpl(private val transfersDao: TransfersDao): FindTransfersService {
    override fun findTransfersBySenderAccountId(senderAccountId: Int): List<Transfer> {
        return this.transfersDao.findTransfersBySenderAccountId(senderAccountId)
    }
}