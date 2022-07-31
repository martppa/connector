package com.madapp.sample.connector.product.model

import com.madapp.sample.connector.product.connector.model.ProductAtConnector

data class ProductAtService(
    val id: String,
    val name: String,
    val price: Float
)

fun ProductAtService.transform(): ProductAtConnector = ProductAtConnector(id, name, price)