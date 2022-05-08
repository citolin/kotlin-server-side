package br.com.ume.dtos

data class ValidatorResponse(val error: Boolean, val errors: ArrayList<String> = ArrayList<String>())

internal interface DTOValidator {
    fun validate(): ValidatorResponse
}