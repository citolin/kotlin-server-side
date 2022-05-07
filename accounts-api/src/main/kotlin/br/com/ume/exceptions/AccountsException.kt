package br.com.ume.exceptions

enum class AccountsExceptionCodes {
    DOCUMENT_UNIQUE_ERROR
}

class AccountsException(val code: AccountsExceptionCodes): Exception(code.toString())