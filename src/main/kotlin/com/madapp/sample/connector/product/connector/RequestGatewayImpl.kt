package com.madapp.sample.connector.product.connector

import com.madapp.sample.connector.core.receiver.builder.buildReceiver
import com.madapp.sample.connector.core.receiver.observe
import com.madapp.sample.connector.product.connector.model.ProductAtConnector

internal class RequestGatewayImpl : RequestGateway {

    private val receiver = buildReceiver()

    override fun onGetProductById(block: (String, (ProductAtConnector) -> Unit) -> Unit) {
        receiver.observe<String, ProductAtConnector>(Channels.GetProductById) { request, response ->
            block(request) { response?.invoke(it) }
        }
    }
}