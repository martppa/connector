package com.madapp.sample.connector.core.receiver.builder

import com.madapp.sample.connector.core.receiver.MessageReceiver
import com.madapp.sample.connector.core.receiver.broker.BrokerMessageReceiver

fun buildReceiver(): MessageReceiver {
    return BrokerMessageReceiver()
}