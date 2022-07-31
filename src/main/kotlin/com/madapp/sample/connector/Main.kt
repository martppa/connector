package com.madapp.sample.connector

import com.madapp.sample.connector.product.ProductService
import com.madapp.sample.connector.sales.SalesService

fun main() {

    val sales = SalesService()
    val product = ProductService()

    Thread { sales.start() }.start()
    Thread { product.start() }.start()
}