package br.com.ume.dtos.request
import kotlinx.serialization.Serializable

@Serializable
data class CreateTransferDTO(val senderAccountId: Int,
                             val receiverAccountId: Int,
                             val transferredValue: Double)

