package br.com.ume.repositories

import br.com.ume.models.Transfer
import br.com.ume.utils.DateUtils
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.javatime.datetime
import java.time.ZoneOffset

// TODO(lucas.citolin): don't use double for financial values
internal object TransfersSchema : IntIdTable("transfers") {
    val timestamp = datetime("timestamp")

    val senderAccountId = integer("sender_account_id")
    val receiverAccountId = integer("receiver_account_id")

    val transferValue = double("transfer_value")
}

internal class TransferEntity(id: EntityID<Int>): IntEntity(id) {
    companion object: IntEntityClass<TransferEntity>(TransfersSchema)

    var timestamp by TransfersSchema.timestamp
    var senderAccountId by TransfersSchema.senderAccountId
    var receiverAccountId by TransfersSchema.receiverAccountId
    var transferValue by TransfersSchema.transferValue

    fun toTransfer(): Transfer = Transfer(id = this.id.value,
        timestamp = this.timestamp.toInstant(DateUtils.timezone),
        senderAccountId = this.senderAccountId,
        receiverAccountId = this.receiverAccountId,
        transferValue =  this.transferValue)
}

