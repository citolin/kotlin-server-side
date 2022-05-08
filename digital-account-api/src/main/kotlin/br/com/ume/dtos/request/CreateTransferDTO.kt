package br.com.ume.dtos.request
import kotlinx.serialization.Serializable

@Serializable
data class CreateTransferByAccountIdDTO(val senderAccountId: Int,
                                        val receiverAccountId: Int,
                                        val transferValue: Double)
@Serializable
data class CreateTransferByDocumentDTO(val senderDocument: String,
                             val receiverDocument: String,
                             val transferValue: Double)

