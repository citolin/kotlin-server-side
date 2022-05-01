package br.com.ume.daos.accounts

enum class AccountsExceptionCodes {
    SENDER_ACCOUNT_NOT_FOUND,
    RECEIVER_ACCOUNT_NOT_FOUND
}

class AccountsException(code: AccountsExceptionCodes): Exception(code.toString())