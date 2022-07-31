package com.madapp.sample.connector.product.connector.builder

import com.madapp.sample.connector.product.connector.ProductService
import com.madapp.sample.connector.product.connector.ProductServiceImpl
import com.madapp.sample.connector.product.connector.RequestGateway
import com.madapp.sample.connector.product.connector.RequestGatewayImpl

fun buildProductConnector(): ProductService {
    return ProductServiceImpl()
}

fun buildProductGateway(): RequestGateway {
    return RequestGatewayImpl()
}
