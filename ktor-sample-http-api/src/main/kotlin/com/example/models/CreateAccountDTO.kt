package com.example.models
import kotlinx.serialization.Serializable

@Serializable
data class CreateAccountDTO(val name: String,
                            val document: String)
