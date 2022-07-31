package com.madapp.sample.connector.core.emitter

open class Payload<T>(
    val channel: String,
    val body: T
)