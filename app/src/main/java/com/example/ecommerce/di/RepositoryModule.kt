package com.example.ecommerce.di

import com.example.ecommerce.data.repository.products.ProductsDataSource
import com.example.ecommerce.data.repository.products.ProductsDataSourceImpl
import com.example.ecommerce.data.repository.products.ProductsRepository
import com.example.ecommerce.data.repository.products.ProductsRepositoryImpl
import com.example.ecommerce.data.repository.products.ProductsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providesProductsDataSource(productsService: ProductsService): ProductsDataSource {
        return ProductsDataSourceImpl(productsService)
    }

    @Provides
    @Singleton
    fun providesProductsRepository(productsDataSource: ProductsDataSource): ProductsRepository {
        return ProductsRepositoryImpl(productsDataSource)
    }

}