package com.madapp.sample.connector.product

import com.madapp.sample.connector.product.connector.builder.buildProductGateway
import com.madapp.sample.connector.product.connector.model.ProductAtConnector
import com.madapp.sample.connector.product.model.ProductAtService
import com.madapp.sample.connector.product.model.transform

class ProductService {

    private val gateway = buildProductGateway()

    fun start() {
        println("Product: Service has started")
        gateway.onGetProductById(::onProductRequested)
    }

    private fun onProductRequested(productId: String, respond: (ProductAtConnector) -> Unit) {
        println("Product: Product by id requested using id: $productId")
        val product = findProduct(productId)
        respond(product.transform())
    }

    private fun findProduct(productId: String): ProductAtService {
        return ProductAtService("0123", "Gaming Chair", 99F)
    }
}