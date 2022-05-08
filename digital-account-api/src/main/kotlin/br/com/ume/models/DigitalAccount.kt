package br.com.ume.models

import java.time.Instant

data class DigitalAccount(val id: Int,
                          val createdAt: Instant,
                          val accountId: Int,
                          val value: Double)
