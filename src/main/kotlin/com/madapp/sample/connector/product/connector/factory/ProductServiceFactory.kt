package com.madapp.sample.connector.product.connector.factory

import com.madapp.sample.connector.product.connector.ProductService
import com.madapp.sample.connector.product.connector.ProductServiceImpl

object ProductServiceFactory {
    fun create(): ProductService {
        return ProductServiceImpl()
    }
}