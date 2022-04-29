package com.example.models
import kotlinx.serialization.Serializable

@Serializable
data class AccountDTO(val id: Int,
                    val name: String,
                    val document: String)
