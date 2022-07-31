package com.madapp.sample.connector.fake.rest

import com.madapp.sample.connector.fake.broker.MessageBroker
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.coroutines.runBlocking

class RestController {

    private val listeners = mutableMapOf<String, (String, response: (((String) -> Unit)?)) -> Unit>()

    init {
        Thread { createServer() }.start()
    }

    private fun createServer() {
        embeddedServer(Netty, port = 8000) {
            routing {
                get ("/request") {
                    val channel = call.parameters["channel"] ?: ""
                    val content = call.parameters["content"] ?: ""
                    onRequest(channel, content) {
                        call.respondText(it)
                    }
                }
            }
        }.start(wait = true)
    }

    private suspend fun onRequest(channel: String, content: String, block: suspend (String) -> Unit) {
        listeners[channel]?.invoke(content) { runBlocking { block(it) } }
    }

    fun observe(queueName: String, block: (String, response: (((String) -> Unit)?)) -> Unit) {
        listeners[queueName] = block
    }
}