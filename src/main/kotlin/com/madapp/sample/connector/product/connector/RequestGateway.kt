package com.madapp.sample.connector.product.connector

import com.madapp.sample.connector.product.connector.model.ProductAtConnector

interface RequestGateway {
    fun onGetProductById(block: (String, (ProductAtConnector) -> Unit) -> Unit)
}