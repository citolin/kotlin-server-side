package br.com.ume.exceptions

enum class AccountsExceptionCodes {
    SENDER_ACCOUNT_NOT_FOUND,
    RECEIVER_ACCOUNT_NOT_FOUND
}

class AccountsException(code: AccountsExceptionCodes): Exception(code.toString())