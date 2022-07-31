package com.madapp.sample.connector.product.connector.builder

import com.madapp.sample.connector.product.connector.ProductService
import com.madapp.sample.connector.product.connector.ProductServiceImpl

fun buildProductConnector(): ProductService {
    return ProductServiceImpl()
}