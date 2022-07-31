package com.madapp.sample.connector.fake.rest

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*


class RestEmitter {

    private val client = HttpClient()

    suspend fun request(channel: String, content: String): String {
        val response = client.get("http://localhost:8000/request?channel=$channel&content=$content")
        return response.body()
    }
}