package br.com.ume.repositories

import br.com.ume.repositories.accounts.AccountsSchema
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

// TODO(lucas.citolin): Generalize class to accept other DBMS, e.g. Oracle, Cassandra, Memory..
class DatabaseFactory {
    fun connect(host: String, port: Int = 5432, username: String, password: String, database: String) {
        val url = "jdbc:postgresql://${host}:${port}/${database}"

        Database.connect(url = url,
            driver="org.postgresql.Driver",
            user = username,
            password = password,
            )
    }

    fun connectAndMigrate(host: String, port: Int = 5432, username: String, password: String, database: String) {
        this.connect(host,port,username,password,database)
        this.synchronizeSchema()
    }

    //  TODO(lucas.citolin): Use migrations instead of in-memory synch database schema
    private fun synchronizeSchema() {
        transaction {
            SchemaUtils.create(AccountsSchema)
        }
    }
}