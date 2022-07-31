package com.madapp.sample.connector

import com.madapp.sample.connector.product.ProductService
import com.madapp.sample.connector.sales.SalesService

fun main() {

    val sales = SalesService()
    val product = ProductService()

    Thread { product.start() }.start()
    Thread.sleep(2000) // Await for everything to set up
    Thread { sales.start() }.start()
}