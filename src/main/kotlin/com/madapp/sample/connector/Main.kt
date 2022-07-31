package com.madapp.sample.connector

import com.madapp.sample.connector.sales.SalesService

fun main() {

    val sales = SalesService()

    sales.start()
}