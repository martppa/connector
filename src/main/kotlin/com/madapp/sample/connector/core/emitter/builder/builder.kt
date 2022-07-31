package com.madapp.sample.connector.core.emitter.builder

import com.madapp.sample.connector.core.emitter.MessageEmitter
import com.madapp.sample.connector.core.emitter.broker.BrokerMessageEmitter

fun buildEmitter(): MessageEmitter {
    return BrokerMessageEmitter()
}