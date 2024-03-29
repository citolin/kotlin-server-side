package br.com.ume.repositories

import br.com.ume.models.Transfer
import br.com.ume.repositories.digital_account.DigitalAccountSchema
import br.com.ume.utils.DateUtils
import org.jetbrains.exposed.sql.SqlExpressionBuilder
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.SqlExpressionBuilder.greaterEq
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update
import java.time.Instant
import java.time.LocalDateTime

// TODO(lucas.citolin): Structure repositories package
// TODO(lucas.citolin): Separate interface on another file
interface TransfersDao {
    fun findTransfersBySenderAccountId(accountId: Int): List<Transfer>
    fun createTransfer(timestamp: Instant, senderAccountId: Int, receiverAccountId: Int, transferValue: Double): Transfer
    fun countTransfersSinceTimestamp(senderAccountId: Int, receiverAccountId: Int, transferValue: Double, timestamp: Instant): Long
}

class TransfersDatabaseDao:  TransfersDao {
    override fun findTransfersBySenderAccountId(senderAccountId: Int): List<Transfer> {
        val transferList = transaction {
            return@transaction TransferEntity.find { TransfersSchema.senderAccountId eq senderAccountId }.toList()
        }

        return transferList.map { it.toTransfer() }
    }

    override fun createTransfer(timestamp: Instant, senderAccountId: Int, receiverAccountId: Int, transferValue: Double): Transfer {
        return transaction {
            DigitalAccountSchema.update({ DigitalAccountSchema.accountId eq senderAccountId }) {
                with(SqlExpressionBuilder) {
                    it.update(DigitalAccountSchema.value, DigitalAccountSchema.value - transferValue)
                }
            }

            DigitalAccountSchema.update({ DigitalAccountSchema.accountId eq receiverAccountId }) {
                with(SqlExpressionBuilder) {
                    it.update(DigitalAccountSchema.value, DigitalAccountSchema.value + transferValue)
                }
            }

            return@transaction TransferEntity.new {
                this.timestamp = LocalDateTime.ofInstant(timestamp, DateUtils.timezone)
                this.senderAccountId = senderAccountId
                this.receiverAccountId = receiverAccountId
                this.transferValue = transferValue
            }.toTransfer()
        }
    }

    override fun countTransfersSinceTimestamp(senderAccountId: Int, receiverAccountId: Int, transferValue: Double, timestamp: Instant): Long {
        return transaction {
            return@transaction TransferEntity.find(
                TransfersSchema.transferValue eq transferValue
                        and(TransfersSchema.receiverAccountId eq receiverAccountId)
                        and(TransfersSchema.senderAccountId eq senderAccountId)
                        and(TransfersSchema.timestamp greaterEq LocalDateTime.ofInstant(timestamp, DateUtils.timezone))
            ).count()
        }
    }


}
