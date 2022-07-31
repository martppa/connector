package com.madapp.sample.connector.core.emitter.rest

import com.madapp.sample.connector.core.emitter.MessageEmitter
import com.madapp.sample.connector.fake.broker.MessageBroker
import com.madapp.sample.connector.fake.rest.RestEmitter
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class RestMessageEmitter : MessageEmitter() {

    private val emitter = RestEmitter()

    override suspend fun request(channel: String, body: String): String {
        println("Rest: Requesting $body")
        return emitter.request(channel, body)
    }

    override suspend fun send(channel: String, body: String) {
        emitter.request(channel, body)
    }
}