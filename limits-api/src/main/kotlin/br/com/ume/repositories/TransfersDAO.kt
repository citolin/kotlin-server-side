package br.com.ume.repositories

import br.com.ume.models.Transfer
import br.com.ume.utils.DateUtils
import org.jetbrains.exposed.sql.transactions.transaction
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset

// TODO(lucas.citolin): Structure repositories package
// TODO(lucas.citolin): Separate interface on another file
interface TransfersDAO {
    fun findTransfersBySenderAccountId(accountId: Int): Transfer?
    fun createTransfer(timestamp: Instant, senderAccountId: Int, receiverAccountId: Int, transferredValue: Double): Transfer
}

class TransfersDatabaseDAO: TransfersDAO {
    override fun findTransfersBySenderAccountId(senderAccountId: Int): Transfer? {
        return transaction {
            return@transaction TransferEntity.find { TransfersSchema.senderAccountId eq senderAccountId }.first()
                .toTransfer()
        }
    }

    override fun createTransfer(timestamp: Instant, senderAccountId: Int, receiverAccountId: Int, transferredValue: Double): Transfer {
        return transaction {
            return@transaction TransferEntity.new {
                this.timestamp = LocalDateTime.ofInstant(timestamp, DateUtils.timezone)
                this.senderAccountId = senderAccountId
                this.receiverAccountId = receiverAccountId
                this.transferredValue = transferredValue
            }.toTransfer()
        }
    }

}
