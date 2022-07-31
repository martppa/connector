package com.madapp.sample.connector.sales

import com.madapp.sample.connector.product.connector.factory.ProductServiceFactory

class SalesService {

    private val connector = ProductServiceFactory.create()

    fun start() {
        println("Sales service has started")
    }
}