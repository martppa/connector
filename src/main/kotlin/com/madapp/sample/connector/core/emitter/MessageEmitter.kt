package com.madapp.sample.connector.core.emitter

import com.google.gson.Gson

abstract class MessageEmitter {
    suspend fun <R, P> request(payload: Payload<P>, classOf: Class<R>): R {
        val body = Gson().toJson(payload.body)
        val result = request(payload.channel, body)
        return Gson().fromJson(result, classOf)
    }

    suspend fun <P> send(payload: Payload<P>) = send(payload.channel, Gson().toJson(payload.body))

    protected abstract suspend fun request(channel: String, body: String): String
    protected abstract suspend fun send(channel: String, body: String)
}
suspend inline fun <reified R, P> MessageEmitter.request(payload: Payload<P>): R {
    return request(payload, R::class.java)
}