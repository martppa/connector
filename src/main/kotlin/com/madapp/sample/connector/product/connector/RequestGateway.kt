package com.madapp.sample.connector.product.connector

import com.madapp.sample.connector.core.receiver.builder.buildReceiver
import com.madapp.sample.connector.core.receiver.observe
import com.madapp.sample.connector.product.connector.model.Product

class RequestGateway {

    private val receiver = buildReceiver()

    fun onGetProductById(block: (String, (Product) -> Unit) -> Unit) {
        receiver.observe<String, Product>(Channels.GetProductById) { request, response ->
            block(request) { response?.invoke(it) }
        }
    }
}