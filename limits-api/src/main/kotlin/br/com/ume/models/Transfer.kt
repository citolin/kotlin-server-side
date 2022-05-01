package br.com.ume.models

import java.time.Instant

data class Transfer(val id: Int,
                    val timestamp: Instant,
                    val senderAccountId: Int,
                    val receiverAccountId: Int,
                    val transferredValue: Double)
