package com.example.ecommerce.di

import com.example.ecommerce.data.repository.products.ProductsDataSource
import com.example.ecommerce.data.repository.products.ProductsDataSourceImpl
import com.example.ecommerce.data.repository.products.ProductsRepository
import com.example.ecommerce.data.repository.products.ProductsService
import com.example.ecommerce.domain.mappers.GetProductListUsecase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseDIModule {
    @Provides
    @Singleton
    fun providegetProductListUseCase(productsRepository: ProductsRepository): GetProductListUsecase {
        return GetProductListUsecase(productsRepository)
    }
}