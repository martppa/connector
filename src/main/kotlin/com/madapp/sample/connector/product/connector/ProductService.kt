package com.madapp.sample.connector.product.connector

import com.madapp.sample.connector.product.connector.model.Product

interface ProductService {
    suspend fun getProduct(id: String): Product
}