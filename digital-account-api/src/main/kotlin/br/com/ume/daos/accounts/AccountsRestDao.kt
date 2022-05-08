package br.com.ume.daos.accounts

import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class AccountsRestDao(private val baseUrl: String): AccountsDao {
    private val gson: Gson = Gson()

    override suspend fun findAccountById(accountId: Int): AccountDTO? {
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

    override suspend fun findAccountByDocument(document: String): AccountDTO? {
        val client = HttpClient.newBuilder().build();
        val request = HttpRequest.newBuilder()
            .uri(URI.create("${baseUrl}/accounts/${document}"))
            .build();

        return try {
            val response = client.send(request, HttpResponse.BodyHandlers.ofString());
            gson.fromJson(response.body(), AccountDTO::class.java)
        } catch (exception: Exception) {
            null
        }
    }

}