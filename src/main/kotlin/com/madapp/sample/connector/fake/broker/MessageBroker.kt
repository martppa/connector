package com.madapp.sample.connector.fake.broker

object MessageBroker {

    private val listeners = mutableMapOf<String, (String, response: (((String) -> Unit)?)) -> Unit>()

    fun observe(queueName: String, block: (String, response: (((String) -> Unit)?)) -> Unit) {
        listeners[queueName] = block
    }

    fun send(queueName: String, message: String, response: ((String) -> Unit)? = null) {
        listeners[queueName]?.invoke(message, response)
    }
}