package com.madapp.sample.connector.fake.broker

object MessageBroker {

    private val listeners = mutableMapOf<String, (String) -> Unit>()

    fun observe(queueName: String, block: (String) -> Unit) {
        listeners[queueName] = block
    }

    fun send(queueName: String, message: String) {
        listeners[queueName]?.invoke(message)
    }
}