package br.com.ume.dtos.request
import br.com.ume.dtos.DTOValidator
import br.com.ume.dtos.ValidatorResponse
import br.com.ume.utils.DOCUMENT_LENGTH
import kotlinx.serialization.Serializable

@Serializable
data class CreateAccountDTO(val name: String,
                            val document: String): DTOValidator {

    override fun validate(): ValidatorResponse {
        val errors = ArrayList<String>()

        if(document.length != DOCUMENT_LENGTH) {
            errors.add("document must have length $DOCUMENT_LENGTH")
        }

        return if(errors.isEmpty()) ValidatorResponse(false) else ValidatorResponse(true, errors)
    }

//    TODO(lucas.citolin): check if there is a "strict" configuration in @Serializable library
//    The following method does not work, if we send a request such as:
//    { "name": 3, "document": 4 }
//    the CreateAccountDTO casts the Int as String
//    CreateAccountDTO.name = "3" and CreateAccountDTO.document = "4"
    private fun validateX() {
        if( !(this.name is String) ) {
            throw Exception("Name must be String")
        }
        if( !(this.document is String) ) {
            throw Exception("Document must be String")
        }
    }
}

