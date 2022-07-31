package com.madapp.sample.connector.product

import com.madapp.sample.connector.product.connector.RequestGateway
import com.madapp.sample.connector.product.connector.model.Product

class ProductService {

    private val gateway = RequestGateway()

    fun start() {
        println("Product: Service has started")
        gateway.onGetProductById(::onProductRequested)
    }

    private fun onProductRequested(productId: String, respond: (Product) -> Unit) {
        println("Product: Product by id requested using id: $productId")
        val product = findProduct(productId)
        respond(product)
    }

    private fun findProduct(productId: String): Product {
        return Product("0123", "Gaming Chair", 99F)
    }
}