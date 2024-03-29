package br.com.ume.models

import br.com.ume.dtos.response.TransferDTO
import java.time.Instant

data class Transfer(val id: Int,
                    val timestamp: Instant,
                    val senderAccountId: Int,
                    val receiverAccountId: Int,
                    val transferValue: Double) {

    fun toDto(): TransferDTO = TransferDTO(
        id = this.id,
        senderAccountId = this.senderAccountId,
        receiverAccountId = this.receiverAccountId,
        transferValue = this.transferValue,
        timestamp = this.timestamp.toString())
}
