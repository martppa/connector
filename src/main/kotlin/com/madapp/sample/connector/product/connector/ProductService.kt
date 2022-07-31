package com.madapp.sample.connector.product.connector

import com.madapp.sample.connector.product.connector.model.ProductAtConnector

interface ProductService {
    suspend fun getProduct(id: String): ProductAtConnector
}