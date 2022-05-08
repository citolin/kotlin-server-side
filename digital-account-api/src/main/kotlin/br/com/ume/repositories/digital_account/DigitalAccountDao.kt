package br.com.ume.repositories.digital_account

import br.com.ume.models.DigitalAccount
import br.com.ume.utils.DateUtils
import org.jetbrains.exposed.sql.transactions.transaction
import java.time.LocalDateTime

// TODO(lucas.citolin): Structure repositories package
// TODO(lucas.citolin): Separate interface on another file
interface DigitalAccountDao {
    fun createDigitalAccount(accountId: Int, value: Double): DigitalAccount
    fun findDigitalAccountByAccountId(accountId: Int): DigitalAccount
}

class DigitalAccountDatabaseDao: DigitalAccountDao {
    override fun createDigitalAccount(accountId: Int, value: Double): DigitalAccount {
        return transaction {
            return@transaction DigitalAccountEntity.new {
                this.createdAt = LocalDateTime.ofInstant(DateUtils.currentTimestamp(), DateUtils.timezone)
                this.accountId = accountId
                this.value = value
            }.toDigitalAccount()
        }
    }

    override fun findDigitalAccountByAccountId(accountId: Int): DigitalAccount {
        return transaction {
            return@transaction DigitalAccountEntity.find { DigitalAccountSchema.accountId eq accountId }.first().toDigitalAccount()
        }

    }


}
