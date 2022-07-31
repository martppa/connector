package com.madapp.sample.connector.product

import com.madapp.sample.connector.product.connector.RequestGateway
import com.madapp.sample.connector.product.connector.builder.buildProductGateway
import com.madapp.sample.connector.product.connector.model.ProductAtConnector

class ProductService {

    private val gateway = buildProductGateway()

    fun start() {
        println("Product: Service has started")
        gateway.onGetProductById(::onProductRequested)
    }

    private fun onProductRequested(productId: String, respond: (ProductAtConnector) -> Unit) {
        println("Product: Product by id requested using id: $productId")
        val product = findProduct(productId)
        respond(product)
    }

    private fun findProduct(productId: String): ProductAtConnector {
        return ProductAtConnector("0123", "Gaming Chair", 99F)
    }
}