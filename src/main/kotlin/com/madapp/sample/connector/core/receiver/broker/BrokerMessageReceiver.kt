package com.madapp.sample.connector.core.receiver.broker

import com.madapp.sample.connector.core.receiver.MessageReceiver
import com.madapp.sample.connector.fake.broker.MessageBroker

class BrokerMessageReceiver : MessageReceiver() {

    override fun observeRaw(channel: String, block: (String, ((String) -> Unit)?) -> Unit) {
        MessageBroker.observe(channel) { request, response ->
            block(request, response)
        }
    }
}