package com.madapp.sample.connector.product.connector

import com.madapp.sample.connector.core.emitter.Payload
import com.madapp.sample.connector.core.emitter.builder.buildEmitter
import com.madapp.sample.connector.core.emitter.request
import com.madapp.sample.connector.product.connector.model.Product

internal class ProductServiceImpl : ProductService {

    private val emitter = buildEmitter()

    override suspend fun getProduct(id: String): Product {
        return emitter.request(Payload(Channels.GetProductById, id))
    }
}