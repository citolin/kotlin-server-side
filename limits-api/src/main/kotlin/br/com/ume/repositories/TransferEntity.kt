package br.com.ume.repositories

import br.com.ume.models.Transfer
import br.com.ume.utils.DateUtils
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.javatime.datetime
import java.time.ZoneOffset

internal object TransfersSchema : IntIdTable() {
    val timestamp = datetime("timestamp")

    val senderAccountId = integer("sender_account_id")
    val receiverAccountId = integer("receiver_account_id")

    val transferredValue = double("transferred_value")
}

internal class TransferEntity(id: EntityID<Int>): IntEntity(id) {
    companion object: IntEntityClass<TransferEntity>(TransfersSchema)

    var timestamp by TransfersSchema.timestamp
    var senderAccountId by TransfersSchema.senderAccountId
    var receiverAccountId by TransfersSchema.receiverAccountId
    var transferredValue by TransfersSchema.transferredValue

    fun toTransfer(): Transfer = Transfer(id = this.id.value,
        timestamp = this.timestamp.toInstant(DateUtils.timezone),
        senderAccountId = this.senderAccountId,
        receiverAccountId = this.receiverAccountId,
        transferredValue =  this.transferredValue)
}

