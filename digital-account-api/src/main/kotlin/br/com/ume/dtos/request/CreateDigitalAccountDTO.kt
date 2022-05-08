package br.com.ume.dtos.request
import br.com.ume.dtos.DTOValidator
import br.com.ume.dtos.ValidatorResponse
import kotlinx.serialization.Serializable

@Serializable
data class CreateDigitalAccountDTO(val accountId: Int,
                                   val value: Double): DTOValidator {

    override fun validate(): ValidatorResponse {
       val errors = ArrayList<String>()

       if(value < 0) {
           errors.add("value must be a positive number")
       }

       return if(errors.isEmpty()) ValidatorResponse(false) else ValidatorResponse(true, errors)
   }
}