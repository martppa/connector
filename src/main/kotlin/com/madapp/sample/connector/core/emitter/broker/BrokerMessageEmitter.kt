package com.madapp.sample.connector.core.emitter.broker

import com.madapp.sample.connector.core.emitter.MessageEmitter
import com.madapp.sample.connector.fake.broker.MessageBroker
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class BrokerMessageEmitter : MessageEmitter() {

    override suspend fun request(channel: String, body: String): String {
        println("Broker: Requesting $body")
        return suspendCoroutine { continuation ->
            MessageBroker.send(channel, body) {
                continuation.resume(it)
            }
        }
    }

    override suspend fun send(channel: String, body: String) {
        return suspendCoroutine { continuation ->
            MessageBroker.send(channel, body)
            continuation.resume(Unit)
        }
    }
}