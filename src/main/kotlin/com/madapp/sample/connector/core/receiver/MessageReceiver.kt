package com.madapp.sample.connector.core.receiver

import com.google.gson.Gson

abstract class MessageReceiver {
    fun <P, R> observeRequest(channel: String, classOf: Class<P>, block: ((P, ((R) -> Unit)?) -> Unit)? = null) {
        val gson = Gson()
        observeRaw(channel) { request, response ->
            block?.invoke(gson.fromJson(request, classOf)) {
                response?.invoke(gson.toJson(it))
            }
        }
    }

    abstract fun observeRaw(channel: String, block: (String, ((String) -> Unit)?) -> Unit)
}

inline fun <reified P, R> MessageReceiver.observe(channel: String, noinline block: (P, ((R) -> Unit)?) -> Unit) {
    observeRequest(channel, P::class.java) { request, response ->  block(request, response) }
}

inline fun <reified P> MessageReceiver.observe(channel: String) {
    observeRequest<P, Unit>(channel, P::class.java)
}