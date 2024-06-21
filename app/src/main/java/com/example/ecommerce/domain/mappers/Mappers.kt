package com.example.ecommerce.domain.mappers

interface EntityMapper<in DTO, out DOMAIN> {
    fun map(dto : DTO?) : DOMAIN?
}