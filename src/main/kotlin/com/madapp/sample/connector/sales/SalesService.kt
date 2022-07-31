package com.madapp.sample.connector.sales

import com.madapp.sample.connector.product.connector.builder.buildProductConnector
import kotlinx.coroutines.runBlocking

class SalesService {

    private val productService = buildProductConnector()

    fun start() {
        println("Sales service has started")
        val product = runBlocking { productService.getProduct("0123") }
    }
}