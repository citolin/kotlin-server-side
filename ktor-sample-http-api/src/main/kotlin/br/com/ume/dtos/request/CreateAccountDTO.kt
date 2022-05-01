package br.com.ume.dtos.request
import kotlinx.serialization.Serializable

@Serializable
data class CreateAccountDTO(val name: String,
                            val document: String) {

//    The following method does not work, if we send a request such as:
//    { "name": 3, "document": 4 }
//    the CreateAccountDTO casts the Int as String
//    CreateAccountDTO.name = "3" and CreateAccountDTO.document = "4"
    fun validate() {
        if( !(this.name is String) ) {
            throw Exception("Name must be String")
        }
        if( !(this.document is String) ) {
            throw Exception("Document must be String")
        }
    }
}

