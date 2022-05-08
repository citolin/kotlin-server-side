package br.com.ume.dtos.response
import kotlinx.serialization.Serializable

@Serializable
data class TransferDTO(val id: Int,
                       val timestamp: String,
                       val senderAccountId: Int,
                       val receiverAccountId: Int,
                       val transferValue: Double)

@Serializable
data class TransferListDTO(val transfers: List<TransferDTO>)

