package br.com.ume.exceptions

enum class TransfersExceptionCodes {
    INSUFFICIENT_VALUE_IN_ACCOUNT,
    DUPLICATED_TRANSFER
}

class TransfersException(code: TransfersExceptionCodes): Exception(code.toString())