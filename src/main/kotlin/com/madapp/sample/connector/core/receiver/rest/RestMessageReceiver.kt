package com.madapp.sample.connector.core.receiver.rest

import com.madapp.sample.connector.core.receiver.MessageReceiver
import com.madapp.sample.connector.fake.broker.MessageBroker
import com.madapp.sample.connector.fake.rest.RestController

class RestMessageReceiver : MessageReceiver() {

    private val receiver = RestController()

    override fun observeRaw(channel: String, block: (String, ((String) -> Unit)?) -> Unit) {
        receiver.observe(channel) { request, response ->
            block(request, response)
        }
    }
}