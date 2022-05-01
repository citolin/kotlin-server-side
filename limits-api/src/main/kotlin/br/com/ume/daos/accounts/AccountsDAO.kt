package br.com.ume.daos.accounts

import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import com.google.gson.*

interface AccountsDAO {
    fun findAccountById(accountId: Int): AccountDTO?
}

class AccountsApiDAO(private val baseUrl: String): AccountsDAO {
    private val gson: Gson = Gson()

    override fun findAccountById(accountId: Int): AccountDTO? {
        val client = HttpClient.newBuilder().build();
        val request = HttpRequest.newBuilder()
            .uri(URI.create("${baseUrl}/accounts/${accountId}"))
            .build();

        return try {
            val response = client.send(request, HttpResponse.BodyHandlers.ofString());
            gson.fromJson(response.body(), AccountDTO::class.java)
        } catch (exception: Exception) {
            null
        }
    }

}