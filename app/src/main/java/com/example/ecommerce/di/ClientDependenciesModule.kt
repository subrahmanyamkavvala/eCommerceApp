package com.example.ecommerce.di

import com.example.ecommerce.data.repository.orders.OrdersService
import com.example.ecommerce.data.repository.products.ProductsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object ClientDependenciesModule {
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient().newBuilder().addInterceptor(loggingInterceptor).build()

    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    fun provideRetrofitInstance(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {

        return Retrofit.Builder()
            .baseUrl("https://fake-store-api.mock.beeceptor.com/")
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Provides
    fun provideProductService(retrofit: Retrofit): ProductsService =
        retrofit.create(ProductsService::class.java)

    @Provides
    fun provideOrdersService(retrofit: Retrofit): OrdersService =
        retrofit.create(OrdersService::class.java)
}